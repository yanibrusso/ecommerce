package com.platform.ecommerce.services;

import com.platform.ecommerce.dtos.PricesRequestDto;
import com.platform.ecommerce.dtos.PricesResponseDto;
import com.platform.ecommerce.entity.BrandsEntity;
import com.platform.ecommerce.entity.PriceEntity;
import com.platform.ecommerce.repository.BrandsRepository;
import com.platform.ecommerce.repository.PriceRepositoy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Qualifier("PriceService")
public class PricesServicesImpl implements PriceService {

    @Autowired
    private PriceRepositoy priceRepositoy;

    @Autowired
    private BrandsRepository brandsRepository;


    @Override
    public PricesResponseDto getPriceByBrand(PricesRequestDto pricesRequestDto) throws Exception {
        List<PriceEntity> priceEntity;
        PriceEntity price;

        priceEntity = priceRepositoy.getPrice(pricesRequestDto.getAplicationDate(), pricesRequestDto.getProductId(), pricesRequestDto.getBrandId());
        if (priceEntity.isEmpty()) {
            log.error("[getPriceByBrand] price not obtained", pricesRequestDto);
            throw new Exception();
        }
        price = priceEntity.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(PriceEntity::getPriority)))
                .get();

        Optional<BrandsEntity> brandsEntity = brandsRepository.getBrand(pricesRequestDto.getBrandId());
        if (!brandsEntity.isPresent()) {
            log.error("[getPriceByBrand] brand not obtained", pricesRequestDto);
            throw new Exception();
        }
        return getMapper(price,brandsEntity);
    }



    private PricesResponseDto getMapper( PriceEntity priceEntity,Optional<BrandsEntity> brandsEntity) {

        PricesResponseDto pricesResponseDto = new PricesResponseDto();
        pricesResponseDto.setProductId(priceEntity.getProductId());
        pricesResponseDto.setBrandId(priceEntity.getBrandId());
        pricesResponseDto.setBrandName(brandsEntity.get().getBrandName());
        pricesResponseDto.setPriceList(priceEntity.getPriceList());
        pricesResponseDto.setPrice(Double.valueOf(priceEntity.getPrice()));
        pricesResponseDto.setStartDate(priceEntity.getStartDate());
        pricesResponseDto.setEndDate(priceEntity.getEndDate());
        return pricesResponseDto;
    }

}

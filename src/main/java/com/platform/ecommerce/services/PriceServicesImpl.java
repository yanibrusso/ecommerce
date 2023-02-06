package com.platform.ecommerce.services;


import com.platform.ecommerce.dao.PriceDaoImpl;
import com.platform.ecommerce.dtos.PriceRequestDto;
import com.platform.ecommerce.dtos.PriceResponseDto;
import com.platform.ecommerce.entity.PriceEntity;
import com.platform.ecommerce.excepions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Qualifier("PriceService")
public class PriceServicesImpl implements PriceService {

    @Autowired
    private PriceDaoImpl priceDao;

    @Override
    public PriceResponseDto getPriceByBrand(PriceRequestDto pricesRequestDto) throws Exception {
        List<PriceEntity> priceEntity;
        PriceEntity price;

        try {
            priceEntity = priceDao.getPrice(pricesRequestDto.getAplicationDate(), pricesRequestDto.getProductId(), pricesRequestDto.getBrandId());
        }catch (NotFoundException e){
            log.error("[getPriceByBrand] price not obtained", pricesRequestDto);
            throw new NotFoundException();
        }

        price = priceEntity.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(PriceEntity::getPriority)))
                .get();

        return getMapper(price);
    }



    private PriceResponseDto getMapper(PriceEntity priceEntity) {
        PriceResponseDto pricesResponseDto = PriceResponseDto.builder()
                .productId(priceEntity.getProductId())
                .brandId(priceEntity.getBrandId())
                .priceList(priceEntity.getPriceList())
                .price(Double.valueOf(Math.round(priceEntity.getPrice() * 100.0) / 100.0))
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .build();
        return pricesResponseDto;
    }

}
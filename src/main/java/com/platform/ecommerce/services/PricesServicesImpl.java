package com.platform.ecommerce.services;

import com.platform.ecommerce.dtos.PricesRequestDto;
import com.platform.ecommerce.dtos.PricesResponseDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PriceService")
public class PricesServicesImpl implements PriceService {


    @Override
    public PricesResponseDto getPriceByBrand(PricesRequestDto pricesRequestDto) {
        return null;
    }
}

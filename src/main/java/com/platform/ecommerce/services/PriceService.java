package com.platform.ecommerce.services;

import com.platform.ecommerce.dtos.PriceRequestDto;
import com.platform.ecommerce.dtos.PriceResponseDto;


public interface PriceService {


    PriceResponseDto getPriceByBrand(PriceRequestDto pricesRequestDto) throws Exception;
}

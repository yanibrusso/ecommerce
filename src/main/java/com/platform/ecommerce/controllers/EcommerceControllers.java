package com.platform.ecommerce.controllers;

import com.platform.ecommerce.dtos.PriceRequestDto;
import com.platform.ecommerce.dtos.PriceResponseDto;
import com.platform.ecommerce.services.PriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;



@RestController
@RequestMapping(path = "/v1/")
public class EcommerceControllers {

    @Autowired
    PriceService priceService;

    @GetMapping(path = "/price")
    public ResponseEntity<?> getPrice(@RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime date,
                                      @RequestParam(value = "productId", required = true)  Integer productId,
                                      @RequestParam(value = "brandId", required = true)  Integer brandId) throws Exception {
        PriceRequestDto priceDto = new PriceRequestDto(date,productId,brandId );
        PriceResponseDto pricesResponseDto;
        pricesResponseDto = priceService.getPriceByBrand(priceDto);
        return new ResponseEntity<>(pricesResponseDto, HttpStatus.OK);
    }
}
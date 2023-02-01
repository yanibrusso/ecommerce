package com.platform.ecommerce.controllers;

import com.platform.ecommerce.dtos.PricesRequestDto;
import com.platform.ecommerce.dtos.PricesResponseDto;
import com.platform.ecommerce.services.PriceService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EcommerceControllers {

    @Autowired
    PriceService priceService;

    @GetMapping(path = "/price/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> getPrice(@RequestBody(required = true) Date aplication_date, @RequestBody(required = true) Integer product_id,
                                      @RequestBody(required = true) Integer brand_id) {
        PricesRequestDto priceDto = new PricesRequestDto(aplication_date, product_id,brand_id);
        PricesResponseDto pricesResponseDto = new PricesResponseDto();
        pricesResponseDto = priceService.getPriceByBrand(priceDto);
        return new ResponseEntity<>(pricesResponseDto, HttpStatus.OK);
    }

}

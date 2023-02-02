package com.platform.ecommerce.controllers;

import com.platform.ecommerce.dtos.PricesRequestDto;
import com.platform.ecommerce.dtos.PricesResponseDto;
import com.platform.ecommerce.services.PriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping(path = "/v1/")
public class EcommerceControllers {

    @Autowired
    PriceService priceService;

    @GetMapping(path = "/price")
    public ResponseEntity<?> getPrice(@RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Valid LocalDateTime date,
                                      @RequestParam(value = "productId", required = true) @Valid Integer productId,
                                      @RequestParam(value = "brandId", required = true) @Valid Integer brandId) throws Exception {
        PricesRequestDto priceDto = new PricesRequestDto(date,productId,brandId );
        PricesResponseDto pricesResponseDto;
        pricesResponseDto = priceService.getPriceByBrand(priceDto);
        return new ResponseEntity<>(pricesResponseDto, HttpStatus.OK);
    }
}
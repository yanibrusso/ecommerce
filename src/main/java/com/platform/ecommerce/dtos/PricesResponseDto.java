package com.platform.ecommerce.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PricesResponseDto implements Serializable {

     private Long productId;
     private Integer brandId;
     private String brandName;
     private Double priceList;
     private LocalDateTime startDate;
     private LocalDateTime endDate;
     private Double price;


}

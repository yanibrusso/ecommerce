package com.platform.ecommerce.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class PriceResponseDto implements Serializable {

     private Long productId;
     private Integer brandId;
     private Integer priceList;
     private LocalDateTime startDate;
     private LocalDateTime endDate;
     private Double price;


}

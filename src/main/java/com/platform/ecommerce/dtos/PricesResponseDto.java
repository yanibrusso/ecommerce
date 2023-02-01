package com.platform.ecommerce.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PricesResponseDto implements Serializable {

     private Long product_id;
     private Integer brand_id;
     private Double price_list;
     private Date aplication_date;
     private Double price;

}

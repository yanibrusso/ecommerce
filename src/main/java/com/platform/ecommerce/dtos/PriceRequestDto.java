package com.platform.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class PriceRequestDto implements Serializable {

    @JsonProperty("aplication_date")
    private LocalDateTime aplicationDate;
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("brand_id")
    private Integer brandId;

    public PriceRequestDto(LocalDateTime aplicationDate, Integer productId, Integer brandId) {
        this.aplicationDate = aplicationDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public PriceRequestDto(){
    }
}


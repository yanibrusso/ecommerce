package com.platform.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PricesRequestDto implements Serializable {

    @JsonProperty("aplication_date")
    private LocalDateTime aplicationDate;
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("brand_id")
    private Integer brandId;

    public PricesRequestDto(LocalDateTime aplicationDate, Integer productId, Integer brandId) {
        this.aplicationDate = aplicationDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public PricesRequestDto(){
    }
}


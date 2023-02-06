package com.platform.ecommerce.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class ErrorDao {

    private int code;
    private String message;

}

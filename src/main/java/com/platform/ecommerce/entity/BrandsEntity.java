package com.platform.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.platform.ecommerce.utils.Constants.BRAND_TABLE_NAME;

@Getter
@Setter
@Entity
@Table(name=BRAND_TABLE_NAME)
public class BrandsEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand_name",length = 6)
    private String brandName;

}

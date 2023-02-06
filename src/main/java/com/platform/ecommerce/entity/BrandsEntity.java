package com.platform.ecommerce.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.platform.ecommerce.utils.Constants.*;

@Getter
@Setter
@Entity
@Table(name=BRAND_TABLE_NAME)
public class BrandsEntity {

    @Id
    @Column(name = ID_BRAND)
    private Integer id;

    @Column(name = BRAND_NAME,length = 6)
    private String brandName;

}


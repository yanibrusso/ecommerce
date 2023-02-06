package com.platform.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.platform.ecommerce.utils.Constants.*;
import static com.platform.ecommerce.utils.Constants.PRICE;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name=PRICE_TABLE_NAME)
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=ID_PRICE)
    Long id;

    @Column(name = BRAND_ID)
    private Integer brandId;

    @Column(name = CURR,length = 3)
    private String curr;

    @Column(name = START_DATE)
    private LocalDateTime startDate;

    @Column(name = EDD_DATE)
    private LocalDateTime endDate;

    @Column(name = LIST_PRICE)
    private Integer priceList;

    @Column(name = PRODUCT_ID)
    private Long productId;

    @Column(name = PRIORITY)
    private Integer priority;

    @Column(name = PRICE)
    private Float price;


}


package com.platform.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.platform.ecommerce.utils.Constants.PRICE_TABLE_NAME;

@Getter
@Setter
@Entity
@Table(name=PRICE_TABLE_NAME)
public class PriceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "curr",length = 3)
    private String curr;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Double priceList;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private Float price;

}

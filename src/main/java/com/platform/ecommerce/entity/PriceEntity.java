package com.platform.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name="price")
public class PriceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long id;

    @Column(name = "brand_id")
    private Integer brancId;

    @Column(name = "curr",length = 3)
    private String curr;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private Float price;

}

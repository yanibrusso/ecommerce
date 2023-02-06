package com.platform.ecommerce.dao;

import com.platform.ecommerce.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

public interface PriceDao extends JpaRepository<PriceEntity, Integer> {


    List<PriceEntity> getPrice(LocalDateTime date, Integer idProducto, Integer brandId);

}
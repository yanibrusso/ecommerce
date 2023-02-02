package com.platform.ecommerce.repository;

import com.platform.ecommerce.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepositoy extends CrudRepository<PriceEntity, Integer> {

    @Query(value = "select * from PRICE p " +
            "       where p.product_id = :idProducto " +
            "       AND p.brand_id = :brandId " +
            "       AND p.start_date <= :date " +
            "       AND p.end_date > :date ", nativeQuery = true)
    List<PriceEntity> getPrice(@Param("date") LocalDateTime date,
                               @Param("idProducto")Integer idProducto,
                               @Param("brandId")Integer brandId);

}
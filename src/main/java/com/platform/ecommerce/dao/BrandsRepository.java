package com.platform.ecommerce.dao;

import com.platform.ecommerce.entity.BrandsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandsRepository extends CrudRepository<BrandsEntity, Integer> {

    @Query(value = "select * from BRANDS b " +
            "       where b.id = :brandId ", nativeQuery = true)

    Optional<BrandsEntity> getBrand(@Param("brandId")Integer brandId);

}


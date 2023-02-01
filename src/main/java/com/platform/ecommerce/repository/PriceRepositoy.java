package com.platform.ecommerce.repository;

import com.platform.ecommerce.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepositoy extends CrudRepository<PriceEntity, Integer> {

}

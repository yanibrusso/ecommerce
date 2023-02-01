package com.platform.ecommerce.dao;

import com.platform.ecommerce.entity.PriceEntity;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface PriceDao extends CrudRepository<PriceEntity, Integer> {

}

package com.platform.ecommerce.dao;

import com.platform.ecommerce.entity.PriceEntity;
import com.platform.ecommerce.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PriceDaoImpl {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String QUERY_PRICE = "select * from PRICE p " +
            "       where p.product_id = :idProducto " +
            "       AND p.brand_id = :brandId " +
            "       AND p.start_date <= :date " +
            "       AND p.end_date > :date";


    public List<PriceEntity> getPrice(LocalDateTime date,
                                      Integer idProducto,
                                      Integer brandId){

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("date", date);
        param.put("idProducto", idProducto);
        param.put("brandId", brandId);

        List<PriceEntity> resultado = namedParameterJdbcTemplate.query(QUERY_PRICE, param,
                new PriceMapper());

        return resultado;
    }
}

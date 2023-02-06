package com.platform.ecommerce.mapper;

import com.platform.ecommerce.entity.PriceEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static com.platform.ecommerce.utils.Constants.*;


public class PriceMapper implements RowMapper<PriceEntity>{

    @Override
    public PriceEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return   PriceEntity.builder()
                .brandId(rs.getInt(BRAND_ID))
                .curr(rs.getString(CURR))
                .startDate(rs.getObject(START_DATE, LocalDateTime.class))
                .endDate(rs.getObject(EDD_DATE,LocalDateTime.class))
                .priceList(rs.getInt(LIST_PRICE))
                .productId(rs.getLong(PRODUCT_ID))
                .priority(rs.getInt(PRIORITY))
                .price(rs.getFloat(PRICE)).build();

    }
}

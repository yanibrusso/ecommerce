package com.platform.ecommerce.serviceTest;

import com.platform.ecommerce.EcommerceApplication;
import com.platform.ecommerce.dao.PriceDao;
import com.platform.ecommerce.dtos.PriceRequestDto;
import com.platform.ecommerce.dtos.PriceResponseDto;
import com.platform.ecommerce.entity.PriceEntity;
import com.platform.ecommerce.services.PriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = EcommerceApplication.class)
public class PriceServiceTest {

    @Autowired
    PriceService pricesServices;

    @Mock
    PriceDao priceDao;

    @Test
    void whenCallDataReturnOk() throws Exception {

        LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00:00");
        PriceRequestDto priceRequestTest = PriceRequestDto
                .builder().aplicationDate(date)
                .productId(35455)
                .brandId(1).build();


        given(priceDao.getPrice(priceRequestTest.getAplicationDate(),
                priceRequestTest.getProductId(),
                priceRequestTest.getBrandId()))
                .willReturn(getListPrices());

        PriceResponseDto result = pricesServices.getPriceByBrand(priceRequestTest);

        assertNotNull(result);
        Assertions.assertEquals(38.95,result.getPrice());

    }

    @Test
    void whenCallIsEmpty() throws Exception {

        LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00:00");
        PriceRequestDto priceRequestTest = PriceRequestDto
                .builder().aplicationDate(date)
                .productId(21908)
                .brandId(1).build();


        given(priceDao.getPrice(priceRequestTest.getAplicationDate(),
                priceRequestTest.getProductId(),
                priceRequestTest.getBrandId()))
                .willReturn(getListPricesEmpty());

        assertThrows(Exception.class,
                () -> pricesServices.getPriceByBrand(priceRequestTest));

    }

    private List<PriceEntity> getListPricesEmpty() {
        List<PriceEntity> list = new ArrayList<>();
        return list;
    }

    private List<PriceEntity> getListPrices() {
        List<PriceEntity> list = new ArrayList<>();
        LocalDateTime strat1 = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime end1 = LocalDateTime.parse("2022-12-31T23:59:59");
        PriceEntity priceEntity1 = PriceEntity.builder()
                .brandId(1)
                .curr("EUR")
                .startDate(strat1)
                .endDate(end1)
                .priceList(1)
                .productId(35455L)
                .priority(0)
                .price(35.50F).build();
        list.add(priceEntity1);

        LocalDateTime strat2 = LocalDateTime.parse("2020-06-14T15:00:00");
        LocalDateTime end2 = LocalDateTime.parse("2022-06-14T18:30:00");
        PriceEntity priceEntity2 = PriceEntity.builder()
                .brandId(1)
                .curr("EUR")
                .startDate(strat2)
                .endDate(end2)
                .priceList(2)
                .productId(35455L)
                .priority(1)
                .price(25.45F).build();
        list.add(priceEntity2);

        LocalDateTime strat3 = LocalDateTime.parse("2020-06-15T00:00:00");
        LocalDateTime end3 = LocalDateTime.parse("2022-06-15T11:00:00");
        PriceEntity priceEntity3 = PriceEntity.builder()
                .brandId(1)
                .curr("EUR")
                .startDate(strat3)
                .endDate(end3)
                .priceList(3)
                .productId(35455L)
                .priority(1)
                .price(30.50F).build();
        list.add(priceEntity3);

        return list;
    }

}

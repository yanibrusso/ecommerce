package com.platform.ecommerce.controllersTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.ecommerce.EcommerceApplication;
import com.platform.ecommerce.dtos.PriceResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = EcommerceApplication.class)
public class ControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public void test_1_respondeOK() throws JsonProcessingException, Exception {

        ResultActions res = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-06-14T10:00:00&productId=35455&brandId=1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.andReturn());
        Assertions.assertNotNull(res.andReturn().getResponse());
        Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());

        PriceResponseDto pricesResponseDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceResponseDto.class);

        Assertions.assertEquals(35455,pricesResponseDto.getProductId());
        Assertions.assertEquals(1,pricesResponseDto.getBrandId());
        Assertions.assertEquals(1,pricesResponseDto.getPriceList());
        Assertions.assertEquals(35.5,pricesResponseDto.getPrice());

    }

    @Test //  Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public void test_2_respondeOK() throws JsonProcessingException, Exception {

        ResultActions res = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-06-14T16:00:00&productId=35455&brandId=1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.andReturn());
        Assertions.assertNotNull(res.andReturn().getResponse());
        Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());

        PriceResponseDto pricesResponseDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceResponseDto.class);

        Assertions.assertEquals(35455,pricesResponseDto.getProductId());
        Assertions.assertEquals(1,pricesResponseDto.getBrandId());
        Assertions.assertEquals(2,pricesResponseDto.getPriceList());
        Assertions.assertEquals(25.45,pricesResponseDto.getPrice());

    }

    @Test //  Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public void test_3_respondeOK() throws JsonProcessingException, Exception {

        ResultActions res = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-06-14T21:00:00&productId=35455&brandId=1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.andReturn());
        Assertions.assertNotNull(res.andReturn().getResponse());
        Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());

        PriceResponseDto pricesResponseDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceResponseDto.class);

        Assertions.assertEquals(35455,pricesResponseDto.getProductId());
        Assertions.assertEquals(1,pricesResponseDto.getBrandId());
        Assertions.assertEquals(1,pricesResponseDto.getPriceList());
        Assertions.assertEquals(35.5,pricesResponseDto.getPrice());

    }

    @Test //  Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    public void test_4_respondeOK() throws JsonProcessingException, Exception {

        ResultActions res = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-06-15T10:00:00&productId=35455&brandId=1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.andReturn());
        Assertions.assertNotNull(res.andReturn().getResponse());
        Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());

        PriceResponseDto pricesResponseDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceResponseDto.class);

        Assertions.assertEquals(35455,pricesResponseDto.getProductId());
        Assertions.assertEquals(1,pricesResponseDto.getBrandId());
        Assertions.assertEquals(3,pricesResponseDto.getPriceList());
        Assertions.assertEquals(30.5,pricesResponseDto.getPrice());

    }

    @Test //  Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    public void test_5_respondeOK() throws JsonProcessingException, Exception {

        ResultActions res = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-06-16T21:00:00&productId=35455&brandId=1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.andReturn());
        Assertions.assertNotNull(res.andReturn().getResponse());
        Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());

        PriceResponseDto pricesResponseDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceResponseDto.class);

        Assertions.assertEquals(35455,pricesResponseDto.getProductId());
        Assertions.assertEquals(1,pricesResponseDto.getBrandId());
        Assertions.assertEquals(4,pricesResponseDto.getPriceList());
        Assertions.assertEquals(38.95,pricesResponseDto.getPrice());

    }

    @Test
    public void whenNullValuetheReturnus400() throws JsonProcessingException, Exception {

        ResultActions res = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-06-16T21:00:00&productId=35455&brandId=null"))
                .andExpect(status().isInternalServerError() );

    }

    @Test
    void whenCallingProductAndwithNotValidtheReturnus400()throws Exception {
        ResultActions res =   mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=2020-12-31 23:59:59&productId=111&brandId=1"))
                .andExpect(status().isInternalServerError() );
    }

    @Test
    void whenCallingDateIsStringTheReturnus400()throws Exception {
        ResultActions res =   mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/price?date=fecha&productId=35455&brandId=1"))
                .andExpect(status().isInternalServerError() );
    }


}

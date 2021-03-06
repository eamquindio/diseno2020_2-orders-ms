package co.edu.eam.disenosoftware.mitienda.controllers;


import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ShoppingCartControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/controller_create_shopping_cart_product_test.sql"})
  public void createShoppingCartProduct() throws Exception {

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    List<ShoppingCartProduct> shoppingCartProductList = em.createQuery("SELECT s FROM ShoppingCartProduct s WHERE s.shoppingCart.user.username = 'manuelito'").getResultList();
    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductList.get(0);

    Assertions.assertEquals(HttpStatus.OK.value(), status);
    Assertions.assertEquals(1, shoppingCartProductToAssert.getShoppingCart().getId());
    Assertions.assertEquals("manuelito",shoppingCartProductToAssert.getShoppingCart().getUser().getUsername());
  }

  @Test
  @Sql({"/testdata/controller_not_existing_shopping_cart_product_test.sql"})
  public void notExistingShoppingCartTest() throws Exception {

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  @Sql({"/testdata/controller_product_store_does_not_exist_test.sql"})
  public void productStoreDoesNotExistTest() throws Exception {

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }

  @Test
  @Sql({"/testdata/controller_user_does_not_exist_test.sql"})
  public void userDoesNotExistTest() throws Exception {

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);

  }

  @Test
  @Sql({"/testdata/controller_store_does_not_exist_test.sql"})
  public void storeDoesNotExistTest() throws Exception {

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);

  }

  @Test
  @Sql({"/testdata/controllers/delete_to_product_shopping_cart_request.sql"})
  public void deleteProductToShoppingCartRequest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.delete("/api/shopping-cart/1/shopping-cart-product/1");

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  @Sql({"/testdata/controllers/delete_not_exist_to_product_shopping_cart_request.sql"})
  public void ProductNotExistToShoppingCartRequest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.delete("/api/shopping-cart/1/shopping-cart-product/22");

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0001", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/controllers/controller_remove_product_from_shopping_cart_when_shopping_cart_does_not_exist_test.sql"})
  public void controllerRemoveProductFromShoppingCartWhenShoppingCartDoesNotExistTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.delete("/api/shopping-cart/2/shopping-cart-product/1");

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0004", error.getErrorCode());
  }

}

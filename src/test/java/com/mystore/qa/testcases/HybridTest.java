package com.mystore.qa.testcases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.utils.Payload;
import com.mystore.qa.utils.Product;
import com.mystore.qa.utils.Token;
import com.mystore.qa.utils.UserID;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HybridTest extends BaseTest {

    protected String userId;
    protected String token;
    protected String productId;

    protected ProductShettyAcademyPage productShettyAcademyPage;

    @BeforeMethod
    public void addProductToCartTest() {

        Product product = new Product(productId, "iphone 13 pro", "electronics",
                "shirts", 231500, "iphone 13 pro",
                "https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649561326.jpg",
                "0", "0", true, "men", "admin@gmail.com", 0);

        userId = UserID.generateUserId("dimagadjilla@gmail.com", "3036057Dr");
        token = Token.generate("dimagadjilla@gmail.com", "3036057Dr");

        Payload payload = new Payload(userId, product);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String payloadJson = null;
        try {
            payloadJson = mapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String successMessage = "Product Added To Cart";

        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(payloadJson)
                .when().log().all()
                .post("api/ecom/user/add-to-cart")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and().contentType(ContentType.JSON)
                .body("message", equalTo(successMessage));
    }

    @Test
    public void click() throws InterruptedException {
        productShettyAcademyPage = loginToApp("dimagadjilla@gmail.com", "3036057Dr");
        Thread.sleep(9000);
    }

}

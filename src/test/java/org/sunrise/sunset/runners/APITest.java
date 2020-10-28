package org.sunrise.sunset.runners;

import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.sunrise.sunset.demo.utilities.ReadConfigures;

import java.util.List;

import static io.restassured.RestAssured.given;
public class APITest {

    @Test
    public void test(){
        RestAssured.baseURI="https://api.sunrise-sunset.org/json";
        RequestSpecification httpRequest = RestAssured.given();
        Response response =
                given()
                        .queryParam("lat",36.7201600)
                        .queryParam("lng",-4.4203400)
                        .get();
        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.get("results.sunrise"));
        Assert.assertFalse(jsonPath.get("results.sunrise").toString().isEmpty());



    }
}

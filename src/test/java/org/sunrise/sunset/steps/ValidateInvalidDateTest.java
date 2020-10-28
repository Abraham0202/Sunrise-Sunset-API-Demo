package org.sunrise.sunset.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ValidateInvalidDateTest {

    private Response response;
    private RequestSpecification request;
    private JsonPath jsonPath;
    @When("I set lan as {string} and lng as {string} as an area and set date as {string}")
    public void i_set_lan_as_and_lng_as_as_an_area_and_set_date_as(String lat, String lng, String date) {

        request = RestAssured.given();
        response =
                given()
                        .queryParam("lat",lat)
                        .queryParam("lng",lng)
                        .queryParam("date",date)
                        .get();
        jsonPath = response.jsonPath();
    }


    @Then("I receive status as {string} in response")
    public void i_receive_status_as_in_response(String message) {
        int statusCode=response.statusCode();
        String status=jsonPath.get("status").toString();
        Assert.assertEquals(statusCode,400);
        Assert.assertEquals(status,message);
    }

}

package org.sunrise.sunset.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.sunrise.sunset.demo.utilities.GetDate;

import static io.restassured.RestAssured.given;

public class ValidateDefaultTime {

    private Response response;
    private RequestSpecification request;
    private JsonPath jsonPath;


    @Given("I set sunrise service api endpoint")
    public void i_set_sunrise_service_api_endpoint() {
        RestAssured.baseURI="https://api.sunrise-sunset.org/json";

    }

    @When("I set lan as {string} and lng as {string} as an area as an area and data as today")
    public void i_set_lan_as_and_lng_as_as_an_area_as_an_area_and_data_as_today(String lat, String lng) {
        request = RestAssured.given();
        response =
                given()
                        .queryParam("lat",lat)
                        .queryParam("lng",lng)
                        .queryParam("date", GetDate.getToday())
                        .get();
        jsonPath = response.jsonPath();
    }


    @Then("I receive default date as today")
    public void i_receive_default_date_as_today() {
        int statusCode=response.statusCode();
        String sunset=jsonPath.get("results.sunrise").toString();
        Assert.assertEquals(statusCode,200);
        Assert.assertFalse(sunset.isEmpty());
    }

}

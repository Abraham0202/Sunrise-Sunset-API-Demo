package org.sunrise.sunset.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.sunrise.sunset.demo.utilities.GetDate;

import static io.restassured.RestAssured.given;

public class UnfomattedData {

    private Response response;
    private RequestSpecification request;
    private JsonPath jsonPath;

    @When("I set lan as {string} and lng as {string} as an area and set formatted type as {string}")
    public void i_set_lan_as_and_lng_as_as_an_area_and_set_formatted_type_as(String lat, String lng, String type) {

        request = RestAssured.given();
        response =
                given()
                        .queryParam("lat",lat)
                        .queryParam("lng",lng)
                        .queryParam("formatted","0")
                        .get();
        jsonPath = response.jsonPath();
    }

    @Then("I receive response with unformatted data")
    public void i_receive_response_with_unformatted_data() {

        int statusCode=response.statusCode();
        String sunset=jsonPath.get("results.sunrise").toString();
        Assert.assertEquals(statusCode,200);
        Assert.assertFalse(sunset.contains(GetDate.getToday()));

    }
}

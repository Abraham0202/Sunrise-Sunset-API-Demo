package org.sunrise.sunset.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.sunrise.sunset.demo.utilities.CalculateTimeDifference;

import static io.restassured.RestAssured.given;

public class DayLengthTest {

    private Response response;
    private RequestSpecification request;
    String sunrise;
    String sunset;
    private JsonPath jsonPath;
    @When("I set lan as {string} and lng as {string} as an area to get response")
    public void i_set_lan_as_and_lng_as_as_an_area_to_get_response(String lat, String lng) {
        request = RestAssured.given();
        response =
                given()
                        .queryParam("lat",lat)
                        .queryParam("lng",lng)
                        .get();
        jsonPath = response.jsonPath();
    }

    @When("calculate day length between Sunset and Sunrise")
    public void calculate_day_length_between_sunset_and_sunrise() {

         sunrise=jsonPath.get("results.sunrise").toString();
         sunset=jsonPath.get("results.sunset").toString();


    }
    @Then("Day length should be equal with day_length value as response")
    public void day_length_should_be_equal_with_day_length_value_as_response() {

        String diff=CalculateTimeDifference.calculateTime(sunrise,sunset);
        String day_length=jsonPath.get("results.day_length");
        Assert.assertEquals(day_length,diff);
    }

}

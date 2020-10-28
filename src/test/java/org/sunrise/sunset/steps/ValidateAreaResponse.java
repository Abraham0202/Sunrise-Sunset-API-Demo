package org.sunrise.sunset.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.sunrise.sunset.demo.utilities.ReadConfigures;
import static io.restassured.RestAssured.given;

public class ValidateAreaResponse {
	private Response response;
	private RequestSpecification request;
	private JsonPath jsonPath;


	@Given("I Set sunrise service api endpoint")
	public void i_set_sunrise_service_api_endpoint() {
		RestAssured.baseURI="https://api.sunrise-sunset.org/json";
	}

	@When("I set lan as {string} and lng as {string} as an area and get response")
	public void i_set_lan_as_and_lng_as_as_an_area_and_get_response(String lat, String lng) {
		request = RestAssured.given();
		 response =
				given()
						.queryParam("lat",lat)
						.queryParam("lng",lng)
						.get();
		jsonPath = response.jsonPath();
	}
	@Then("I receive successfull response with sunrise and sunset time")
	public void i_receive_successfull_response_with_sunrise_and_sunset_time() {
		int statusCode=response.statusCode();
		String sunset=jsonPath.get("results.sunrise").toString();
		Assert.assertEquals(statusCode,200);
		Assert.assertFalse(sunset.isEmpty());
	}

}

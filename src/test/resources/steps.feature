@api
Feature: Sunrise Sunset API Testing

  Scenario: Validate specific area response
    Given I Set sunrise service api endpoint
    When  I set lan as "36.7201600" and lng as "-4.4203400" as an area and get response
    Then 	I receive successfull response with sunrise and sunset time

    Scenario: Validate the default date as today
      Given I set sunrise service api endpoint
      When  I set lan as "36.7201600" and lng as "-4.4203400" as an area as an area and data as today
      Then I receive default date as today


  Scenario: Validate the response is unformatted data
    Given I set sunrise service api endpoint
    When I set lan as "36.7201600" and lng as "-4.4203400" as an area and set formatted type as "0"
    Then I receive response with unformatted data

  Scenario: Validate the response is unformatted data
    Given I set sunrise service api endpoint
    When I set lan as "36.7201600" and lng as "-4.4203400" as an area and set date as "2020-10-32"
    Then I receive status as "INVALID_DATE" in response


  Scenario: Validate the accuracy of the time between sunrise and sunset
    Given I set sunrise service api endpoint
    When I set lan as "36.7201600" and lng as "-4.4203400" as an area to get response
    And calculate day length between Sunset and Sunrise
    Then Day length should be equal with day_length value as response
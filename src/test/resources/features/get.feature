Feature: A user gets resources
  Scenario: A user gets a non-existent resource
    Given I know that a resource does not exist
    When I navigate to the non-existent resource
    Then I see that I get a 404 status
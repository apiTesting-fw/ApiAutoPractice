Feature: Test Github API

Scenario: The Github user can Create and Delete repository by API.
    Given I get Github owner ID
    When I create a Github repository
    Then I delete repository

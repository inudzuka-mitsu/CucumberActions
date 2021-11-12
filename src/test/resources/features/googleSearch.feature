Feature: Google Search

  Scenario: Search Google
    Given I am on Google search page
    When I search for "apple"
    Then I see title contains "apple"
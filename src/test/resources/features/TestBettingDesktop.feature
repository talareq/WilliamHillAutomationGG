Feature: Access williamhill website
  Use selenium java with cucumber-jvm and place a bet


  Scenario: I pounds for any football match on a choosen enviroment
    Given I want to use the enviroment Desktop
    When I open williamhill website
    Then I login as "testergg" with password "geodezja00" and check the id "90653NF"
    When I select any match
    Then I select any odd
    And I bet for "0.05" pounds
    Then I check my betting "0.05" pounds
Feature: Petstore find pet name test case

Scenario: Get response from API
  Given I execute GET method
  Then  I verify the response




Scenario: Get response from mock api
   Given I execute get method with mock
   Then I verify mock response


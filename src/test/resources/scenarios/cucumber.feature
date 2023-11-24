Feature: Negative tests

  Background: I staying on main page
    Given I open page "https://testfortesting.online-loans.ph"

  Scenario: Is error exist after set value only in Full Name field
    When I set value "Ivan" in field "first_name"
    When I set value "Ivanovich" in field "middle_initial"
    When I set value "Ivanov" in field "last_name"
    When I click on submit button
    Then I see error "This field is required." in field "mobile_phone"

  Scenario: Is error exist after wrong scrolling money slider
    When I click "4" time on plus button in slider "Amount"
    Then I see error "This amount is available to repeat borrowers only" under "credit" slider
    When I click "1" time on plus button in slider "Term"
    Then I see error "This term is available to repeat borrowers only" under "term" slider

  Scenario: Is error exist after wrong value in Mobile Phone field
    When I set value "Ivan" in field "first_name"
    When I set value "Ivanovich" in field "middle_initial"
    When I set value "Ivanov" in field "last_name"
    When I set value "07917771946" in field "mobile_phone"
    When I click on submit button
    Then I see error "Should start with \"09\"" in field "mobile_phone"
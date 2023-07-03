@new
Feature: Some of the general functionality verifications

  Scenario:Dropdown option verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

    Scenario: Payment options verifications
      Given user is already logged in to The Web table app
      When user is on the Order page
      Then user sees VISA as enable payment options
      Then user sees MasterCard as enable payment options
      Then user sees American Express as enable payment options

  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters quantity "2"
    Then user clicks to the calculate button
    And user enters customer name "Jane Doe"
    And user enters street "7th Street"
    And user enters city "New York"
    And user enters state "New York"
    And user enters zip "9999"
    And user selects payment options "American Express"
    And user enters card number "1111222233334444"
    And user enters expiration date "12/25"
    And user clicks to process order button
    Then user should see "Jane Doe" in the first row of the web table




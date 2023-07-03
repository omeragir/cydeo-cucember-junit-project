
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
  @new
  Scenario Outline : Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters quantity "<quantity>"
    Then user clicks to the calculate button
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user selects payment options "<paymentType>"
    And user enters card number "<cardNumber>"
    And user enters expiration date "<expDate>"
    And user clicks to process order button
    Then user should see "<expectedName>" in the first row of the web table

    Examples:
      | quantity | customerName | street | city | state | zip   | paymentType | cardNumber       | expDate | expectedName |
      | 3        | John Doe     | 7th st | NY   | Ny    | 99999 | Visa        | 1111222233334444 | 12/25   | John Doe     |
      | 3        | Jane Doe     | 7th st | NY   | Ny    | 99999 | Visa        | 1111222233334444 | 12/25   | Jane Doe     |
      | 3        | Jack Doe     | 7th st | NY   | Ny    | 99999 | Visa        | 1111222233334444 | 12/25   | Jack Doe     |
      #| 3        | Jen Doe      | 7th st | NY   | Ny    | 99999 | Visa        | 1111222233334444 | 12/25   | Jen Doe      |
      #| 3        | Mike Doe     | 7th st | NY   | Ny    | 99999 | Visa        | 1111222233334444 | 12/25   | Mike Doe     |
      #| 3        | Emily Doe    | 7th st | NY   | Ny    | 99999 | Visa        | 1111222233334444 | 12/25   | Emily Doe    |



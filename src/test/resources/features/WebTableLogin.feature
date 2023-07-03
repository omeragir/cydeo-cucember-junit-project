Feature: Web table app login functionality
  Agile story: User should be able to login with correct credentials

  Scenario: Positive login scenario
    Given user is on the  Web Table app login page
    When user enters correct username
    And user enters correct password
    And user clicks to login button
    Then user should see orders word in the URL

  Scenario: Positive login scenario
    Given user is on the  Web Table app login page
    When user enters "Test" username and user enters "Tester" password
    And user clicks to login button
    Then user should see orders word in the URL

  Scenario: Positive login scenario
    Given user is on the  Web Table app login page
    When user enters belows correct credentials
      | username | Test   |
      | password | Tester |
    And user clicks to login button
    Then user should see orders word in the URL
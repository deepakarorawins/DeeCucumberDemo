Feature: Login iOS

  Scenario: Login with correct username and password via ios app
  As a user I should be able to login successfully with valid username and password via ios app

    Given I Launch the ios app
    And I click on SignIn ios
    And I enter username ios "deemet@mailinator.com"
    And I enter password ios "miP4cvma"
    And I click on SignIn Button ios
    #And I navigateBack
    Then I see inventory screen ios "Inventory"
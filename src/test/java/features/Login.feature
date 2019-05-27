Feature: Login Android and Web

  @addOtherTool
  Scenario: Login with correct username and password via android app
    As a user I should be able to login successfully with valid username and password via android app

    Given I Launch the app
    And I click on SignIn
    And I enter username "deemet@mailinator.com"
    And I enter password "miP4cvma"
    And I click on SignIn Button
    And I navigateBack
    Then I see inventory screen "Inventory"

    And I click on Add Item
    And I click on Other Items
    #And I click on turn on location
    #And I click on allow
    And I choose as manufacturer "OKAUTO - ONEKEY"
    And I enter description "My Description"
    And I enter model numbber "2146-20"
    And I click on save
    Then I should see tool added to inventory "2146-20"






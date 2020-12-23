Feature: User Endpoint

  @sign-in
  Scenario: Users should be able to sign in to the application
    Given user provides valid user data to sign in
    When user request to sign in to the application
    Then user should get 200 response from the source
    And a response should contain user information

  @sign-up
  Scenario: Users should be able to sign up to the application
    Given user provides valid user data to sign up
    When user request to sign up to the application
    Then user should get 200 response from the source
    And a response should contain user information

  @errors
  Scenario: Users should get an error on sign in when invalid data provided
    Given user provides invalid user data to login
    When user request to sign in to the application
    Then user should get 500 response from the source
    And "Cannot read property 'email' of null" error is returned

  @errors
  Scenario: Users should get an error on sign in when missing email provided
    Given user provides user data without email address
    When user request to sign in to the application
    Then user should get 422 response from the source
    And "can't be blank" email error is returned

  @errors
  Scenario: Users should get an error on sign in when missing password provided
    Given user provides user data without password
    When user request to sign in to the application
    Then user should get 422 response from the source
    Then "can't be blank" password error is returned

  @errors
  Scenario: Users should get an error on sign in when already taken username provided
    Given user provides user data already exist in the application
    When user request to sign up to the application
    Then user should get 422 response from the source
    Then "is already taken." username error is returned

  @sign-up
  Scenario: Users should get an error on sign up when missing email provided
    Given user provides user data without email address
    When user request to sign up to the application
    Then user should get 422 response from the source
    Then "can't be blank" email error is returned

  @sign-up
  Scenario: Users should get an error on sign up when invalid data provided
    Given user provides invalid user data to login
    When user request to sign up to the application
    Then user should get 500 response from the source
    And "Cannot read property 'username' of null" error is returned

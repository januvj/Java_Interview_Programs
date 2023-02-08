Feature: Login The Orange Application
Scenario: Login Page
Given user Launch The Application
When user Get The Username In The Application
And user Get The Password In The Application
And user Enter The UserName In the Field
And user Enter The Password In the Field
Then user Click The Login Button And Navigate The Next Page


Scenario: Home Page
When user Get The menuOptions

#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Edit New class

  @class
  Scenario: Validate row level edit icon
    Given Admin is on the Manage Class page after login
    When Admin clicks on the edit icon
    Then A new pop up with 'class details' appears

  Scenario: Check disabled  batch name
    ##  Given Admin is on the Manage Class page after login
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled

  Scenario: Check disabled class topic
    ##  Given Admin is on the Manage Class page after login
    When Admin clicks on the edit icon
    Then Admin should see class topic field is disabled
    

 Scenario Outline: Admin edit class Program
  

   When  Admin clicks on the edit icon
   Then  edit class  "<SheetName>"

    
    Examples: 
      |SheetName|
      |Class| 



  Scenario: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the fields with valid data and click save
    Then Admin gets message "class details updated Successfully " and see the updated values in data table

  Scenario: Check if the fields are updated with invalid values
    Given Admin is on the Edit Class Popup window
    When Update the fields with invalid values and click save
    Then Admin should get Error message

  Scenario: Check if the mandatory fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the mandatory fields with valid values and click save
    Then Admin gets message "Class details updated Successfully " and see the updated values in data table

  Scenario: Check if the optional fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the optional fields with valid values and click save
    Then Admin gets message "Class details updated Successfully " and see the updated values in data table

  Scenario: Validate Cancel button on Edit popup
     Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup

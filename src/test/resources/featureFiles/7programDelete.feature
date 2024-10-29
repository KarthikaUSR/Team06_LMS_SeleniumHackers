#Author: Anusuya S

@tag
Feature: 

  @tag1
  Scenario: Verify delete feature 
   Given Admin is on Program module	
   When Admin clicks on delete button for a program
   Then Admin will get confirm deletion popup																			

   Scenario: Verify Admin is able to see deleted program	
   Given Admin is on Program module	
   When  Admin Searches for "Deleted Program name"
   Then  There should be zero results.	
   
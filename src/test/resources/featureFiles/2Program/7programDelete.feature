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
   
   Scenario: Verify Admin is able to click 'No'
   Given Admin is on Program Confirm Deletion Page after selecting a program to delete
   When  Admin clicks on "No" button
   Then Admin can see Confirmation form disappears

  Scenario: Verify Admin is able to close the window with "X" 
  Given Admin is on Program Confirm Deletion Page after selecting any program to delete
  When Admin Clicks on "X" button
  Then Admin can see Confirm Deletion form disappear
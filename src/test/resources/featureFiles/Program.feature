#Author: Anusuya Selvaraj

@sanity
Feature: Navigation and Menu Bar Manage Program Page validation  
      
   
Background: Admin is logged in to LMS Portal
 
    Given  Admin is in login Page
    When   Admin clicks login button after entering valid "username" and valid "password"
    Then  Admin should land in LMS DashBoard Page 

Scenario: Verify that Admin is able to navigate to Program module

    When  Admin clicks "Program" on the navigation bar
    Then  Admin should be navigated to Program module 
  
    
    
    Scenario: Verify any broken links on program page  
     When Admin clicks "Program" on the navigation bar
     Then Admin should not have any broken links for Program module-- Not in scope as discuused with team
     
    Scenario: Verify heading in menu bar
      When Admin clicks "Program" on the navigation bar
      Then Admin should see the heading "LMS - Learning Management System"
   
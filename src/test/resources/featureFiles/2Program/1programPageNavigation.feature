#Author: Anusuya Selvaraj

@Program
Feature: Program Page Navigation -  UI validation 

          Admin successfully Logged on to the  page

 
  @ProgramPageValidation
 
Scenario: Verify that Admin is able to navigate to Program module

    When  Admin clicks "Program" on the navigation bar
    Then  Admin should be navigated to Program module 
     
    
     

      
   
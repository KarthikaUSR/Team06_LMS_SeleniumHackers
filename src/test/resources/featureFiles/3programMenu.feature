#Author: Anusuya Selvaraj

@Program
Feature: Program Menu -  UI validation 

          Admin successfully Logged on to the  page

 
  @ProgramPageValidation
 
Scenario: Verify that Admin is able to navigate to Program module


    When  Admin clicks "Program" on the navigation bar

  Scenario: Verify any broken links on program page  
  
  #   Then Admin should not have any broken links for Program module-- Not in scope as discuused with team
     
    Scenario: Verify heading in menu bar
      Then Admin should see the heading "LMS - Learning Management System"
         
    Scenario: Verify other modules name displayed in menu bar
    Then  Admin should see the module names as in order "Home Program Batch Class Admin Assignment Attendance"
   
   #Expected 7 but founnd 4 only its bug added
   
    Scenario: Verify Logout displayed in menu bar
      Then Admin should see Logout in menu bar
   
    Scenario: Verify sub menu displayed in program menu bar
      Then Admin should see sub menu in menu bar as "Add New Program"
   
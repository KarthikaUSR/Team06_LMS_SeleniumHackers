@ManageProgramSortingProgram
Feature: Manage Program - Sorting Program
 
 Background: Admin is on program module after reaching dashboard
   When Admin clicks Program tab on top right corner of the LMS page
    Then Admin see the Program page is displayed
    
  @ManageProgramSortingProgram1
  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
    
    @ManageProgramSortingProgram2
  Scenario: Verify sorting of  Program Description in  Ascending order/Descending order
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
    
    @ManageProgramSortingProgram3
  Scenario: Verify sorting of Program status in Ascending order/Descending order
    When Admin clicks on Arrow next to Program status
    Then Use See the Program Status is sorted in Ascending order/Descending order
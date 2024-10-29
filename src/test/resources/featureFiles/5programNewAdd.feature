#Author: Anusuya S

@Program
Feature: Add New program
  Creating New Program

  @AddNewProgram
  Scenario Outline: Admin Creating New  Program
 
   Given Admin in Program page
   When  Click Add New Program
   Then  Create New Program <SheetName>

   
    Examples: 
      |SheetName|
      |Program| 
@ManageProgramSearchBar
Feature: Manage Program - Search bar
 
   @ManageProgramSearchBar1
  Scenario: Verify Admin is able to search results found for program name
  	Given Admin is on Program module
    When Admin enter the program to search By program name
    Then Admin should able to see Program name, description, and status for searched program name

  @ManageProgramSearchBar2
  Scenario: Verify Admin is able to search results found for program description
    When Admin enter the program to search By program description
    Then Admin should able to see Program name, description, and status for searched program description
     
  @ManageProgramSearchBar3
  Scenario: Verify Admin is able to search results found for program name
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results.
 
 @ManageProgramSearchBar4
  Scenario: Verify Admin is able to search results found for program name
    When Admin enter the program to search By partial name of program
    Then Admin should able to see Program name, description, and status for searched program name
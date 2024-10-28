@Batch
Feature: Add Batch Popup Validation 
  UI validation of the  Add Batch popup

  @SearchTextBox
  Scenario: Admin in Batch Page
  
    Given Admin in batch page
    When  Enter Text in search TextBox
    Then  Searched text should come on the top of the batch page

@Batch
Feature: Add Batch Popup Validation 
  UI validation of the  Add Batch popup

  @Movetoclasspage
  Scenario: Admin in Batch Page
  
    Given Admin in batch page
    When  Click the Class Page tab
    Then Admin is in Class Page

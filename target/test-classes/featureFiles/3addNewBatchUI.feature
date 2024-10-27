
@Batch
Feature: Add Batch Popup Validation 
  UI validation of the  Add Batch popup

  @AddBatchUI
  Scenario: Admin in Batch Page
  
    When Admin in batch page
    Then Verify sub menu displayed in batch menu bar
    Then Validate Admin able to click on the Add new Batch Option
    

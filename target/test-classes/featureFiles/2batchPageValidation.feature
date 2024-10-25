
@Batch
Feature: Batch Page Validation 
  UI validation of the  Batch page

  @BatchPageValidation
  Scenario: Admin in Batch Page
  
    When Admin in batch page
    Then Validate Title in Batch Page
    Then Validate Heading in Batch Page

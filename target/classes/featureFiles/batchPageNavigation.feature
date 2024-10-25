
@Batch
Feature: Batch Page Navigation 
  Admin successfully Logged on to the  Batch page

  @BatchPage
  Scenario: Admin in Batch Page
   
    When Click Batch tab on top right corner of the LMS page
    Then Verify the Batch page is displayed

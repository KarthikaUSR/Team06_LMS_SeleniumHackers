
@Batch
Feature: Create Batch program
  Creating New Batch Program

  @AddNewBatch
  Scenario Outline: Admin Creating New Batch Program
  
   Given Admin in batch page
   When  Click Add New Batch
   Then  Create New Batches <SheetName>

    
    Examples: 
      |SheetName|
      |Batch| 
 
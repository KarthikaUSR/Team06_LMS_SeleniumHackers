@classPageValidation
Feature: Class Page Validation
 Admin logged on the Dashboard page
 
  
  @classPageValidation1
  Scenario: Validating the class manage page
  When Admin clicks the Class Navigation bar in the Header
  Then Admin should land on the Manage class page 
    
  @classPageValidation2
  Scenario: Validating the Title in the Manage class page
   Then Admin should see the "LMS - Learning Management System" Title
  
  @classPageValidation3
  Scenario: Validating the Header in the Manage class page
  Then Admin should see the "Manage Class" Header
    
  @classPageValidation4
  Scenario: Validating Search bar in class page
  Then Admin should see the Searchbar in Manage class page
   
  @classPageValidation5
  Scenario: Validating the data table headers in the class page
  Then Admin should see the datatable heading like Batchname,class topic,class descrption,status,class Date,staff name,Edit/Delete 
    
  @classPageValidation6
  Scenario: Validating the text and pagination icon in the classpage
  Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table
  
  @classPageValidation7
  Scenario: Validate the sort icon of all the field in datatable
  Then Admin should see the Sort icon of all the field in the datatable.
    
  @classPageValidation8
  Scenario: Validating the Delete button under the Manage class 
  Then Admin should see the Delete button under the Manage class page header.
  
  @classPageValidation9
  Scenario: Validate the total no of classes in manage class page
   Then Admin should see Total no of classes in below of the data table.
    

  
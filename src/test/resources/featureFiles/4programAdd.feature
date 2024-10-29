#Author: Anusuya S

@ProgramAdd
Feature:  Program - Add New Program
          Admin successfully Logged on to the  page

  @AddNewProgram


 Scenario: Verify add New Program
  
    Given Admin is on Program module
    When  Admin clicks on "Add New Program" under the "Program" menu bar
    Then  Admin should see pop up window for program details

  Scenario: Verify title of the pop up window
    Given Admin is on Program module
    When  Admin clicks on "Add New Program" under the "Program" menu bar 
    Then  Admin should see window title as "Program Details"
  
  Scenario: Verify mandatory fields with red "*" mark 
    Given Admin is on Program module
    When  Admin clicks on "Add New Program" under the "Program" menu bar 
    Then  Admin should see red '*' mark beside mandatory field "programName"																
	
	
	  Scenario: Verify empty form submission		
 #	Given  Admin is on program details form																				
#		When   Admin clicks save button without entering mandatory fields
	#	Then   Admin gets message 'Name is required'			
																			
	Scenario: Verify cancel button	
	 Given Admin is on program details form																				
		When Admin clicks Cancel button	
		Then Admin can see Program Details form disappears 	
	
	
	 Scenario: Verify enter program name	
	Given Admin is on program details form																				
	When Admin enters the Name "Test Program" in the text box
  Then Admin can see the text "Test Program" entered
  

 Scenario: Verify enter description		
		Given Admin is on program details form	
		When Admin enters the Description "This is a test description" in text box
    Then Admin can see the text "This is a test description" entered
		
	 Scenario: Verify select Status	
		Given Admin is on program details form	
		When Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
		Then Admin can see 'Active/Inactive' status selected		
																						
  Scenario: Verify Admin is able to save the program details	
		Given Admin is on program details form	
		When Admin enters valid details for mandatory fields and Click on save button
		Then Admin gets message 'Successful Program created'		
		
	 Scenario: Verify cancel program details
	 Given 	Admin is on program details form	
	 When Admin Click on cancel button	
	 Then Admin can see program details form disappear	
	 	
	 Scenario: Verify added Program is created	
		Given Admin is on Program module	
		When  Admin searches with newly created "Program Name"	
		Then  Records of the newly created "Program Name" are displayed and match the data entered	
		
																			
		 Scenario: Verify close window with "X" 	
		 Given Admin is on program details form	
		 When  Admin Click on "X" button	
		 Then  Admin can see program details form disappear		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
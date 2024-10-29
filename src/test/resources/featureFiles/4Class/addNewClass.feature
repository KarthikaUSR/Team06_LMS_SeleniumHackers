@addNewClass
Feature: Add New Class
 Admin Is on the Manage class page after login
    
  @addNewClass1
  Scenario: Validate Class Details Popup window
  	When Admin clicks add new class under the class menu bar.
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window 
    
  @addNewClass2
  Scenario: Validate input fields and their text boxes in Class details form 
    Then Admin should see few input fields and their respective text boxes in the class details window
  
  
#Author: Anusuya Selvaraj


 @sanity
Feature: Verify SignIn Page 
             
   
Background: Admin gives the correct LMS portal URL
 
 Given  Admin is in login Page

Scenario: Verify if user able to signIn valid username and valid password

    When  Admin clicks login button after entering valid "username" and valid "password"
    Then  Admin should land in LMS DashBoard Page 
    
    

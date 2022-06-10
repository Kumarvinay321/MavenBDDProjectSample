Feature: NewAccount Functionality 

Scenario Outline: Verification of New Account

Given User Is loggedin
When User click on Open New Account 
And user selects the account type as "<account>"
And user selects the existing "<accountNo>" accountNo
And user click on Open New Account Button
Then Message displayed "Account Opened!"
And click on Account Number
And Verify Account Type as "<account>"
Then close the browser
Examples:
    | account  | accountNo|
    | CHECKING | 13344    |
    | SAVINGS  | 13344	  |     
  


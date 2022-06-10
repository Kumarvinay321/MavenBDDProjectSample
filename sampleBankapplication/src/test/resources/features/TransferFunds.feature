Feature: Transfer Funds  

Scenario: Transfer Fund Functionality

Given User Is loggedin
When user click on Transfer Funds
And user enter the "1" amount to be transfer
And select the from account and to account
|14010|13344|
And click on Transfer
Then Transfer Complete text displayed
Then close the browser




Feature: Login Functionality 

Description: This feature will test a LogIn functionality

Scenario: Successful Login with Valid Credentials
When User enters Credentials to LogIn
|john|demo|
Then The Title of the Page should be "ParaBank | Accounts Overview"
Then close the browser

Scenario: Successful Login with InValid Credentials
When User enters Credentials to LogIn
|jonn|demo1|
Then  The error message should be "The username and password could not be verified."
Then close the browser
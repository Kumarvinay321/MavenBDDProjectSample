Feature: Update Contact Info  

Scenario: Verification of Contact Info

Given User Is loggedin
When User click on Update Contact Info
And User enter the following user details
|FirstName	|LastName  |Address  | City 	| State |ZipCode   |PhoneNo	     |
| Kavita    | pra	   |ramnagar | bhilai   |cg	    |78988	   |210-447-4221 |
And click on Update Profile
Then Message displayed Profile Updated
Then close the browser
 
	


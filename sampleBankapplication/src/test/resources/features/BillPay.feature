Feature: Bill Pay

Scenario: Bill Pay functionality

Given User Is loggedin
When User click on Bill Pay
And User enter the following details
|PayeeName|	Address|City     |State    |ZipCode|Phone       |Account|VerifyAccount|Amount|Fromaccount|
|ram	  |supela  |Bangalore|karnataka|490056 |220-447-4221|13344  |13344        |1     |14010     |
And click on send payment
Then Message displayed Transfer Complete
Then close the browser


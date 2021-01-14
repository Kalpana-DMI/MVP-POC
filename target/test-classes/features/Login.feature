Feature: Medicare Member Page

@test
Scenario: Validate DestinationRX tool
Given  User is on application homepage
When User Clicks on Shop for a Plan Link
And Select the Medicare link
Then Choose Shop for a Medicare Plan link
And Select Country from the dropdown menu
Then Click on "See Plan Options" button
And User click on "Estimate your prescription drug and out-of-pocket costs per plan" link
And Validate that user is redirected to a new site/window "destinationrx.com"
And User enters the "23456" as ZipCode 
And Click on View Plans
Then Validate all below sections appeared with available no. of plans
| Medicare Advantage Prescription Drug Plans| Medicare Advantage Plans| Prescription Drug Plans|
And Logout from the application

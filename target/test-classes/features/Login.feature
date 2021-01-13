Feature: Medicare Member Page

Scenario: Validate Medicare Plans
Given User is on application homepage
When User clicks on members button on the top menu
Then Validate User is redirected to members SignIn page
And Enter "username" as username and "password" as pwd
Then Click on SignIn button
And Validate Medicare members homepage is displayed
Then User clicks on Drug Coverage Prescription link available on the top
And Validate Prescription Drug coverage page is displayed
Then User clicks on "Estimate you Prescription Drug Cost" link 
And Validate that user is redirected to a new site/window "DestinationRX"
Then User enters the "12345" as ZipCode 
And Click on View Plans
Then Validate all below sections appeared with available no. of plans
|Medicare Advantage Prescription Drug Plans|Medicare Adv plan | Prescription Drug Plans|
And User sort the available plans 
Then User validate the Cost and Order
And User select the plan subtype filter checkbox
Then Vaildate the plan appeared
And User click on the penmark img to edit the zipcode
Then Validate PopUp appeared with a heading "Enter ZIP Code"
And User enters the "56741" as ZipCode 
Then Click on Shop for Plans button
And Validate the plans is now appeared for the new ZipCode
Then Go back to main MVP page
And User Clicks on "Enroll or Change plans "link
Then Validate that User is redirected to a new site/window "DialAmerica.com"
And Close all the windows
And Logout from the application


Scenario: Validate Medicare marketing tool
Given  User is on application homepage
When User Clicks on Shop for a Plan Link
And Select the Medicare link
Then Choose Shop for a Medicare Plan link
And Select Country from the dropdown menu
Then Click on "See Plan Options" button
And User click on "Estimate your annual medical health care costs" link
Then User fill all the below details
|Visits to primary Care Physician|Visit to Specialist|Other Services|Occurences|
|4|2|Physical Therapy|5|
And Click on Estimate my HealthCare Costs button
Then Validate plan details appeared on the page
And Logout from the application


Scenario: Validate DestinationRX tool
Given  User is on application homepage
When User Clicks on Shop for a Plan Link
And Select the Medicare link
Then Choose Shop for a Medicare Plan link
And Select Country from the dropdown menu
Then Click on "See Plan Options" button
And User click on "Estimate your prescription drug and out of pocket costs per plan" link
And Validate that user is redirected to a new site/window "DestinationRX"
And User enters the "12345" as ZipCode 
And Click on View Plans
Then Validate all the plans appeared on the page
And Logout from the application

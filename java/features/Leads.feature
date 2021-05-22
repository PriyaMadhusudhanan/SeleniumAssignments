Feature: Find existing lead and make Duplicate and delete it

Background:
Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And click on Login button
And click on CRMSFA link
And Click on Leads button
And Click on Find Leads

Scenario Outline: Find lead with name and make duplicate of it

When Type First Name as <FName>
And Type Last Name as <LName>
And Click on Find Leads button
And Select existing Lead
And Click on Duplicate button
And Click on Create Lead Button
Then Verify duplicate Lead is created

Examples:
|FName|LName|
|Priya|Madhusudhanan|
|Jeon|JK|

Scenario Outline: Find lead with phone number and delete it

When Click on Phone
And Type Phone number <phoneNumber>
And Click on Find Leads button
And Select existing Lead
And Click on Delete button
Then Verify Lead is deleted 

Examples:
|phoneNumber|
|91|
|99|
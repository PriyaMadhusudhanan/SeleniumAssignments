Feature: Create Lead in LeafTap application

Background:

Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And click on Login button
And click on CRMSFA link
And Click on Leads button

Scenario Outline: Create Lead with multiple data

When Click on Create Lead link
And Type Company name as <CompName>
And Type First name as <FName>
And Type Last name as <LName>
And Click on Create Lead button
Then Verify Lead is created successfully

Examples:
|CompName|FName|LName|
|Syntel|Priya|Madhusudhanan|
|BE|Jeon|JK|

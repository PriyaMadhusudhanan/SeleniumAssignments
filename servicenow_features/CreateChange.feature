Feature: Create new change request

Background:
Given Load URL 'https://dev103117.service-now.com'
When Move to frame
And Type username 'admin'
And Type password 'India@123'
And click on Login button


Scenario Outline: Create new change

Given service now home page is loaded
When filter with 'Change'
And click Create new option
And move to main frame
And select normal
And type description as <Description>
And click submit button
Then verify change is created successully

Examples:
|Description|
|This is Change creation TC 1|
|This is Change creation TC 2|
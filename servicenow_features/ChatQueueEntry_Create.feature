Feature: Create new chat queue entry

Background:
Given Load URL 'https://dev103117.service-now.com'
When Move to frame
And Type username 'admin'
And Type password 'India@123'
And click on Login button


Scenario: Create New queue entry

Given service now home page is loaded
When filter with 'My work'
And click My Work option
And move to main frame
And click new button
And click chat queue entry link
And type Short Description
And click Submit button
Then verify successful creation

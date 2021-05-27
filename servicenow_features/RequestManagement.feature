Feature: Request Management - Create, Cancel, Update and Delete

Background:
Given Load URL 'https://dev103117.service-now.com'
When Move to frame
And Type username 'admin'
And Type password 'India@123'
And click on Login button
And service now home page is loaded
And filter with 'My work'
And click My Work option
And move to main frame

Scenario: Create new Request
When click new button
And click Request link
And Type Description
And click submit
Then verify successful creation

Scenario: Cancel existing request

When search with existing request 'REQ0010088'
And Select existing request
And Click Cancel request button
Then verify successful creation

Scenario: Update existing request

When search with existing request 'REQ0010100'
And Select existing request
And Select Location 'Rhode Island'
And select due date
And click update button
Then verify successful creation

Scenario: Delete existing request

When search with existing request 'REQ0010098'
And Select existing request
And Click Delete Button
And click Delete confirmation button
Then verify successful creation

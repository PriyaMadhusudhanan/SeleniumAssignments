Feature: Login to LeafTap application

Scenario: Login (Positive)

Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And click on Login button
Then Verify title for successful login 'Leaftaps - TestLeaf Automation Platform'


Scenario: Login (Negative)

Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as ''
And click on Login button
Then Verify error message 'password was empty reenter'
Feature: Application Login

Scenario Outline: Login to the application using given credentials

Given User opens any browser
And User Navigates to the application
When User enters username as "<username>" and password as "<password>"
And Click on login button
Then User should be able to login based on "<expected>" login status

Examples:
| username                  | password   | expected  |
| srikarthika.t@gmail.com   | 123456     | success   |
| dummy@test                | 889898     | failure   |



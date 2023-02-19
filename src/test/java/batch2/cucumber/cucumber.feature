Feature: feature

  Scenario: scenario
    Given open App
    When  click link with text as "API Demos"
    And   swipe down until "View" is visible
    And   click link with text as "View"
    And   click link with text as "Controls"
    And   click link with text as "Light Theme"
    And   sendkeys "textbox" to element with partial value "id/edit"
    And   click link with partial value as "id/edit"
    And   hide keyboard
    And   click link with partial value as "id/check1"
    Then  is element "displayed" with partial value "id/check1"
    Then  is element "checked" with partial value "id/check1"
    And   click link with partial value as "id/star"
    Then  is element "checked" with partial value "id/star"
    And   click link with partial value as "id/toggle1"
    Then  is element "checked" with partial value "id/toggle1"
    Then  click link with text as "failed Text"
    And   quit App



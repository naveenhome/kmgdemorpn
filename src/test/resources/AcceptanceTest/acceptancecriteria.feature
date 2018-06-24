Feature: RPN Calculator

  Scenario Outline: Acceptance Criteria
    Given User enter <input> in format below
    Then Result should be <output> in below format

    Examples: 
      | input               | output |
      | "1,2,3,+,-"         | "-4"   |
      | "1,2,3,+,+"         | "6"    |
      | "5,1,2,+,4,*,+,3,-" | "14"   |

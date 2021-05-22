Feature: Split Bill
  This feature describes various scenarios for users splitting a bill with friends

  #As a user, I can topup my Revolut account using my debit card

  Scenario Outline: Split Paid Bill Evenly
    Given Danny has paid a bill of <billAmount>
    And Danny selects to split bill with <numberPeople> friends
    When Danny splits bill
    Then Individual Amount is <amountDue>
    Examples:
      | billAmount  | numberPeople | amountDue  |
      | 25          | 4            | 5          |
      | 90          | 2            | 30         |
      | 72.50       | 1            | 36.25      |


  Scenario Outline: Split Paid Bill owner amount different
    Given Danny has paid a bill of <billAmount>
    And Danny selects to split bill with <numberPeople> friends
    And Danny sets his amount to <ownAmount>
    When Danny splits bill
    Then Individual Amount is <amountDue>
    Examples:
      | billAmount  | numberPeople | ownAmount  |amountDue  |
      | 20          | 4            | 0          | 5         |
      | 50          | 2            | 30         | 10        |
      | 72.50       | 1            | 22.50      | 50        |
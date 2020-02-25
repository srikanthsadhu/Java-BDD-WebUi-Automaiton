Feature: Hotel Bookings

  #Assumed that BDD scenarios are done as part of requirements gathering.

  Background:
    Given As a user of the hotel bookings portal, loads the booking form

  Scenario Outline: 1. Create a new booking with or without deposit
    When  the user enters the form information with "<first_name>","<surname>","<price>","<deposit_option>","<check-in>","<check-out>"
    And presses Save button
    Then  the information is saved
    And reflects the form with new booking details entered in a list, above the form entry fields
    And Delete option present next to the details in the list

  @sanity
    Examples:
      | first_name | surname  | price  | deposit_option | check-in   | check-out  |
      | John       | Trovolta | 120.50 | true           | 2020-03-20 | 2020-03-21 |
      | Tom        | Cruise   | 55.55  | false          | 2020-04-20 | 2020-04-22 |

##   Exact Duplicate entries allowed (exploratory)
#  @regression
#    Examples:
#      | first_name | surname  | price  | deposit_option | check-in   | check-out  |
#      | John       | Trovolta | 120.50 | true           | 18-03-2020 | 22-03-2020 |
#
#  @sanity
  Scenario: 2. Users able to DELETE an exisitng booking on the form.
    When  the user clicks 'Delete' button next to any saved entry
    Then  the information row gets deleted
#
#  @regression @api_level @with_no_requirements(exploratory)
#  Scenario Outline: 3. Create a new booking with or without deposit entering INVALID details
#    When  the user enters the form information with <first_name>,<surname>,<price>,<deposit_option>,<check-in>,<check-out>
#    And presses Save button
#    Then  the information is NOT saved and appropriate <expected_validaiton_msg> is shown
#
#
#    Examples:
#      | first_name | surname | price  | deposit_option | check-in   | check-out  | expected_validaiton_msg                                              |
##      Empty field validation
#      | John       |         | 120.50 | true           | 18-03-2020 | 22-03-2020 | Surname can't be empty                                               |
##
#      | John       | xxx     | 120.50 | true           | 22-03-2020 | 18-03-2020 | Check-out date should be AFTER check-in date                         |
##      combinational field validaitons
#      |            | 123     |        | true           | 22-03-2020 | 18-03-2020 | first name  and Price can't be empty , Invalid characters in surname |
##      Free-entry  of Invalid date field instead of Date widget selection
#      | yyy        | xxx     | 120.50 | true           | 22-24-2020 | 18-03-2020 | first name can't be empty                                            |
#
#  @api_level @with_no_requirements (exploratory)
#  Scenario: 4. Security testing of api and UI
#
#  @api_level @with_no_requirements
#  Scenario: 5. Database and transaction testing
#
#  @api_level @with_no_requirements (exploratory)
#  Scenario: 6. NFT (performance, reliability, resilience, fail-over AWS enviroinments that could be used for deployments.)
#
#
#
#
#
#
#
#
#








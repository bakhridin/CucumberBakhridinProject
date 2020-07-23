#Author: bakhridin76@.gmail.com
Feature: Adding dependent and expiriance of employee

  Background: 
    Given user logged in with valid credentials
    And user navigates to employee list

  @regression
  Scenario Outline: Adding employee dependents
    #Given user logged in with valid credentials
    #And user navigates to employee list
    And user searches for specific id and clicks on "<id>"
    And user clicks on dependents
    When user adds "<Name>","<Relationship>" and "<DateofBirth>" of dependents
    Then user verify that dependent has been added

    Examples: 
      | id    | Name  | Relationship | DateofBirth |
      | 15025 | Safar | Child        | 1999-Nov-19 |

  #     | 14074 | Muhammad | Child        | 2000-Feb-25 |
  #    | 14076 | Ismoil   | Child        | 2011-Nov-11 |
  @smoke
  Scenario Outline: 
    And user searches for specific id and clicks on "<id>"
    And user clicks on qualifications
    When user adds "<Company>","<Jobtitle>","<From>","<To>","<Comment>" of work experience
    Then user verify that work experience has been added

    Examples: 
      | id    | Company    | Jobtitle | From        | To          | Comment             |
      | 10000 | SyntaxTech | QA       | 2010-Nov-20 | 2012-Jun-10 | Usefully experience |
#      | 14074 | Syber Cecurity    | QALEAD   | 2012-Sep-10 | 2014-Oct-10 | Usefully experience |
 #     | 14076 | Republic services | Tester   | 2015-Jul-15 | 2018-Jun-12 | Usefully experience |

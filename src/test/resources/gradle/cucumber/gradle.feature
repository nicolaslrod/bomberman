Feature: Gradle-Cucumber integration

  Scenario: Just a failing scenario
    When I run a failing step

#Bomberman's movement

  Scenario: Bomberman moves to the contigus cell
    Given a empty spreadsheet
    When Bomberman moves from Cell 01 to Cell 02
    Then Bomberman's actual position should be Cell 02

  Scenario: Bomberman moves to the contigus cell but there is a wall
    Given a spreadsheet with a Wall in 02
    When Bomberman moves from Cell 01 to Cell 02
    Then Bomberman's actual position should be Cell 01

  Scenario: Bomberman moves to the contigus cell but there is an enemy and Bomberman dies
    Given a spreadsheet with an enemy in 02
    When Bomberman moves from Cell 01 to Cell 02
    Then Bomberman dies


#Bomberman Droping Bombs and their effects


   Scenario: Bomberman drop a bomb in 01
      Given a  spreadsheet with a wall in 02,04 and 05
      When Bomberman drop the bomb in 01 and after "n" ticks
      Then 02 and 04's walls should be broken but 05 should still exists and bomberman dies

    Scenario: Bomberman drop a bomb in 01
          Given a  spreadsheet with an enemy  in 02
          When Bomberman drop the bomb in 01 and after "n" ticks
          Then the enemy should be dead and bomberman too

    Scenario: Bomberman drop a bomb in 01
      Given a spreadsheet with an iron wall in 02
      When Bomberman drop the bomb in 01 and after "n" ticks
      Then Bomberman dies but 02's wall still up

# Bomberman Beating Bagulaa


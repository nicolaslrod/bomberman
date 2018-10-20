Feature: Move

#Bomberman's movement

  Scenario: Bomberman moves to the contigus cell
    Given A empty cell "1" "1"
    When Bomberman moves to an empty cell "2" "1"
    Then Bomberman is alive and his position is "2" "1"

  Scenario: Bomberman moves to the contigus cell but there is a wall
    Given A empty cell "1" "1"
    When Bomberman moves to a wall "2" "1"
    Then Bomberman´s position is "1" "1"

  Scenario: Bomberman moves to the contigus cell but there is an enemy and Bomberman dies
    Given A empty cell "1" "1"
    When Bomberman moves to a cell with an enemy "2" "1"
    Then Bomberman dies



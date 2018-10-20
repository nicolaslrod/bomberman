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
#
#  Scenario: Bomberman moves to the contigus cell but there is an enemy and Bomberman dies
#    Given a spreadsheet with an enemy in 02
#    When Bomberman moves from Cell 01 to Cell 02
#    Then Bomberman dies



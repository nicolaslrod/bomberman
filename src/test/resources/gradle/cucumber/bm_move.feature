Feature: Move

#Bomberman's movement

  Scenario: Bomberman moves to the contigus cell
    Given A empty cell "1" "1"
    When Bomberman moves to an empty cell "2" "1"
    Then Bomber man it´s alive and his position is "2" "1"

#  Scenario: Bomberman moves to the contigus cell but there is a wall
#    Given a spreadsheet with a Wall in 02
#    When Bomberman moves from Cell 01 to Cell 02
#    Then Bomberman's actual position should be Cell 01
#
#  Scenario: Bomberman moves to the contigus cell but there is an enemy and Bomberman dies
#    Given a spreadsheet with an enemy in 02
#    When Bomberman moves from Cell 01 to Cell 02
#    Then Bomberman dies



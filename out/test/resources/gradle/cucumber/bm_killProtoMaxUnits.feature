Feature: Bomb's effects

#Bomberman kills ProtoMaxUnits


  Scenario: Bomberman drop a bomb and after "n" ticks  it kills the boss ProtoMaxUnits
    Given Other empty cellAddress "1" "1" with ProtoMaxUnit in the next cell
    When Bomberman drops a bomb ProtoMaxUnit is next to the bomberman´s position
    Then the bomb after 'n' ticks kills the enemy and it drops a new super power


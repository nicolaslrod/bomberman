Feature: Bomb's effects

#Bomberman's bombs effects

  Scenario: Bomberman drop a bomb and after "n" ticks it applies its effect
    Given A empty cellAddress "1" "1"
    When Bomberman drops a bomb
    Then the bomb after 'n' ticks destroys all the walls in a three cell radio



  Scenario: Bomberman drop a bomb and after "n" ticks it applies its effect with enemies
    Given Other empty cellAddress "1" "1" with a enemy in the next cell
    When Bomberman drops a bomb and one enemy it´s next to the bomberman´s position
    Then the bomb after 'n' ticks kills all the enemies that are in contact with the expansive wave



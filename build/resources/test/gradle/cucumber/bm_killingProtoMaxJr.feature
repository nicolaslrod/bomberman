Feature: Bomb's effects with Proto max jr

#Bomberman's bombs effects

  Scenario: Bomberman drop a bomb and kills Proto max jr
    Given Bomberman is in cell "1" "1"
    And A Proto Max Jr in eastCell
    When Bomberman drops a bombs
    Then the bomb after 'n' ticks kills Proto Max Jr
    And Proto Max Jr drops superPower that Bomberman could use to jump any kind of wall

  Scenario: Bomberman pick up super power to jump any kind of wall
    Given Bomberman is at cell "1" "1"
    And super power to jump any kind of wall is in cellAddress "1" "2"
    When Bomberman moves to eastCell
    Then Bomberman picks up super power to jump any kind of wall

  Scenario: Bomberman had already picked up super power to jump any kind of wall
    Given A Bomberman with a super power to jump any kind of wall
    When Bomberman moves to a northCell that has a wall
    Then Bomberman is in northCell


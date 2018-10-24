Feature: Bomb's effects with Proto max jr

#Bomberman's bombs effects

  Scenario: Bomberman drop a bomb and kills Proto max units
    Given A Bomberman is in cell "1" "1"
    And A Proto Max units in eastCell
    When Bomberman drop a bomb
    Then the bomb after 'n' ticks kills Proto Max untis
    And Proto Max units drops superPower that Bomberman could use to throw more that one bomb at the same time

  Scenario: Bomberman pick up super power to throw more that one bomb at the same time
    Given A Bomberman is in cell "1" "1"
    And super power to throw more that one bomb at the same time is in cellAddress "1" "2"
    When Bomberman moves to the eastCell
    Then Bomberman picks up super power to throw more that one bomb at the same time

  Scenario: Bomberman had already picked up super power to throw more that one bomb at the same time
    Given A Bomberman with a super power to throw more that one bomb at the same time
    When Bomberman thows "2" bombs, one his position and the other one in cell "2" "2"
    Then cell "2" "2" has no wall
    And bomberman's possition has no wall


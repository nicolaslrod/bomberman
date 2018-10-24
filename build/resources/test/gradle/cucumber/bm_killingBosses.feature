Feature: Boss effects

#Bomberman kills Bosses


  Scenario: Bomberman drop a bomb and after 'n' ticks it kills the boss Bagula and get a new power
    Given An empty cellAddress "1" "1" with Bagula in the east cell
    When fiestaFiesta
    Then the bomb after 'n' ticks kills Bagula at East
    And it drops a new super power on cell "1" "2"


  Scenario: Bomberman pick up new superpower
    Given A  Bomberman in cellAdress "1" "1" and a superPower in cellAdress "1" "2"
    When Bomberman moves to "1" "2"
    Then Bomberman picks up the new superpower


  Scenario: BombaMan has a new superPower
    Given BombaMan with a superPower in cellAdress "1" "1"
    When BombaMan throws a bomb to cellAdress "1" "2"
    Then the bomb after 'n' ticks explodes
package gradle.cucumber;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BombermanBombStepdefs {

    private Bomberman bomberman;
    private Cell northCell = new CellAddress(2,1,true,false,
            new NoCell(),new NoCell(),new NoCell(),new NoCell());
    private Cell southCell=new NoCell();
    private Cell westCell= new NoCell();
    private Cell eastCell= new CellAddress(1,2,true,false,new NoCell(),
            new NoCell(),new NoCell(),new NoCell());


    @Given("^A empty cellAddress \"([^\"]*)\" \"([^\"]*)\"")
    public void a_empty_cell(String anAxisX, String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), false, false,northCell,southCell,eastCell,westCell);
        bomberman = new Bomberman(cell);

    }

    @When("^Bomberman drops a bomb$")
    public void bombermanDropsABomb() throws Throwable {
        assertTrue(northCell.getWall());
        assertTrue(eastCell.getWall());
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks destroys all the walls in a three cell radio$")
    public void theBombAfterNTicksDestroysAllTheWallsInAThreeCellRadio() throws Throwable {
        assertFalse(northCell.getWall());
        assertFalse(eastCell.getWall());
    }

    @Given("^Other empty cellAddress \"([^\"]*)\" \"([^\"]*)\" with a enemy in the next cell$")
    public void aEmptyCellAddressWithAEnemyInTheNextCell(String anAxisX, String anAxisY) throws Throwable {
        northCell.addEnemy();
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), false, false,northCell,southCell,eastCell,westCell);
        bomberman = new Bomberman(cell);
    }

    @When("^Bomberman drops a bomb and one enemy it´s next to the bomberman´s position$")
    public void bombermanDropsABombAndOneEnemyItSNextToTheBombermanSPosition() throws Throwable {
        assertTrue(northCell.hasAnEnemy());
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks kills all the enemies that are in contact with the expansive wave$")
    public void theBombAfterNTicksKillsAllTheEnemiesThatAreInContactWithTheExpansiveWave() throws Throwable {
        assertFalse(northCell.hasAnEnemy());
    }
}

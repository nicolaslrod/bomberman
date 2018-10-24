package gradle.cucumber;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.cell.CellAddress;
import gradle.cucumber.cell.NoCell;
import gradle.cucumber.superpower.NoSuperpower;
import gradle.cucumber.wall.NoWall;
import gradle.cucumber.wall.SimpleWall;
import gradle.cucumber.wall.SteelWall;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BombermanBombStepdefs {

    private Bomberman bomberman;
    private Cell northCell = new CellAddress(2,1,new SimpleWall(),false, new Boss(new NoSuperpower()),
            new NoCell(),new NoCell(),new NoCell(),new NoCell());
    private Cell southCell=new NoCell();
    private Cell westCell= new NoCell();
    private Cell eastCell= new CellAddress(1,2,new SimpleWall(),false,new Boss(new NoSuperpower()),new NoCell(),
            new NoCell(),new NoCell(),new NoCell());

    // First ATDD: destroying normal walls

    @Given("^A empty cellAddress \"([^\"]*)\" \"([^\"]*)\"")
    public void a_empty_cell(String anAxisX, String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,eastCell,westCell);
        bomberman = new Bomberman(cell);

    }

    @When("^Bomberman drops a bomb$")
    public void bombermanDropsABomb() throws Throwable {
        assertFalse(northCell.getWall().isBroken());
        assertFalse(eastCell.getWall().isBroken());
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks destroys all the walls in a three cell radio$")
    public void theBombAfterNTicksDestroysAllTheWallsInAThreeCellRadio() throws Throwable {
        assertTrue(northCell.getWall().isBroken());
        assertTrue(eastCell.getWall().isBroken());
    }

    // Second ATDD : killing our first enemies

    @Given("^Other empty cellAddress \"([^\"]*)\" \"([^\"]*)\" with a enemy in the next cell$")
    public void aEmptyCellAddressWithAEnemyInTheNextCell(String anAxisX, String anAxisY) throws Throwable {
        northCell.addEnemy();
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,eastCell,westCell);
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
    // Third ATDD : Exploding bombs around steel walls

    @Given("^cellAddress \"([^\"]*)\" \"([^\"]*)\" with a steel wall in the next cell$")
    public void celladdressWithASteelWallInTheNextCell(String anAxisX, String anAxisY) throws Throwable {
        northCell.addWall(new SimpleWall());
        eastCell.addWall(new SteelWall());
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,eastCell,westCell);
        bomberman = new Bomberman(cell);
    }

    @When("^Bomberman drops a bomb and a steel wall it´s next to the bomberman´s position$")
    public void bombermanDropsABombAndASteelWallItSNextToTheBombermanSPosition() throws Throwable {
        assertFalse(northCell.getWall().isBroken());
        assertFalse(eastCell.getWall().isBroken());
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks the steel wall it´s not destroy$")
    public void theBombAfterNTicksTheSteelWallItSNotDestroy() throws Throwable {
        assertTrue(northCell.getWall().isBroken());
        assertFalse(eastCell.getWall().isBroken());
    }

}

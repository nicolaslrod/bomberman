package gradle.cucumber;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.cell.CellAddress;
import gradle.cucumber.cell.NoCell;
import gradle.cucumber.superpower.Superpower;
import gradle.cucumber.wall.NoWall;
import gradle.cucumber.wall.SimpleWall;
import gradle.cucumber.wall.SteelWall;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BombermanBossStepdefs {

    private Bomberman bomberman;
    private Cell northCell = new CellAddress(2,1,new SimpleWall(),false,
            new NoCell(),new NoCell(),new NoCell(),new NoCell());
    private Cell southCell=new NoCell();
    private Cell westCell= new NoCell();
    private Cell eastCell= new CellAddress(1,2,new SimpleWall(),false,new NoCell(),
            new NoCell(),new NoCell(),new NoCell());


    @Given("^An empty cellAddress \"([^\"]*)\" \"([^\"]*)\" with Bagula in the east cell$")
    public void aEmptyCellAddressWithProtoMaxUnitsInTheNextCell(String anAxisX, String anAxisY) throws Throwable {
        eastCell.addBoss();
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,northCell,southCell,eastCell,westCell);
        bomberman = new Bomberman(cell);
        assertTrue(eastCell.hasABoss());
    }

    @When("^Bomberman drops a bomb next to Bagula$")
    public void bombermanDropsABomb() throws Throwable {
        bomberman.dropBomb();
    }


    @Then("^the bomb after 'n' ticks kills the enemy and it drops a new super power$")
    public void theBombAfterNTicksKillsProtoMaxUnits() throws Throwable {
        assertFalse(eastCell.hasABoss());
    }


    @And("^Bagula is next to the bomberman´s position at East$")
    public void bagulaIsNextToTheBombermanSPositionAtEast() throws Throwable {
        assertTrue(eastCell.hasABoss());
    }

    @Then("^the bomb after 'n' ticks kills Bagula at East$")
    public void theBombAfterNTicksKillsBagulaAtEast() throws Throwable {
        assertFalse(eastCell.hasABoss());
    }

    @And("^it drops a new super power on cell \"([^\"]*)\" \"([^\"]*)\"$")
    public void itDropsANewSuperPowerOnCell(String anAxisX, String anAxisY) throws Throwable {
        assertTrue(eastCell.hasASuperPower());
    }
/*
    @Given("^An empty cellAddress \"([^\"]*)\" \"([^\"]*)\" with a superpower$")
    public void anEmptyCellAddressWithASuperpower(String anAxisX, String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,northCell,southCell,eastCell,westCell);
        Superpower sp = new Superpower();
        cell.addSuperPower(sp);

    }

    @When("^Bomberman moves to callAddress \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombermanMovesToCallAddress(String arg0, String arg1) throws Throwable {

    }

    @Then("^Bomberman pick up the new superpower$")
    public void bombermanPickUpTheNewSuperpower() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    */
}

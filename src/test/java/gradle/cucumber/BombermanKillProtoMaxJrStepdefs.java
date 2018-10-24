package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.cell.CellAddress;
import gradle.cucumber.cell.NoCell;
import gradle.cucumber.superpower.NoSuperpower;
import gradle.cucumber.superpower.Superpower;
import gradle.cucumber.superpower.SuperpowerJumpAnyKindOfWall;
import gradle.cucumber.wall.NoWall;
import gradle.cucumber.wall.SimpleWall;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BombermanKillProtoMaxJrStepdefs {

    private Bomberman bomberman;
    private Cell northCell = new CellAddress(2, 1, new SimpleWall(), false, new Boss(new NoSuperpower()),
            new NoCell(), new NoCell(), new NoCell(), new NoCell());
    private Cell southCell = new NoCell();
    private Cell westCell = new NoCell();
    private Cell eastCell = new CellAddress(1, 2, new NoWall(), false,new Boss(new NoSuperpower()), new NoCell(),
            new NoCell(), new NoCell(), new NoCell());
    private Cell cell;



    @Given("^Bomberman is in cell \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombermanIsInCell(String anAxisX, String anAxisY) throws Throwable {
        cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()), northCell, southCell, eastCell, westCell);
        bomberman = new Bomberman(cell);
    }

    @And("^A Proto Max Jr in eastCell$")
    public void aProtoMaxJrInEastCell() throws Throwable {
       eastCell.addBoss(new Boss(new NoSuperpower()));
    }


    @When("^Bomberman drops a bombs$")
    public void bombermanDropsABombs() throws Throwable {
        assertTrue(eastCell.hasABoss());
        bomberman.dropBomb();
    }


    @Then("^the bomb after 'n' ticks kills Proto Max Jr$")
    public void theBombAfterNTicksKillsProtoMaxJr() throws Throwable {
        assertFalse(eastCell.hasABoss());
    }

    @And("^Proto Max Jr drops superPower that Bomberman could use to jump any kind of wall$")
    public void protoMaxJrDropsSuperPowerThatYouCouldUseToJumpAnyKindOfWall() throws Throwable {
        assertTrue(eastCell.hasASuperPower());
    }


    @Given("^Bomberman is at cell \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombermanIsAtCell(String anAxisX, String anAxisY) throws Throwable {
        cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()), northCell, southCell, eastCell, westCell);
        bomberman = new Bomberman(cell);
    }

    @And("^super power to jump any kind of wall is in cellAddress \"([^\"]*)\" \"([^\"]*)\"$")
    public void superPowerToJumpAnyKindOfWallIsInCellAddress(String arg0, String arg1) throws Throwable {
        eastCell.addSuperPower(new SuperpowerJumpAnyKindOfWall());
    }

    @When("^Bomberman moves to eastCell$")
    public void bombermanMovesToEastCell() throws Throwable {
        bomberman.moveTo(eastCell);
    }

    @Then("^Bomberman picks up super power to jump any kind of wall$")
    public void bombermanPicksUpSuperPowerToJumpAyKindOfWall() throws Throwable {
        bomberman.pickUpSuperPower();
        assertNotNull(bomberman.getSuperPower());
    }

    @Given("^A Bomberman with a super power to jump any kind of wall$")
    public void aBombermanWithASuperPowerToJumpAnyKindOfWall() throws Throwable {
        bomberman = new Bomberman(new CellAddress(1, 1, new NoWall(), false, new Boss(new NoSuperpower()),northCell, southCell, eastCell, westCell));
        bomberman.getPosition().addSuperPower(new SuperpowerJumpAnyKindOfWall());
        bomberman.pickUpSuperPower();
    }

    @When("^Bomberman moves to a northCell that has a wall$")
    public void bombermanMovesToANorthCellThatHasAWall() throws Throwable {
        bomberman.moveTo(bomberman.getPosition().getNorth());
    }

    @Then("^Bomberman is in northCell$")
    public void bombermanIsInNorthCell() throws Throwable {
        assertTrue(bomberman.getPosition() == northCell);
    }
}

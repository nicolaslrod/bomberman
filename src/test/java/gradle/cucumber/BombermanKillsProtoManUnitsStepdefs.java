package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.boss.ProtoMaxUnits;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.cell.CellAddress;
import gradle.cucumber.cell.NoCell;
import gradle.cucumber.superpower.NoSuperpower;
import gradle.cucumber.superpower.SuperPowerThrowMultipleBombs;
import gradle.cucumber.superpower.SuperpowerJumpAnyKindOfWall;
import gradle.cucumber.wall.NoWall;
import gradle.cucumber.wall.SimpleWall;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BombermanKillsProtoManUnitsStepdefs {

    private Bomberman bomberman;
    private Cell northCell = new CellAddress(2, 1, new SimpleWall(), false, new Boss(new NoSuperpower()),
            new NoCell(), new NoCell(), new NoCell(), new NoCell());
    private Cell southCell = new NoCell();
    private Cell westCell = new NoCell();
    private Cell eastCell = new CellAddress(1, 2, new NoWall(), false,new Boss(new NoSuperpower()), new NoCell(),
            new NoCell(), new NoCell(), new NoCell());
    private Cell cell;
    private Cell cell2;

    // FIRST ATDD:  BOMBERMAN TRIES TO MOVE TOWARDS A CELL WHICH HAS A WALL AND HE WOULD'NT BE ABLE TO DO THAT
    @Given("^A Bomberman is in cell \"([^\"]*)\" \"([^\"]*)\"$")
    public void aBombermanIsInCell(String anAxisX, String anAxisY) throws Throwable {
        cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()), northCell, southCell, eastCell, westCell);
        bomberman = new Bomberman(cell);
    }

    @And("^A Proto Max units in eastCell$")
    public void aProtoMaxUnitsInEastCell() throws Throwable {
        eastCell.addBoss(new ProtoMaxUnits());
    }

    @When("^Bomberman drop a bomb$")
    public void bombermanDropABomb() throws Throwable {
        assertTrue(eastCell.hasABoss());
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks kills Proto Max untis$")
    public void theBombAfterNTicksKillsProtoMaxUntis() throws Throwable {
        assertFalse(eastCell.hasABoss());
    }

    @And("^Proto Max units drops superPower that Bomberman could use to throw more that one bomb at the same time$")
    public void protoMaxUnitsDropsSuperPowerThatBombermanCouldUseToThrowMoreThatOneBombAtTheSameTime() throws Throwable {
        assertTrue(eastCell.hasASuperPower());
        assertTrue(eastCell.getSuperPower().isMultipleBombPower());
    }

    @And("^super power to throw more that one bomb at the same time is in cellAddress \"([^\"]*)\" \"([^\"]*)\"$")
    public void superPowerToThrowMoreThatOneBombAtTheSameTimeIsInCellAddress(String arg0, String arg1) throws Throwable {
        eastCell.addSuperPower(new SuperPowerThrowMultipleBombs());
    }

    @When("^Bomberman moves to the eastCell$")
    public void bombermanMovesToTheEastCell() throws Throwable {
        bomberman.moveTo(eastCell);
    }

    @Then("^Bomberman picks up super power to throw more that one bomb at the same time$")
    public void bombermanPicksUpSuperPowerToThrowMoreThatOneBombAtTheSameTime() throws Throwable {
        bomberman.pickUpSuperPower();
        assertFalse(bomberman.getSuperPower().isNoSuperPower());
        assertTrue(bomberman.getSuperPower().isMultipleBombPower());
    }


    @Given("^A Bomberman with a super power to throw more that one bomb at the same time$")
    public void aBombermanWithASuperPowerToThrowMoreThatOneBombAtTheSameTime() throws Throwable {
        bomberman = new Bomberman(new CellAddress(1, 1, new NoWall(), false, new Boss(new NoSuperpower()),northCell, southCell, eastCell, westCell));
        bomberman.getPosition().addSuperPower(new SuperPowerThrowMultipleBombs());
        bomberman.pickUpSuperPower();
    }

    @When("^Bomberman thows \"([^\"]*)\" bombs, one his position and the other one in cell \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombermanThowsBombsOneHisPositionAndTheOtherOneInCell(String bombs, String anAxisX, String anAxisY) throws Throwable {
        List<Cell> cellsToBomb = new ArrayList<>();
        bomberman.getPosition().addEnemy();
        cellsToBomb.add(bomberman.getPosition());
        cell2 = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new SimpleWall(), false,new Boss(new NoSuperpower()), new NoCell(), new NoCell(), new NoCell(), new NoCell());
        cellsToBomb.add(cell2);
        bomberman.throwMultiplesBombs(bombs,cellsToBomb);
    }

    @Then("^cell \"([^\"]*)\" \"([^\"]*)\" has no wall$")
    public void cellHasNoWall(String arg0, String arg1) throws Throwable {
        assertTrue(cell2.getWall().isBroken());
    }

    @And("^bomberman's possition has no wall$")
    public void bombermanSPossitionHasNoWall() throws Throwable {
       assertFalse(bomberman.getPosition().hasAnEnemy());
    }
}

package gradle.cucumber;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.boss.Bangula;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.boss.ProtoMaxJR;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.cell.CellAddress;
import gradle.cucumber.cell.NoCell;
import gradle.cucumber.superpower.NoSuperpower;
import gradle.cucumber.superpower.Superpower;
import gradle.cucumber.superpower.SuperpowerThrowBombs;
import gradle.cucumber.wall.NoWall;
import gradle.cucumber.wall.SimpleWall;


import static org.junit.Assert.*;

public class BombermanBossStepdefs {

    private Bomberman bomberman;
    private Cell northCell = new CellAddress(2,1,new SimpleWall(),false, new Boss(new NoSuperpower()),
            new NoCell(),new NoCell(),new NoCell(),new NoCell());
    private Cell southCell=new NoCell();
    private Cell westCell= new NoCell();
    private Cell eastCell= new CellAddress(1,2,new SimpleWall(),false, new Boss(new NoSuperpower()), new NoCell(),
            new NoCell(),new NoCell(),new NoCell());
    private Cell cell;


    @Given("^An empty cellAddress \"([^\"]*)\" \"([^\"]*)\" with Bagula in the east cell$")
    public void aEmptyCellAddressWithProtoMaxUnitsInTheNextCell(String anAxisX, String anAxisY) throws Throwable {
        eastCell.addBoss(new Bangula());
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,eastCell,westCell);
        bomberman = new Bomberman(cell);
        assertTrue(eastCell.hasABoss());
    }

    @When("^fiestaFiesta")
    public void fiestaFiesta() throws Throwable {
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks kills Bagula at East$")
    public void theBombAfterNTicksKillsBagulaAtEast() throws Throwable {
        assertFalse(eastCell.hasABoss());
    }


    @And("^it drops a new super power on cell \"([^\"]*)\" \"([^\"]*)\"$")
    public void itDropsANewSuperPowerOnCell(String anAxisX, String anAxisY) throws Throwable {
        assertTrue(eastCell.hasASuperPower());
        assertTrue(eastCell.getSuperPower().isThrowPower());
    }



    //  ATDD Super powers
    @Given("^A  Bomberman in cellAdress \"([^\"]*)\" \"([^\"]*)\" and a superPower in cellAdress \"([^\"]*)\" \"([^\"]*)\"$")
    public void aBombermanInCellAdressAndASuperPowerInCellAdress(String anAxisX, String anAxisY, String anAxisX2, String anAxisY2) throws Throwable {
        Cell cell2 = new CellAddress(Integer.valueOf(anAxisX2), Integer.valueOf(anAxisY2), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,eastCell,westCell);
        Superpower sp = new SuperpowerThrowBombs();
        cell2.addSuperPower(sp);
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,cell2,westCell);
        bomberman = new Bomberman(cell);

    }



    @When("^Bomberman moves to \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombermanMovesTo(String arg0, String arg1) throws Throwable {
       bomberman.moveTo(bomberman.getPosition().getEast());
    }

    @Then("^Bomberman picks up the new superpower$")
    public void bombermanPicksUpTheNewSuperpower() throws Throwable {
        bomberman.pickUpSuperPower();
        assertTrue(bomberman.getSuperPower().isThrowPower());
        assertFalse(bomberman.getSuperPower().isJumpPower());
        assertFalse(bomberman.getSuperPower().isMultipleBombPower());
    }


// ATDD Using the new superPower THROW BOMB

    @Given("^BombaMan with a superPower in cellAdress \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombaManWithASuperPowerInCellAdress(String anAxisX, String anAxisY) throws Throwable {

        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),northCell,southCell,eastCell,westCell);

        bomberman = new Bomberman(cell);
        Superpower sp = new SuperpowerThrowBombs();

        cell.addSuperPower(sp);
        bomberman.pickUpSuperPower();

    }

    @When("^BombaMan throws a bomb to cellAdress \"([^\"]*)\" \"([^\"]*)\"$")
    public void bombaManThrowABombToCellAdress(String anAxisX, String anAxisY) throws Throwable {
        cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new SimpleWall(), false,new Boss(new NoSuperpower()),new NoCell(),new NoCell(),new NoCell(),new NoCell());
        bomberman.throwBomb(cell);
    }

    @Then("^the bomb after 'n' ticks explodes$")
    public void bombaManTheBombAfterNTicksExplodes() throws Throwable {
       assertTrue(cell.getWall().isBroken());
    }



}

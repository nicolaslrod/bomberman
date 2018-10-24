package gradle.cucumber;

import cucumber.api.PendingException;
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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BombermanMoveStepdefs {

    private Bomberman bomberman;


    @Given("^A empty cell \"([^\"]*)\" \"([^\"]*)\"")
    public void a_empty_cell(String anAxisX, String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),new NoCell(),new NoCell(),new NoCell(),new NoCell());
        bomberman = new Bomberman(cell);
    }

    @When("^Bomberman moves to an empty cell \"([^\"]*)\" \"([^\"]*)\"")
    public void bomberman_moves_to_an_empty_cell(String anAxisX,  String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), false,new Boss(new NoSuperpower()),new NoCell(),new NoCell(),new NoCell(),new NoCell());
        bomberman.getPosition().setEast(cell);
        bomberman.moveTo(cell);
    }

    @Then("^Bomberman is alive and his position is \"([^\"]*)\" \"([^\"]*)\"")
    public void bomber_man_it_s_alive_and_his_position_is(String anAxisX, String anAxisY) throws Throwable {
        assertEquals(bomberman.getPosition().getX(), Integer.valueOf(anAxisX));
        assertEquals(bomberman.getPosition().getY(), Integer.valueOf(anAxisY));
        assertFalse(bomberman.isDead());
    }



    @When("^Bomberman moves to a wall \"([^\"]*)\" \"([^\"]*)\"")
    public void bomberman_moves_to_wall(String anAxisX,  String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new SimpleWall(), false,new Boss(new NoSuperpower()),new NoCell(),new NoCell(),new NoCell(),new NoCell());
        bomberman.getPosition().setEast(cell);
        bomberman.moveTo(cell);
    }

    @When("^Bomberman moves to a cell with an enemy \"([^\"]*)\" \"([^\"]*)\"")
    public void bomberman_moves_to_cell_with_an_enemy(String anAxisX,  String anAxisY) throws Throwable {
        Cell cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), new NoWall(), true,new Boss(new NoSuperpower()),new NoCell(),new NoCell(),new NoCell(),new NoCell());
        bomberman.getPosition().setEast(cell);
        bomberman.moveTo(cell);
    }


    @Then("^Bomberman dies")
    public void bomberman_dies() throws Throwable {
        assertTrue(bomberman.isDead());
    }

    @Then("^Bomberman position is (\\d+) (\\d+)$")
    public void bombermanPositionIs(int anAxisX, int anAxisY) throws Throwable {
        assertEquals(bomberman.getPosition().getX(), Integer.valueOf(anAxisX));
        assertEquals(bomberman.getPosition().getY(), Integer.valueOf(anAxisY));
    }
}

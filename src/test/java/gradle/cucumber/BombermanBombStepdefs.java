package gradle.cucumber;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;

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
        bomberman.dropBomb();
    }

    @Then("^the bomb after 'n' ticks destroys all the walls in a three cell radio$")
    public void theBombAfterNTicksDestroysAllTheWallsInAThreeCellRadio() throws Throwable {
        assertFalse(northCell.getWall());
        assertFalse(eastCell.getWall());
    }
    /*

    @When("^Bomberman moves to a wall \"([^\"]*)\" \"([^\"]*)\"")
    public void bomberman_moves_to_wall(String anAxisX,  String anAxisY) throws Throwable {
        CellAddress cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), true, false);
        bomberman.moveTo(cell);
    }

    @When("^Bomberman moves to a cell with an enemy \"([^\"]*)\" \"([^\"]*)\"")
    public void bomberman_moves_to_cell_with_an_enemy(String anAxisX,  String anAxisY) throws Throwable {
        CellAddress cell = new CellAddress(Integer.valueOf(anAxisX), Integer.valueOf(anAxisY), false, true);
        bomberman.moveTo(cell);
    }

    @Then("^Bomberman is alive and his position is \"([^\"]*)\" \"([^\"]*)\"")
    public void bomber_man_it_s_alive_and_his_position_is(String anAxisX, String anAxisY) throws Throwable {
        assertEquals(bomberman.getPosition().getX(), Integer.valueOf(anAxisX));
        assertEquals(bomberman.getPosition().getY(), Integer.valueOf(anAxisY));
        assertFalse(bomberman.isDead());
    }

    @Then("^Bomberman´s position is \"([^\"]*)\" \"([^\"]*)\"")
    public void bomber_man_position_is(String anAxisX, String anAxisY) throws Throwable {
        assertEquals(bomberman.getPosition().getX(), Integer.valueOf(anAxisX));
        assertEquals(bomberman.getPosition().getY(), Integer.valueOf(anAxisY));
    }

    @Then("^Bomberman dies")
    public void bomberman_dies() throws Throwable {
        assertTrue(bomberman.isDead());
    }
*/
}

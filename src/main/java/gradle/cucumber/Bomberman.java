package gradle.cucumber;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.superpower.Superpower;

public class Bomberman {

    private Cell cell;
    private boolean alive;
    private Superpower mySuperPower;


    public Bomberman(Cell cell) {
        this.cell = cell;
        this.alive = true;
    }

    public void moveTo(Cell cell) {
        if(cell.getWall().isNoWall()){
            this.cell = cell;
        }
        if(cell.hasAnEnemy()){
            this.alive = false;
        }
    }

    public Cell getPosition() {
        return this.cell;
    }

    public boolean isDead() {
        return !alive;
    }

    public void dropBomb() throws InterruptedException {
        this.cell.setBomb(new Bomb());
     //   this.claimNewSuperPowers("ProtoMaxUnits");
    }

    public void pickUpSuperPower() {
       this.mySuperPower= this.getPosition().getSuperPower();

    }


    public Superpower getSuperPower() {
        return this.mySuperPower;
    }
}

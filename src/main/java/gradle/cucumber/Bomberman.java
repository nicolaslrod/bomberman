package gradle.cucumber;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.cell.Cell;
import gradle.cucumber.superpower.NoSuperpower;
import gradle.cucumber.superpower.Superpower;

public class Bomberman {

    private Cell cell;
    private boolean alive;
    private Superpower mySuperPower;


    public Bomberman(Cell cell) {
        this.cell = cell;
        this.alive = true;
        mySuperPower = new NoSuperpower();
    }

    public void moveTo(Cell cell) {
        if(this.cell.isContiguous(cell)) {
            if (cell.getWall().isNoWall() || this.mySuperPower.isJumpPower()) {
                this.cell = cell;
            }
            if (cell.hasAnEnemy()) {
                this.alive = false;
            }
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
    }

    public void pickUpSuperPower() {
       this.mySuperPower= this.getPosition().getSuperPower();

    }


    public Superpower getSuperPower() {
        return this.mySuperPower;
    }

    public void throwBomb(Cell cellToExplode) throws InterruptedException  {
        if(this.mySuperPower.isThrowPower()) {
            cellToExplode.setBomb(new Bomb());
        }
    }
}

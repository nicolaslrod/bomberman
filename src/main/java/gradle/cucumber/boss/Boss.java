package gradle.cucumber.boss;

import gradle.cucumber.cell.Cell;
import gradle.cucumber.superpower.Superpower;

public class Boss {
    private Superpower superP;
    private boolean live;

    public Boss(Superpower superpower){
        superP = superpower;
        live = true;
    }
    public void dropPower(Cell cellAddress) {
        cellAddress.addSuperPower(superP);
    }

    public void die() {
        this.live = false;
    }

    public boolean isAlive() {
        return live;
    }
}

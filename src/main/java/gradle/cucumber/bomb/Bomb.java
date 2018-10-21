package gradle.cucumber.bomb;

import gradle.cucumber.cell.Cell;

public class Bomb {
    private Integer ticks;

    public Bomb(){
        ticks = 3;
    }

    public void exploit(Cell cell) {
        cell.breakWall(3);
        cell.killEnemy(3);
        cell.killBoss(3);

    }

    public Integer getTicks(){
        return ticks;
    }
}

package gradle.cucumber;

import java.awt.event.MouseEvent;

public class Bomberman {

    private Cell cell;
    private boolean alive;

    public Bomberman(Cell cell) {
        this.cell = cell;
        this.alive = true;
    }

    public void moverHacia(Cell cell) {
        this.cell = cell;
    }

    public Cell getPosition() {
        return this.cell;
    }

    public boolean isDead() {
        return !alive;
    }
}

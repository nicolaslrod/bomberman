package gradle.cucumber;

public class Bomberman {

    private Cell cell;
    private boolean alive;



    public Bomberman(Cell cell) {
        this.cell = cell;
        this.alive = true;
    }

    public void moveTo(Cell cell) {
        if(!cell.getWall()){
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
    }
}

package gradle.cucumber;

public class Bomb {
    private Integer ticks;

    public Bomb(){
        ticks = 3;
    }

    public void exploit(Cell cell) {
        cell.breakWall(3);
    }

    public Integer getTicks(){
        return ticks;
    }
}

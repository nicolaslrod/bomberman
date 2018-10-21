package gradle.cucumber;

public interface Cell {

    Integer getX();

    Integer getY();

    boolean getWall();

    boolean hasAnEnemy();

    void setBomb(Bomb bomb) throws InterruptedException;

    void breakWall(int ratio);

    void addEnemy();

    void killEnemy(int i);
}

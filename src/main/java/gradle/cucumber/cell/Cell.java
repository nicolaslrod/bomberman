package gradle.cucumber.cell;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.wall.SteelWall;
import gradle.cucumber.wall.Wall;

public interface Cell {

    Integer getX();

    Integer getY();

    Wall getWall();

    boolean hasAnEnemy();

    void setBomb(Bomb bomb) throws InterruptedException;

    void breakWall(int ratio);

    void addEnemy();

    void killEnemy(int i);

    void addWall(Wall wall);
}

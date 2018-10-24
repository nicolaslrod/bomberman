package gradle.cucumber.cell;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.superpower.Superpower;
import gradle.cucumber.wall.SteelWall;
import gradle.cucumber.wall.Wall;

public interface Cell {

    Integer getX();

    Integer getY();

    Wall getWall();

    boolean hasAnEnemy();
    boolean hasABoss();

    void setBomb(Bomb bomb) throws InterruptedException;

    void breakWall(int ratio);

    void addEnemy();

    void addBoss(Boss boss);

    void killEnemy(int i);

    void killBoss(int i);


    void addWall(Wall wall);

    boolean hasASuperPower();

    void addSuperPower(Superpower sp);

    Cell getEast();

    Cell getNorth();

    Cell getWest();

    Cell getSouth();

    void setEast(Cell c);

    void setNorth(Cell c);

    void setWest(Cell c);

    void setSouth(Cell c);

    Superpower getSuperPower();

    Boolean isContiguous(Cell cell);
}

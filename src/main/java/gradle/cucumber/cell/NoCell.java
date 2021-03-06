package gradle.cucumber.cell;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.superpower.Superpower;
import gradle.cucumber.wall.NoWall;
import gradle.cucumber.wall.Wall;

public class NoCell implements Cell {


    @Override
    public Integer getX() {
        return null;
    }

    @Override
    public Integer getY() {
        return null;
    }

    @Override
    public Wall getWall() {
        return new NoWall();
    }

    @Override
    public boolean hasAnEnemy() {
        return false;
    }

    @Override
    public boolean hasABoss() {
        return false;
    }

    @Override
    public void setBomb(Bomb bomb) {

    }

    @Override
    public void breakWall(int ratio) {

    }

    @Override
    public void addEnemy() {

    }

    @Override
    public void addBoss(Boss boss) {

    }



    @Override
    public void killEnemy(int i) {

    }
    @Override
    public void killBoss(int i) {

    }

    @Override
    public void addWall(Wall wall) {

    }

    @Override
    public boolean hasASuperPower() {
        return false;
    }

    @Override
    public void addSuperPower(Superpower sp) {

    }

    @Override
    public Cell getEast() {
        return null;
    }

    @Override
    public Cell getNorth() {
        return null;
    }

    @Override
    public Cell getWest() {
        return null;
    }

    @Override
    public Cell getSouth() {
        return null;
    }

    @Override
    public void setEast(Cell c) {

    }

    @Override
    public void setNorth(Cell c) {

    }

    @Override
    public void setWest(Cell c) {

    }

    @Override
    public void setSouth(Cell c) {

    }

    @Override
    public Superpower getSuperPower() {
        return null;
    }

    @Override
    public Boolean isContiguous(Cell cell) {
        return null;
    }
}

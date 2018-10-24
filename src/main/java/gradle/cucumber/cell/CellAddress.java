package gradle.cucumber.cell;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.boss.Boss;
import gradle.cucumber.superpower.Superpower;
import gradle.cucumber.wall.Wall;

public class CellAddress implements Cell {


    private Integer axisX;
    private Integer axisY;
    private Wall wall;
    private boolean enemy;
    private Boss boss;
    private Cell northCell;
    private Cell southCell;
    private Cell eastCell;
    private Cell westCell;
    private Superpower superP;


    public CellAddress(Integer anAxisX, Integer anAxisY, Wall wall, boolean enemy,Boss boss, Cell nc, Cell sc, Cell ec, Cell wc) {
        this.axisX = anAxisX;
        this.axisY = anAxisY;
        this.wall = wall;
        this.enemy = enemy;
        this.boss = boss;
        this.northCell=nc;
        this.southCell=sc;
        this.eastCell=ec;
        this.westCell=wc;


    }


    @Override
    public Wall getWall(){
        return wall;
    }
    @Override
    public boolean hasAnEnemy() {
        return enemy;
    }
    @Override
    public boolean hasABoss() {
        return boss.isAlive();
    }

    @Override
    public void setBomb(Bomb bomb) throws InterruptedException {
        Thread.sleep(bomb.getTicks()*1000);
        bomb.exploit(this);
    }

    @Override
    public void breakWall(int ratio) {
        wall.breakWall();
        if(ratio > 0){
            int newRatio = ratio - 1;
            northCell.breakWall(newRatio);
            westCell.breakWall(newRatio);
            eastCell.breakWall(newRatio);
            southCell.breakWall(newRatio);
        }

    }

    @Override
    public void addEnemy() {
        enemy = true;
    }

    @Override
    public void addBoss(Boss boss) {
        this.boss = boss;
    }


    @Override
    public void killEnemy(int ratio) {
        enemy = false;
        if(ratio > 0){
            int newRatio = ratio - 1;
            northCell.killEnemy(newRatio);
            westCell.killEnemy(newRatio);
            eastCell.killEnemy(newRatio);
            southCell.killEnemy(newRatio);
        }
    }


    @Override
    public void killBoss(int ratio) {
        boss.dropPower(this);
        boss.dye();
        if(ratio > 0){
            int newRatio = ratio - 1;
            northCell.killBoss(newRatio);
            westCell.killBoss(newRatio);
            eastCell.killBoss(newRatio);
            southCell.killBoss(newRatio);
        }
    }

    @Override
    public void addWall(Wall wall1) {
        wall = wall1;
    }

    @Override
    public boolean hasASuperPower() {
        return this.superP != null;
    }

    @Override
    public void addSuperPower(Superpower sp) {
        this.superP = sp;
    }

    @Override
    public Cell getEast() {
        return this.eastCell;
    }

    @Override
    public Cell getNorth() {
        return this.northCell;
    }

    @Override
    public Cell getWest() {
        return this.westCell;
    }

    @Override
    public Cell getSouth() {
        return this.southCell;
    }

    @Override
    public void setEast(Cell c) {
        this.eastCell = c;
    }

    @Override
    public void setNorth(Cell c) {
        this.northCell = c;
    }

    @Override
    public void setWest(Cell c) {
        this.westCell = c;
    }

    @Override
    public void setSouth(Cell c) {
        this.southCell = c;
    }

    @Override
    public Superpower getSuperPower() {
        return superP;
    }

    @Override
    public Boolean isContiguous(Cell cell) {
        return northCell == cell || southCell ==  cell || westCell == cell || eastCell == cell;
    }

    @Override
    public Integer getX() {
        return axisX;
    }

    @Override
    public Integer getY() {
        return axisY;
    }


}

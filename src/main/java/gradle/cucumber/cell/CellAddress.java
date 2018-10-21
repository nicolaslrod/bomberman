package gradle.cucumber.cell;

import gradle.cucumber.bomb.Bomb;
import gradle.cucumber.wall.SteelWall;
import gradle.cucumber.wall.Wall;

public class CellAddress implements Cell {


    private Integer axisX;
    private Integer axisY;
    private Wall wall;
    private boolean enemy;
    private boolean bomb;
    private Cell northCell;
    private Cell southCell;
    private Cell eastCell;
    private Cell westCell;


    public CellAddress(Integer anAxisX, Integer anAxisY, Wall wall, boolean enemy, Cell nc, Cell sc, Cell wc, Cell ec) {
        this.axisX = anAxisX;
        this.axisY = anAxisY;
        this.wall = wall;
        this.enemy = enemy;
        this.bomb= false;
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
    public void addWall(Wall wall1) {
        wall = wall1;
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

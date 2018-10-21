package gradle.cucumber;

public class CellAddress implements Cell {


    private Integer axisX;
    private Integer axisY;
    private boolean wall;
    private boolean enemy;
    private boolean bomb;
    private Cell northCell;
    private Cell southCell;
    private Cell eastCell;
    private Cell westCell;


    public CellAddress(Integer anAxisX, Integer anAxisY, boolean wall, boolean enemy, Cell nc, Cell sc, Cell wc, Cell ec) {
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
    public boolean getWall(){
        return wall;
    }
    @Override
    public boolean hasAnEnemy() {
        return enemy;
    }
    @Override
    public void setBomb() {
        this.bomb=true;
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

package gradle.cucumber;

public class Cell {


    private Integer axisX;
    private Integer axisY;
    private boolean wall;
    private boolean enemy;

    public Cell(Integer anAxisX, Integer anAxisY, boolean wall, boolean enemy) {
        this.axisX = anAxisX;
        this.axisY = anAxisY;
        this.wall = wall;
        this.enemy = enemy;
    }


    public Integer getX() {
        return axisX;
    }

    public Integer getY() {
        return axisY;
    }

    public boolean getWall(){
        return wall;
    }
}

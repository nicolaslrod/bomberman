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
        return this.axisX;
    }

    public Integer getY() {
        return this.axisY;
    }
}

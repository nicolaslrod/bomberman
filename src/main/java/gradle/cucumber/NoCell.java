package gradle.cucumber;

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
    public boolean getWall() {
        return false;
    }

    @Override
    public boolean hasAnEnemy() {
        return false;
    }

    @Override
    public void setBomb() {

    }
}

package gradle.cucumber.wall;

public class NoWall implements Wall {
    @Override
    public void breakWall() {

    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public boolean isNoWall() {
        return true;
    }
}

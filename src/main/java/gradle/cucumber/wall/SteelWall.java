package gradle.cucumber.wall;

public class SteelWall implements Wall {

    @Override
    public void breakWall() {

    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public boolean isNoWall() {
        return false;
    }


}

package gradle.cucumber.wall;

public class SimpleWall implements Wall {

    private boolean broken;

    public SimpleWall(){
        broken = false;
    }

    @Override
    public void breakWall() {
        broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public boolean isNoWall() {
        return false;
    }
}

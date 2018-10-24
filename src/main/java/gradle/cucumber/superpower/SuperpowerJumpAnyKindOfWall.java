package gradle.cucumber.superpower;

public class SuperpowerJumpAnyKindOfWall extends Superpower {
    @Override
    public boolean isJumpPower() {
        return true;
    }

    @Override
    public boolean isThrowPower() {
        return false;
    }

    @Override
    public boolean isMultipleBombPower() {
        return false;
    }
}

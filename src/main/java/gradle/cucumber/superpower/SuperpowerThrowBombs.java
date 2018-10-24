package gradle.cucumber.superpower;

public class SuperpowerThrowBombs extends Superpower {
    @Override
    public boolean isJumpPower() {
        return false;
    }

    @Override
    public boolean isThrowPower() {
        return true;
    }

    @Override
    public boolean isMultipleBombPower() {
        return false;
    }
}

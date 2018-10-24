package gradle.cucumber.superpower;

public class SuperPowerThrowMultipleBombs extends Superpower {
    @Override
    public boolean isJumpPower() {
        return false;
    }

    @Override
    public boolean isThrowPower() {
        return false;
    }

    @Override
    public boolean isMultipleBombPower() {
        return true;
    }
}

package gradle.cucumber;

public interface Cell {



    public Integer getX();


    public Integer getY();


    boolean getWall();

    boolean hasAnEnemy();

    void setBomb();
}

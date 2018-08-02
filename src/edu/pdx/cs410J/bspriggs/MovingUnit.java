package edu.pdx.cs410J.bspriggs;

public interface MovingUnit extends Unit {
    Direction looking();

    Location at();

    int speed();
}

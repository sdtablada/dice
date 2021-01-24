package com.avaloq.model;

import java.util.Random;

public class Dice implements Rollable {

    private int noOfFaces;

    public Dice(int noOfFaces) {
        this.noOfFaces = noOfFaces;
    }

    @Override
    public int roll() {
        return new Random().nextInt(noOfFaces) + 1;
    }

}

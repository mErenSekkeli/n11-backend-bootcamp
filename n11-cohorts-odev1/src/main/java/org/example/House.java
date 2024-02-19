package org.example;

public class House {
    private final double price;
    private final double squareMeters;
    private final int numberOfRoom;
    private final int numberOfLivingRoom;

    public House(double price, double squareMeters, int numberOfRoom, int numberOfLivingRoom) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.numberOfRoom = numberOfRoom;
        this.numberOfLivingRoom = numberOfLivingRoom;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public int getNumberOfLivingRoom() {
        return numberOfLivingRoom;
    }

}

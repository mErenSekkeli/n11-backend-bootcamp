package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HouseService {
    private List<House> houses;
    private List<Villa> villas;
    private List<SummerHouse> summerHouses;

    public HouseService() {
        this.houses = new ArrayList<>();
        this.villas = new ArrayList<>();
        this.summerHouses = new ArrayList<>();

        houses.add(new House(100000, 100, 3, 1));
        houses.add(new House(120000, 120, 4, 1));
        houses.add(new House(90000, 90, 2, 1));

        villas.add(new Villa(200000, 200, 5, 2));
        villas.add(new Villa(250000, 250, 6, 2));
        villas.add(new Villa(300000, 300, 6, 3));

        summerHouses.add(new SummerHouse(150000, 150, 4, 2));
        summerHouses.add(new SummerHouse(160000, 160, 4, 2));
        summerHouses.add(new SummerHouse(170000, 170, 5, 2));
    }

    public List<House> getHouses() {
        return houses;
    }

    public List<Villa> getVillas() {
        return villas;
    }

    public List<SummerHouse> getSummerHouses() {
        return summerHouses;
    }

    public double getTotalPriceOfHouses() {
        return houses.stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceOfVillas() {
        return villas.stream().mapToDouble(Villa::getPrice).sum();
    }

    public double getTotalPriceOfSummerHouses() {
        return summerHouses.stream().mapToDouble(SummerHouse::getPrice).sum();
    }

    public double TotalPriceOfAllTypeOfHouses() {
        return getTotalPriceOfHouses() + getTotalPriceOfVillas() + getTotalPriceOfSummerHouses();
    }

    public double getAverageSquareMeterHouses() {
        return houses.stream().mapToDouble(House::getSquareMeters).average().orElse(0);
    }

    public double getAverageSquareMeterVillas() {
        return villas.stream().mapToDouble(House::getSquareMeters).average().orElse(0);
    }

    public double getAverageSquareMeterSummerHouses() {
        return summerHouses.stream().mapToDouble(House::getSquareMeters).average().orElse(0);
    }

    public double getAverageSquareMeterAllTypes() {
        double totalSquareMeters = houses.stream().mapToDouble(House::getSquareMeters).sum() +
                villas.stream().mapToDouble(House::getSquareMeters).sum() +
                summerHouses.stream().mapToDouble(House::getSquareMeters).sum();
        int totalNumber = houses.size() + villas.size() + summerHouses.size();
        return totalSquareMeters / totalNumber;
    }

    public List<House> filterHousesByRoomsAndSalons(int numberOfRooms, int numberOfSalons) {
        return houses.stream()
                .filter(house -> house.getNumberOfRoom() == numberOfRooms && house.getNumberOfLivingRoom() == numberOfSalons)
                .collect(Collectors.toList());
    }

    public List<House> filterAllTypesByRoomsAndSalons(int numberOfRooms, int numberOfSalons) {
        return Stream.concat(Stream.concat(houses.stream(), villas.stream()), summerHouses.stream())
                .filter(property -> property.getNumberOfRoom() == numberOfRooms && property.getNumberOfLivingRoom() == numberOfSalons)
                .collect(Collectors.toList());
    }


}

package org.example;

public class Main {
    public static void main(String[] args) {
        HouseService houseService = new HouseService();

        System.out.println("Total price of all houses: " + houseService.getTotalPriceOfHouses());
        System.out.println("Total price of all villas: " + houseService.getTotalPriceOfVillas());
        System.out.println("Total price of all summer houses: " + houseService.getTotalPriceOfSummerHouses());
        System.out.println("Total price of all types of properties: " + houseService.TotalPriceOfAllTypeOfHouses());

        System.out.println("Average square meters of houses: " + houseService.getAverageSquareMeterHouses());
        System.out.println("Average square meters of villas: " + houseService.getAverageSquareMeterVillas());
        System.out.println("Average square meters of summer houses: " + houseService.getAverageSquareMeterSummerHouses());
        System.out.println("Average square meters of all types of properties: " + houseService.getAverageSquareMeterAllTypes());

        int numberOfRooms = 3;
        int numberOfSalons = 1;
        System.out.println("Houses filtered by " + numberOfRooms + " rooms and " + numberOfSalons + " salons: " + houseService.filterHousesByRoomsAndSalons(numberOfRooms, numberOfSalons).size());
        System.out.println("All types of properties filtered by " + numberOfRooms + " rooms and " + numberOfSalons + " salons: " + houseService.filterAllTypesByRoomsAndSalons(numberOfRooms, numberOfSalons).size());
    }
}
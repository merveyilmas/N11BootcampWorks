import entitiy.House;
import entitiy.Housing;
import entitiy.Summerhouse;
import entitiy.Villa;
import service.HouseService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Housing> houses = new ArrayList<>();
        houses.add(new House(100, 200000, 3, 2));
        houses.add(new House(120, 250000, 4, 3));
        houses.add(new House(160, 280000, 2, 4));
        houses.add(new Villa(300, 600000, 5, 4, 200));
        houses.add(new Villa(400, 800000, 7, 5, 300));
        houses.add(new Villa(400, 800000, 7, 5, 300));
        houses.add(new Summerhouse(80, 150000, 2, 3, true));
        houses.add(new Summerhouse(90, 180000, 2, 2, false));
        houses.add(new Summerhouse(60, 140000, 2, 1, true));

        HouseService service = new HouseService(houses);

        System.out.println("Total price of all houses: $" + service.totalPrice(House.class));
        System.out.println("Total price of all villas: $" + service.totalPrice(Villa.class));
        System.out.println("Total price of all summerhouse: $" + service.totalPrice(Summerhouse.class));
        System.out.println("Average area of all houses: " + service.averageArea(House.class) + " m²");
        System.out.println("Average area of all villas: " + service.averageArea(Villa.class) + " m²");
        System.out.println("Average area of all summerhouse: " + service.averageArea(Summerhouse.class) + " m²");
        System.out.println();

        int minRooms = 3;
        int minLivingRooms = 2;

        List<Housing> filteredHouses = service.filterByRoomsAndLivingRooms(minRooms, minLivingRooms);
        System.out.println("Houses with at least " + minRooms + " rooms and " + minLivingRooms + " living rooms:");
        for (Housing house : filteredHouses) {
            System.out.println(house);
        }

        System.out.println();
        System.out.println("Get all houses: " + service.getAllHouses());
        System.out.println("Get all villa houses: " + service.getAllVillas());
        System.out.println("Get all summerhouses: " + service.getAllSummerhouses());
    }
}
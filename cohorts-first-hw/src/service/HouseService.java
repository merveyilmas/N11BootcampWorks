package service;

import entitiy.House;
import entitiy.Housing;
import entitiy.Summerhouse;
import entitiy.Villa;

import java.util.ArrayList;
import java.util.List;

public class HouseService {

    private List<Housing> houses;

    public HouseService(List<Housing> houses) {
        this.houses = houses;
    }

    public List<Housing> getHouseList(Class<? extends Housing> houseType) {
        List<Housing> houseList = new ArrayList<>();

        for (Housing house : houses) {
            if (houseType.isInstance(house)) {
                houseList.add(house);
            }
        }
        return houseList;
    }

    public List<House> getAllHouses() {
        List<House> house = new ArrayList<>();
        for (Housing housing : houses) {
            if (housing instanceof House) {
                house.add((House) housing);
            }
        }
        return house;
    }
    public List<Villa> getAllVillas() {
        List<Villa> villas = new ArrayList<>();
        for (Housing house : houses) {
            if (house instanceof Villa) {
                villas.add((Villa) house);
            }
        }
        return villas;
    }

    public List<Summerhouse> getAllSummerhouses() {
        List<Summerhouse> summerhouses = new ArrayList<>();
        for (Housing house : houses) {
            if (house instanceof Summerhouse) {
                summerhouses.add((Summerhouse) house);
            }
        }
        return summerhouses;
    }

    public double totalPrice(Class<? extends Housing> houseType) {
        double total = 0;

        for (Housing house : houses) {
            if (houseType.isInstance(house)) {
                total += house.getPrice();
            }
        }
        return total;
    }

    public double averageArea(Class<? extends Housing> houseType) {
        List<Housing> houseList = getHouseList(houseType);
        double totalArea = 0;

        for (Housing house : houseList) {
            totalArea += house.getArea();
        }
        return totalArea / houseList.size();
    }

    public List<Housing> filterByRoomsAndLivingRooms(int minRooms, int minSalons) {
        List<Housing> filteredHouses = new ArrayList<>();

        for (Housing house : houses) {
            if (house.getRoomCount() >= minRooms && house.getSalonCount() >= minSalons) {
                filteredHouses.add(house);
            }
        }
        return filteredHouses;
    }
}

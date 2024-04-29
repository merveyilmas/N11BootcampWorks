package entitiy;

public class Villa extends Housing {
    private int gardenArea;

    public Villa(int area, double price, int roomCount, int salonCount, int gardenArea) {
        super(area, price, roomCount, salonCount);
        this.gardenArea = gardenArea;
    }

    public int getGardenArea() {
        return gardenArea;
    }

    @Override
    public String toString() {
        return "Villa: " + getArea() + " m², $" + getPrice() + ", " + getRoomCount() + " rooms, " + getSalonCount() + " livingRooms, " + gardenArea + " m² garden";
    }
}
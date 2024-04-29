package entitiy;

public class Housing {

    private int area;
    private double price;
    private int roomCount;
    private int salonCount;

    public Housing(int area, double price, int roomCount, int salonCount) {
        this.area = area;
        this.price = price;
        this.roomCount = roomCount;
        this.salonCount = salonCount;
    }

    public int getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getSalonCount() {
        return salonCount;
    }

    @Override
    public String toString() {
        return "House: " + area + " m², $" + price + ", " + roomCount + " rooms, " + salonCount + " salons";
    }
}

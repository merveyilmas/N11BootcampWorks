package entitiy;

public class Summerhouse extends Housing {
    private boolean hasBalcony;

    public Summerhouse(int area, double price, int roomCount, int salonCount, boolean hasBalcony) {
        super(area, price, roomCount, salonCount);
        this.hasBalcony = hasBalcony;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    @Override
    public String toString() {
        return "Summerhouse: " + getArea() + " m², $" + getPrice() + ", " + getRoomCount() + " rooms, " + getSalonCount() + " livingRooms, " + (hasBalcony ? "with" : "without") + " balcony";
    }

}

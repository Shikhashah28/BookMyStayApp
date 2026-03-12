public class BookMyStayApp {
    public static void main(String[]args){
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("Hotel Room Initialization\n");

        System.out.println("Single Room:");
        SingleRoom singleRoom = new SingleRoom();
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        System.out.println("Double Room:");
        DoubleRoom doubleRoom = new DoubleRoom();
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        System.out.println("Suite Room:");
        SuiteRoom suiteRoom = new SuiteRoom();
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}

/* Abstract Room Class */
abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

/* Single Room Class */
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/* Double Room Class */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/* Suite Room Class */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

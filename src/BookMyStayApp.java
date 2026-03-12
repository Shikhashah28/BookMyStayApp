import java.util.HashMap;
import java.util.Map;

/**
 * Room class stores room details
 */
class Room {

    private String roomType;
    private int beds;
    private int size;
    private double pricePerNight;

    public Room(String roomType, int beds, int size, double pricePerNight) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}


/**
 * RoomInventory class manages room availability
 */
class RoomInventory {

    // Map to store room availability
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes inventory
     */
    public RoomInventory() {
        initializeInventory();
    }

    /**
     * Initializes default room availability
     */
    private void initializeInventory() {

        roomAvailability = new HashMap<>();

        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Returns availability map
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Updates availability of a room type
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
public class BookMyStayApp{

    public static void main(String[] args) {

        // Create room objects
        Room singleRoom = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite", 3, 750, 5000.0);

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        // Single Room
        System.out.println("Single Room:");
        System.out.println("Beds: " + singleRoom.getBeds());
        System.out.println("Size: " + singleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + singleRoom.getPricePerNight());
        System.out.println("Available Rooms: "
                + inventory.getRoomAvailability().get("Single"));
        System.out.println();

        // Double Room
        System.out.println("Double Room:");
        System.out.println("Beds: " + doubleRoom.getBeds());
        System.out.println("Size: " + doubleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + doubleRoom.getPricePerNight());
        System.out.println("Available Rooms: "
                + inventory.getRoomAvailability().get("Double"));
        System.out.println();

        // Suite Room
        System.out.println("Suite Room:");
        System.out.println("Beds: " + suiteRoom.getBeds());
        System.out.println("Size: " + suiteRoom.getSize() + " sqft");
        System.out.println("Price per night: " + suiteRoom.getPricePerNight());
        System.out.println("Available Rooms: "
                + inventory.getRoomAvailability().get("Suite"));
    }
}
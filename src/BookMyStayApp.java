import java.util.*;

/**
 * MAIN CLASS - UseCase6RoomAllocation
 *
 * Demonstrates booking confirmation & room allocation using FIFO.
 */
public class BookMyStay {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        System.out.println("Room Allocation Processing");

        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            service.allocateRoom(reservation, inventory);
        }
    }
}

/**
 * Reservation class
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

/**
 * RoomInventory class
 */
class RoomInventory {

    private Map<String, Integer> availableRooms;

    public RoomInventory() {
        availableRooms = new HashMap<>();

        // Initial inventory
        availableRooms.put("Single", 2);
        availableRooms.put("Suite", 1);
    }

    public boolean isAvailable(String roomType) {
        return availableRooms.getOrDefault(roomType, 0) > 0;
    }

    public void allocateRoom(String roomType) {
        if (isAvailable(roomType)) {
            availableRooms.put(roomType, availableRooms.get(roomType) - 1);
        }
    }
}

/**
 * RoomAllocationService class
 */
class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        if (!inventory.isAvailable(roomType)) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.allocateRoom(roomType);

        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String roomId = roomType + "-" + count;

        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = roomType + "-" + count;
        }

        return roomId;
    }
}
import java.util.LinkedList;
import java.util.Queue;

// Reservation class
class Reservation {
    private String guestName;
    private String roomType;

    // Constructor
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // Getter methods
    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// BookingRequestQueue class
class BookingRequestQueue {
    private Queue<Reservation> queue;

    // Constructor
    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
    }

    // Check if queue has requests
    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }

    // Process next request
    public Reservation processRequest() {
        return queue.poll();
    }
}

// Main class
public class BookMyStayApp{

    public static void main(String[] args) {

        // Display application header
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queued booking requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation r = bookingQueue.processRequest();
            System.out.println("Processing booking for Guest: "
                    + r.getGuestName() + ", Room Type: "
                    + r.getRoomType());
        }
    }
}
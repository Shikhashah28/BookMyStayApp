import java.util.*;

public class BookMyStay {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        BookingAuditManager manager = new BookingAuditManager();

        // Adding confirmed bookings
        manager.confirmBooking(new Booking("B101", "Shikha", "Single Room"));
        manager.confirmBooking(new Booking("B102", "Rahul", "Double Room"));
        manager.confirmBooking(new Booking("B103", "Priya", "Suite"));

        // Display audit trail
        manager.displayAuditTrail();
    }
}

/**
 * Represents a confirmed booking
 */
class Booking {

    private String bookingId;
    private String customerName;
    private String roomType;

    /**
     * Constructor
     *
     * @param bookingId booking ID
     * @param customerName customer name
     * @param roomType room type booked
     */
    public Booking(String bookingId, String customerName, String roomType) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
                ", Customer: " + customerName +
                ", Room: " + roomType;
    }
}

/**
 * Manages booking confirmations
 * and audit trail
 */
class BookingAuditManager {

    /**
     * Stores confirmed bookings
     * in insertion order
     */
    private List<Booking> auditTrail;

    /**
     * Constructor
     */
    public BookingAuditManager() {
        auditTrail = new ArrayList<>();
    }

    /**
     * Adds a confirmed booking
     *
     * @param booking booking object
     */
    public void confirmBooking(Booking booking) {
        auditTrail.add(booking);
    }

    /**
     * Displays all confirmed bookings
     * in order
     */
    public void displayAuditTrail() {
        System.out.println("Booking Audit Trail");
        System.out.println("--------------------");

        for (Booking booking : auditTrail) {
            System.out.println(booking);
        }
    }
}
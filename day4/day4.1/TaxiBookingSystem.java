import java.util.*;

public class TaxiBookingSystem {
    static List<Taxi> taxis = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int customerCounter = 1; // Auto-incrementing Customer ID

    public static void main(String[] args) {
        System.out.print("Enter number of taxis: ");
        int numTaxis = sc.nextInt();
        initializeTaxis(numTaxis);

        while (true) {
            System.out.println("\n1. Book Taxi\n2. Display Taxi Details\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void initializeTaxis(int n) {
        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public static void bookTaxi() {
        int customerId = customerCounter++; // Automatically increment Customer ID 
        System.out.print("Enter Pickup Point (A-F): ");
        char pickup = sc.next().toUpperCase().charAt(0);
        System.out.print("Enter Drop Point (A-F): ");
        char drop = sc.next().toUpperCase().charAt(0);
        System.out.print("Enter Pickup Time (in hours): ");
        int pickupTime = sc.nextInt();

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isAvailable(pickupTime)) {
                int distance = Math.abs(taxi.currentPoint - pickup);
                if (distance < minDistance ||
                        (distance == minDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)) {
                    selectedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("Booking rejected. No taxis available.");
            return;
        }

        int dropTime = pickupTime + Math.abs(drop - pickup);
        int amount = selectedTaxi.calculateEarnings(pickup, drop);
        int bookingId = selectedTaxi.bookings.size() + 1;

        Booking booking = new Booking(bookingId, customerId, pickup, drop, pickupTime, dropTime, amount);
        selectedTaxi.addBooking(booking);
        System.out.println("Taxi-" + selectedTaxi.id + " is allocated.");
    }

    public static void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.id + " Total Earnings: Rs." + taxi.totalEarnings);
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");
            for (Booking booking : taxi.bookings) {
                System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d%n",
                        booking.bookingId, booking.customerId, booking.from, booking.to,
                        booking.pickupTime, booking.dropTime, booking.amount);
            }
        }
    }
    // Nested Taxi class
    static class Taxi {
        int id;
        char currentPoint = 'A'; // Initially all taxis start at point A
        int totalEarnings = 0;
        List<Booking> bookings = new ArrayList<>();

        public Taxi(int id) {
            this.id = id;
        }

        public boolean isAvailable(int requestTime) {
            if (bookings.isEmpty()) return true;
            Booking lastBooking = bookings.get(bookings.size() - 1);
            return lastBooking.dropTime <= requestTime;
        }

        public int calculateEarnings(char from, char to) {
            int distance = Math.abs(to - from) * 15;
            return 100 + Math.max(0, (distance - 5) * 10);
        }

        public void addBooking(Booking booking) {
            bookings.add(booking);
            totalEarnings += booking.amount;
            currentPoint = booking.to;
        }
    }

    // Nested Booking class
    static class Booking {
        int bookingId, customerId, pickupTime, dropTime, amount;
        char from, to;

        public Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
            this.bookingId = bookingId;
            this.customerId = customerId;
            this.from = from;
            this.to = to;
            this.pickupTime = pickupTime;
            this.dropTime = dropTime;
            this.amount = amount;
        }
    }
}

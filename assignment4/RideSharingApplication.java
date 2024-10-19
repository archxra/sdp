package assignment4;

// Step 1: Define the FareStrategy interface
interface FareStrategy {
    double calculateFare(double distance, double duration);
}

// Step 2: Implement the different fare strategies
class RegularFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        return 1.00 * distance + 0.25 * duration;
    }
}

class PremiumFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        return 1.50 * distance + 0.40 * duration;
    }
}

class DiscountFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        double baseFare = 1.00 * distance + 0.25 * duration;
        return baseFare * 0.90; // 10% discount
    }
}

class SurgeFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        double baseFare = 1.00 * distance + 0.25 * duration;
        return baseFare * 2; // Double fare during peak hours
    }
}

// Step 3: Create the RideContext class
class RideContext {
    private FareStrategy strategy;

    public void setStrategy(FareStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFare(double distance, double duration) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance and duration must be non-negative");
        }
        // Handle minimum charge for short-distance rides
        double fare = strategy.calculateFare(distance, duration);
        return Math.max(fare, 5.00); // Minimum charge
    }
}

// Step 4: Create a Ride class
class Ride {
    private double distance;  // Keep these private
    private double duration;   // Keep these private
    private RideContext context;

    public Ride(double distance, double duration, FareStrategy strategy) {
        this.distance = distance;
        this.duration = duration;
        this.context = new RideContext();
        this.context.setStrategy(strategy);
    }

    // Getter for distance
    public double getDistance() {
        return distance;
    }

    // Getter for duration
    public double getDuration() {
        return duration;
    }

    public double getFare() {
        return context.calculateFare(distance, duration);
    }
}

// Step 5: Testing the implementation
public class RideSharingApplication {
    public static void main(String[] args) {
        Ride[] rides = {
                new Ride(10, 15, new RegularFareStrategy()),
                new Ride(5, 10, new PremiumFareStrategy()),
                new Ride(3, 5, new DiscountFareStrategy()),
                new Ride(8, 20, new SurgeFareStrategy())
        };

        for (Ride ride : rides) {
            System.out.printf("Distance: %.1f km, Duration: %.1f min, Fare: $%.2f%n",
                    ride.getDistance(), ride.getDuration(), ride.getFare());  // Use getters here
        }

        // Test invalid inputs
        try {
            Ride invalidRide = new Ride(-5, 10, new RegularFareStrategy());
            System.out.println(invalidRide.getFare());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
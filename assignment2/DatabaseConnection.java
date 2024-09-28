package assignment2;

// The Singleton class that ensures only one instance of the DatabaseConnection is created.
public class DatabaseConnection {

    // Step 1: Private static variable to hold the single instance of the class
    private static volatile DatabaseConnection instance = null;

    // Step 2: Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        // Private constructor prevents instantiation from other classes
    }

    // Step 3: Public static method to provide access to the single instance
    // Uses double-checked locking to ensure thread safety
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection(); // Lazy initialization
                }
            }
        }
        return instance;
    }

    // Method to simulate connecting to a database
    public void connect() {
        System.out.println("Connected to the database.");
    }

    // Method to simulate disconnecting from a database
    public void disconnect() {
        System.out.println("Disconnected from the database.");
    }
}

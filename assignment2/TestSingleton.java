package assignment2;

public class TestSingleton {

    public static void main(String[] args) {
        // Attempt to create multiple instances of DatabaseConnection
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        // Check if both instances are the same
        if (db1 == db2) {
            System.out.println("Both are the same instance.");
        } else {
            System.out.println("Different instances were created.");
        }

        // Test the connect and disconnect functionality
        db1.connect();
        db2.disconnect();
    }
}

import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<Integer, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put(1, new Product("Laptop", 1200, 10));
        products.put(2, new Product("Smartphone", 800, 5));
        products.put(3, new Product("Headphones", 150, 20));
    }

    public Product searchProduct(int productId) throws Exception {
        if (products.containsKey(productId)) {
            return products.get(productId);
        } else {
            throw new Exception("Product not found");
        }
    }
}

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }
}

class PaymentProcessor {
    public boolean processPayment(double amountToPay, double paymentAmount) throws Exception {
        if (paymentAmount >= amountToPay) {
            System.out.println("Payment successful! Change: $" + (paymentAmount - amountToPay));
            return true;
        } else {
            throw new Exception("Insufficient payment");
        }
    }
}

class InventoryManager {
    public boolean checkStock(Product product, int quantity) throws Exception {
        if (product.getStock() >= quantity) {
            return true;
        } else {
            throw new Exception("Insufficient stock");
        }
    }

    public void updateStock(Product product, int quantity) {
        product.reduceStock(quantity);
        System.out.println("Stock updated for product: " + product.getName());
    }
}

class ShippingService {
    public double calculateShipping(String location) {
        if ("domestic".equalsIgnoreCase(location)) {
            return 10.0;
        } else if ("international".equalsIgnoreCase(location)) {
            return 50.0;
        }
        return 20.0;
    }

    public void shipOrder(String productName, String location) {
        System.out.println(productName + " has been shipped to " + location);
    }
}

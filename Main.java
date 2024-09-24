interface Product {
    double getDiscount();
    double getPrice();
}

class FoodProduct implements Product {
    private double price;

    public FoodProduct(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.1;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}

class ElectronicsProduct implements Product {
    private double price;

    public ElectronicsProduct(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.05;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}

class ClothingProduct implements Product {
    private double price;

    public ClothingProduct(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.15;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}

class DiscountCalculator {
    public double calculateDiscount(Product product) {
        return product.getDiscount();
    }
}

public class Main {
    public static void main(String[] args) {
        Product food = new FoodProduct(100);
        Product electronics = new ElectronicsProduct(200);
        Product clothing = new ClothingProduct(150);

        DiscountCalculator discountCalculator = new DiscountCalculator();

        System.out.println("Food Product Discount: " + discountCalculator.calculateDiscount(food));
        System.out.println("Electronics Product Discount: " + discountCalculator.calculateDiscount(electronics));
        System.out.println("Clothing Product Discount: " + discountCalculator.calculateDiscount(clothing));
    }
}
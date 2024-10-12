public class ShoppingClient {
    public static void main(String[] args) {
        ShoppingFacade facade = new ShoppingFacade();

        int productId = 1;
        int quantity = 1;
        double paymentAmount = 1300;
        String shippingLocation = "domestic";

        System.out.println("Placing order...\n");
        facade.placeOrder(productId, quantity, paymentAmount, shippingLocation);
    }
}
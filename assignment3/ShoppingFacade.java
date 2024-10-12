class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public void placeOrder(int productId, int quantity, double paymentAmount, String shippingLocation) {
        try {
            Product product = productCatalog.searchProduct(productId);
            System.out.println("Selected Product: " + product.getName() + ", Price: $" + product.getPrice());

            inventoryManager.checkStock(product, quantity);
            System.out.println("Stock is available for " + product.getName());

            paymentProcessor.processPayment(product.getPrice() * quantity, paymentAmount);

            inventoryManager.updateStock(product, quantity);

            double shippingCost = shippingService.calculateShipping(shippingLocation);
            System.out.println("Shipping cost: $" + shippingCost);
            shippingService.shipOrder(product.getName(), shippingLocation);

        } catch (Exception e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }
}
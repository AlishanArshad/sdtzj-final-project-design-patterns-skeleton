package inventory;

/**
 * Product class representing items in the inventory.
 * TODO: Implement this class with all required fields, constructor, and
 * methods.
 *
 * Requirements:
 * - Private fields: id, name, type, price, quantity
 * - Constructor with validation
 * - Getter and setter methods
 * - sell(), addStock(), isInStock() methods
 * - toString() method
 */
public class Product {
    public enum ProductType {
        BOOK, ELECTRONICS
    }

    // TODO: Declare private fields
    private String id;
    private String name;
    private String type;
    private double price;
    private int quantity;

    /**
     * TODO: Implement constructor
     * 
     * @param id       - unique product identifier
     * @param name     - product name
     * @param type     - product category (BOOK or ELECTRONICS)
     * @param price    - product price (must be non-negative)
     * @param quantity - stock quantity (must be non-negative)
     * @throws IllegalArgumentException if price or quantity is negative
     */

    public Product(String id, String name, String type, double price, int quantity) {
        // TODO: Implement constructor with validation
        // Hint: Check if price >= 0 and quantity >= 0
        // Throw IllegalArgumentException with descriptive message if invalid

        setId(id);
        setName(name);
        setType(type);
        setPrice(price);
        setQuantity(quantity);
    }

    // TODO: Implement getter methods
    // public String getId() { }
    // public String getName() { }
    // public String getType() { }
    // public double getPrice() { }
    // public int getQuantity() { }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // TODO: Implement setter methods with validation
    // public void setPrice(double price) { }
    // public void setQuantity(int quantity) { }

    public final void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        this.id = id;
    }

    public final void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        this.name = name;
    }

    public final void setType(String type) {
        try {
            ProductType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid product type. Must be 'BOOK' or 'ELECTRONICS'.");
        }
        this.type = type;
    }

    public final void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public final void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    /**
     * TODO: Implement sell method
     * 
     * @param amount - quantity to sell
     * @return true if sale successful, false if insufficient stock
     */
    public boolean sell(int amount) {
        // TODO: Implement sell logic
        // Check if amount is valid and sufficient stock exists
        // Update quantity if successful

        if (amount <= 0 || amount > quantity) {
            return false; // Invalid amount or insufficient stock
        }
        quantity -= amount; // Reduce stock by sold amount
        return true; // Sale successful
    }

    /**
     * TODO: Implement addStock method
     * 
     * @param amount - quantity to add to stock
     */
    public void addStock(int amount) {
        // TODO: Implement stock addition
        // Validate amount is positive before adding
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to add must be positive.");
        }
    }

    /**
     * TODO: Implement isInStock method
     * 
     * @return true if product has stock available
     */
    public boolean isInStock() {
        // TODO: Return true if quantity > 0
        if (quantity > 0) {
            return true;
        }
        return false; // Placeholder
    }

    /**
     * TODO: Implement toString method
     * 
     * @return formatted string representation of the product
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }

}
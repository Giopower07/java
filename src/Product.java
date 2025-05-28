package cashregister.src;

/**
 * classe astratta con valori di tipo protected
 */
public abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public abstract String getCategory();

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.name = newName;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            this.price = newPrice;
        }
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price = price - (price * percentage / 100.0);
        }
    }

    public boolean isSameProduct(Product other) {
        if (other == null) return false;
        return this.name.equalsIgnoreCase(other.name)
                && this.getCategory().equalsIgnoreCase(other.getCategory());
    }

    public String getFormattedLabel() {
        return String.format("%s - %s: €%.2f", getCategory(), name, price);
    }

    public boolean isExpensive(double threshold) {
        return price > threshold;
    }

}

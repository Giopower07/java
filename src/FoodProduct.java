package cashregister.src;

/**
 * clase pubblica che estende la classe padre product
 */
public class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    /**
     * metodo che torna la stringa food
     * @return
     */
    @Override
    public String getCategory() {
        return "Food";
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}

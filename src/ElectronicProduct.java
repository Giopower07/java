package cashregister.src;

/**
 * classe che estende la classe padre product
 */
public class ElectronicProduct extends Product {
    private int warrantyMonths;

    /**
     * metodo costruttore
     * @param name
     * @param price
     * @param warrantyMonths
     */
    public ElectronicProduct(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    /**metodo che ritorna una stringa
     *
     * @return
     */
    @Override
    public String getCategory() {
        return "Electronics";
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}

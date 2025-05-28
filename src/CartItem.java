package cashregister.src;

/** classe nel quale sono stati dichiarati due attributi privati
 *
 */
public class CartItem {
    private Product product;
    private int quantity;

    /** Metodo costruttore nel quale si usa il this,
     * qui troviamo due parametri ,uno di tipo int e uno di tipo Product
     *
     * @param product
     * @param quantity
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /** questo è un metodo get di tipo double che ritorna il valore del calcolo in formato double
     *
     * @return
     */
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    /**
     * metodo get che ritorna product
     * @return
     */
    public Product getProduct() {
        return product;
    }

    /**
     * metodo get che ritorna la quantità
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * metodo per aumentare o diminuire la quantità
     * @param amount
     */
    public void increaseQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    public void decreaseQuantity(int amount) {
        if (amount > 0 && quantity - amount > 0) {
            quantity -= amount;
        }
    }
}

package cashregister.src;

import java.util.Iterator;

/**
 * classe pubblica che che contine variabili private
 */
public class CashRegister {
    private CartItem[] items;
    private int itemCount;
    private final double TAX_RATE = 0.22;

    public CashRegister() {
        items = new CartItem[10];
        itemCount = 0;
    }
/** metodo privato che contiene un if con allinterno la creazione dei un array
 * e un ciclo for
 *
 */
    private void ensureCapacity() {
        if (itemCount >= items.length) {
            CartItem[] newItems = new CartItem[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    /**
     * metodo nel quale all'interno c'è un ciclo for che contiene un if e non torna valori essendo void
     * @param product
     * @param quantity
     */
    public void addItem(Product product, int quantity) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equals(product.getName())) {
                items[i].increaseQuantity(quantity);
                return;
            }
        }
        ensureCapacity();
        items[itemCount++] = new CartItem(product, quantity);
    }

    /**metodo nel quale all'interno c'è un ciclo for che contiene un if e a sua volta contiene un altro for e non torna valori essendo void
     *
     * @param productName
     */
    public void removeItemByName(String productName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equalsIgnoreCase(productName)) {
                // sposta indietro tutti gli elementi successivi
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[itemCount - 1] = null;
                itemCount--;
                break;
            }
        }
    }

    /**
     *  calcola e torna il totale
     * @return
     */
    public double calculateSubtotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getSubtotal();
        }
        return total;
    }

    /**
     *  calcola il totale e con le tasse e torna il valore
     * @return
     */
    public double calculateTotalWithTax() {
        return calculateSubtotal() * (1 + TAX_RATE);
    }

    /**conta gli items totali attraverso un ciclo for e torna il totale
     *
     * @return
     */
    public int countTotalItems() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getQuantity();
        }
        return total;
    }

    /**
     * calcola i prezzi medi delle categorie attraverso un for e un if
     * @param category
     * @return
     */
    public double averagePriceByCategory(String category) {
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < itemCount; i++) {
            Product p = items[i].getProduct();
            if (p.getCategory().equalsIgnoreCase(category)) {
                sum += p.getPrice();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    /**
     * metodo che serve per applicare gli sconti in base alla categoria del prodotto
     * @param category
     * @param percent
     */
    public void applyDiscountToCategory(String category, double percent) {
        for (int i = 0; i < itemCount; i++) {
            Product p = items[i].getProduct();
            if (p.getCategory().equalsIgnoreCase(category)) {
                p.applyDiscount(percent);
            }
        }
    }

    /**
     * metodo per stampare la ricevuta con tutti i dettagli del prodotto
     */
    public void printReceipt() {
        System.out.println("=== RECEIPT ===");
        for (int i = 0; i < itemCount; i++) {
            CartItem item = items[i];
            Product p = item.getProduct();
            System.out.printf("%s (%s) x%d = €%.2f%n",
                    p.getName(),
                    p.getCategory(),
                    item.getQuantity(),
                    item.getSubtotal()
            );
        }
        System.out.printf("Subtotal: €%.2f%n", calculateSubtotal());
        System.out.printf("Total with tax: €%.2f%n", calculateTotalWithTax());
        System.out.printf("Items: %d%n", countTotalItems());
        System.out.println("================");
    }

    /**
     * metodo  per  assegnare un valore booleano cioè vero o falso in base ai dettagli del prodotto che vengono forniti
     * @param productName
     * @return
     */
    public boolean containsProduct(String productName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < itemCount; i++) {
            items[i] = null;
        }
        itemCount = 0;
    }
}

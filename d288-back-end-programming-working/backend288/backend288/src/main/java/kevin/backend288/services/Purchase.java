package kevin.backend288.services;

import kevin.backend288.entities.Customer;
import kevin.backend288.entities.Cart;
import kevin.backend288.entities.CartItem;
import lombok.Data;
import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

    // Constructor
    public Purchase(Customer customer, Cart cart, Set<CartItem> cartItems) {
        this.customer = customer;
        this.cart = cart;
        this.cartItems = cartItems;
    }
}

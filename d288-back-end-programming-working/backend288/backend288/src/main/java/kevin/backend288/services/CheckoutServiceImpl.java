package kevin.backend288.services;

import kevin.backend288.dao.CustomerRepository;
import kevin.backend288.dao.CartRepository;
import kevin.backend288.dao.CartItemRepository;
import kevin.backend288.entities.Cart;
import kevin.backend288.entities.CartItem;
import kevin.backend288.entities.Customer;
import kevin.backend288.entities.StatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        // Set cart status to pending before processing
        cart.setStatus(StatusType.pending);

        // Validations
        if (cartItems == null || cartItems.isEmpty()) {
            cart.setStatus(StatusType.canceled);
            return new PurchaseResponse("ERROR!!! Cart is empty");
        }

        if (cart.getParty_size() < 1) {
            cart.setStatus(StatusType.canceled);
            return new PurchaseResponse("ERROR!!! party size must be at least 1");
        }


        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.addCartItem(item);   // Add CartItem to the Cart
        });

        // Associate customer with the cart
        cart.setCustomer(customer);

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrder_tracking_number(orderTrackingNumber);  // Set tracking number

        // Update cart status to ordered after success
        cart.setStatus(StatusType.ordered);

        // Save the cart and customer to the database
        customerRepository.save(customer);
        cartRepository.save(cart);

        // Return the generated tracking number after saving to the database
        return new PurchaseResponse(orderTrackingNumber);
    }

    // Generates a unique tracking number
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString(); // Simplified to return UUID directly
    }
}

package kevin.backend288.controllers;

import kevin.backend288.services.CheckoutService;
import kevin.backend288.services.Purchase;
import kevin.backend288.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// Task H RestController to place order
@RestController
@RequestMapping("/api/checkout")
@CrossOrigin

public class CheckoutController {

    private final CheckoutService checkoutService;


    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return new ResponseEntity<>(purchaseResponse, HttpStatus.OK);
    }
}

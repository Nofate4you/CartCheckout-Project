package kevin.backend288.services;

import lombok.Data;

@Data
public class PurchaseResponse {
    private String orderTrackingNumber;

    // Constructor
    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}

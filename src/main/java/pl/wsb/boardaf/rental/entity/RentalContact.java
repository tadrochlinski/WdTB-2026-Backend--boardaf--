
package pl.wsb.boardaf.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RentalContact {

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerEmail;

    protected RentalContact() {}

    public RentalContact(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
}

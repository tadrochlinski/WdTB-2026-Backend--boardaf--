package pl.wsb.boardaf.customer.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import pl.wsb.boardaf.account.domain.UserAccount;

@Entity
@Table(name = "customer_profile")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String customerNumber;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false)
    private LocalDate registeredOn;

    @Column(nullable = false)
    private Boolean active;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id",
                nullable = false, unique = true)
    private UserAccount account;

    protected CustomerProfile() {}

    public CustomerProfile(String customerNumber, String phone,
                           LocalDate registeredOn, Boolean active,
                           UserAccount account) {
        this.customerNumber = customerNumber;
        this.phone = phone;
        this.registeredOn = registeredOn;
        this.active = active;
        this.account = account;
    }

    public Long getId() { return id; }
    public String getCustomerNumber() { return customerNumber; }
    public String getPhone() { return phone; }
    public LocalDate getRegisteredOn() { return registeredOn; }
    public Boolean getActive() { return active; }
    public UserAccount getAccount() { return account; }
}
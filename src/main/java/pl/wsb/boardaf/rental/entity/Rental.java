
package pl.wsb.boardaf.rental.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rentalCode;

    @Column(nullable = false)
    private String gameTitle;

    @Column(nullable = false)
    private LocalDate rentedOn;

    @Column(nullable = false)
    private LocalDate dueOn;

    @Column(nullable = false)
    private Boolean returned;

    @Embedded
    private RentalContact contact;

    protected Rental() {}

    public Rental(String rentalCode, String gameTitle,
                  LocalDate rentedOn, LocalDate dueOn,
                  Boolean returned, RentalContact contact) {
        this.rentalCode = rentalCode;
        this.gameTitle = gameTitle;
        this.rentedOn = rentedOn;
        this.dueOn = dueOn;
        this.returned = returned;
        this.contact = contact;
    }

    public Long getId() { return id; }
    public String getRentalCode() { return rentalCode; }
    public String getGameTitle() { return gameTitle; }
    public LocalDate getRentedOn() { return rentedOn; }
    public LocalDate getDueOn() { return dueOn; }
    public Boolean getReturned() { return returned; }
    public RentalContact getContact() { return contact; }
}

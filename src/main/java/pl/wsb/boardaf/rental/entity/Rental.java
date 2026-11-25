package pl.wsb.boardaf.rental.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import pl.wsb.boardaf.game.entity.BoardGame;
import pl.wsb.boardaf.customer.entity.CustomerProfile;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rentalCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_game_id", nullable = false)
    private BoardGame boardGame;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_profile_id", nullable = false)
    private CustomerProfile customerProfile;

    @Column(nullable = false)
    private LocalDate rentedOn;

    @Column(nullable = false)
    private LocalDate dueOn;

    @Column(nullable = false)
    private Boolean returned;

    @Embedded
    private RentalContact contact;

    protected Rental() {}

    public Rental(String rentalCode,
                  BoardGame boardGame,
                  CustomerProfile customerProfile,
                  LocalDate rentedOn,
                  LocalDate dueOn,
                  Boolean returned,
                  RentalContact contact) {
        this.rentalCode = rentalCode;
        this.boardGame = boardGame;
        this.customerProfile = customerProfile;
        this.rentedOn = rentedOn;
        this.dueOn = dueOn;
        this.returned = returned;
        this.contact = contact;
    }

    public Long getId() { return id; }
    public String getRentalCode() { return rentalCode; }
    public BoardGame getBoardGame() { return boardGame; }
    public CustomerProfile getCustomerProfile() { return customerProfile; }
    public LocalDate getRentedOn() { return rentedOn; }
    public LocalDate getDueOn() { return dueOn; }
    public Boolean getReturned() { return returned; }
    public RentalContact getContact() { return contact; }
}
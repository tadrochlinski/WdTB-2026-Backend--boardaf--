
package pl.wsb.boardaf.reservation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String reservationCode;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String gameTitle;

    @Column(nullable = false)
    private LocalDate reservedOn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    protected Reservation() {}

    public Reservation(String reservationCode, String customerName,
                       String gameTitle, LocalDate reservedOn,
                       ReservationStatus status) {
        this.reservationCode = reservationCode;
        this.customerName = customerName;
        this.gameTitle = gameTitle;
        this.reservedOn = reservedOn;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getReservationCode() { return reservationCode; }
    public String getCustomerName() { return customerName; }
    public String getGameTitle() { return gameTitle; }
    public LocalDate getReservedOn() { return reservedOn; }
    public ReservationStatus getStatus() { return status; }
}

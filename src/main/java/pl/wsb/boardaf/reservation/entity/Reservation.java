package pl.wsb.boardaf.reservation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import pl.wsb.boardaf.game.entity.BoardGame;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_game_id", nullable = false)
    private BoardGame boardGame;

    @Column(nullable = false)
    private LocalDate reservedOn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    protected Reservation() {}

    public Reservation(String reservationCode, String customerName,
                       BoardGame boardGame, LocalDate reservedOn,
                       ReservationStatus status) {
        this.reservationCode = reservationCode;
        this.customerName = customerName;
        this.boardGame = boardGame;
        this.reservedOn = reservedOn;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getReservationCode() { return reservationCode; }
    public String getCustomerName() { return customerName; }
    public BoardGame getBoardGame() { return boardGame; }
    public LocalDate getReservedOn() { return reservedOn; }
    public ReservationStatus getStatus() { return status; }
}
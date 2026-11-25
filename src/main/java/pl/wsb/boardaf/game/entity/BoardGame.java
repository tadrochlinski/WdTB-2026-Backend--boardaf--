package pl.wsb.boardaf.game.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import pl.wsb.boardaf.rental.entity.Rental;

@Entity
@Table(name = "board_game")
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false, length = 40)
    private String publisher;

    @Column(nullable = false)
    private Integer minPlayers;

    @Column(nullable = false)
    private Integer maxPlayers;

    @Column(nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "boardGame", fetch = FetchType.LAZY)
    private List<Rental> rentals = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "board_game_category",
        joinColumns = @JoinColumn(name = "board_game_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    protected BoardGame() {}

    public BoardGame(String title, String publisher,
                     Integer minPlayers, Integer maxPlayers,
                     Boolean available) {
        this.title = title;
        this.publisher = publisher;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.available = available;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getPublisher() { return publisher; }
    public Integer getMinPlayers() { return minPlayers; }
    public Integer getMaxPlayers() { return maxPlayers; }
    public Boolean getAvailable() { return available; }
    public List<Rental> getRentals() { return rentals; }
    public Set<Category> getCategories() { return categories; }
}
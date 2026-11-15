
package pl.wsb.boardaf.game.entity;

import jakarta.persistence.*;

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
}

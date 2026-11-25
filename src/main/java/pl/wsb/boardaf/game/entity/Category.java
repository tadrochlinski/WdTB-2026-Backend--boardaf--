package pl.wsb.boardaf.game.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String name;

    @Column(nullable = false, unique = true, length = 60)
    private String slug;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    private Boolean active;

    protected Category() {}

    public Category(String name, String slug,
                    String description, Boolean active) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getDescription() { return description; }
    public Boolean getActive() { return active; }
}
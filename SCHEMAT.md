# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: board_game_category) · kolumny: 37 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| board_game | BoardGame | 6 | — |
| category | Category | 5 | — |
| customer_profile | CustomerProfile | 6 | user_account_id |
| rental | Rental | 9 | board_game_id, customer_profile_id |
| reservation | Reservation | 6 | board_game_id, customer_profile_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    board_game {
        Long id PK
        Boolean available
        Integer max_players
        Integer min_players
        String publisher
        String title
    }
    category {
        Long id PK
        Boolean active
        String description
        String name
        String slug
    }
    customer_profile {
        Long id PK
        Boolean active
        String customer_number
        String phone
        LocalDate registered_on
        Long user_account_id FK
    }
    rental {
        Long id PK
        Long board_game_id FK
        String customer_email
        String customer_name
        Long customer_profile_id FK
        LocalDate due_on
        String rental_code
        LocalDate rented_on
        Boolean returned
    }
    reservation {
        Long id PK
        Long board_game_id FK
        Long customer_profile_id FK
        String reservation_code
        LocalDate reserved_on
        ReservationStatus status
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    board_game ||--o{ rental : "board_game_id"
    board_game ||--o{ reservation : "board_game_id"
    board_game }o--o{ category : "board_game_category"
    customer_profile ||--o{ rental : "customer_profile_id"
    customer_profile ||--o{ reservation : "customer_profile_id"
    user_account ||--o| customer_profile : "user_account_id"
```

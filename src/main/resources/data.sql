-- ===== LAB 01 · członkowie zespołu =====
INSERT INTO user_account
(display_name, email, role, created_at)
VALUES
    ('Tomasz Drochliński', 'tomasz.drochlinski@mail.com', 'ADMIN', CURRENT_TIMESTAMP),
    ('Zuzanna Zając', 'zuzanna.zajac@mail.com', 'PARTNER', CURRENT_TIMESTAMP),
    ('Weronika Burzyńska', 'weronika.burzynska@mail.com', 'USER', CURRENT_TIMESTAMP);

-- ===== LAB 02 · board_game =====
INSERT INTO board_game
(title, publisher, min_players, max_players, available)
VALUES
    ('Catan', 'Galakta', 3, 4, true),
    ('Dixit', 'Rebel', 3, 6, true),
    ('Carcassonne', 'Bard', 2, 5, false);



-- ===== LAB 02 · reservation =====
INSERT INTO reservation
(reservation_code, customer_name, game_title, reserved_on, status)
VALUES
    ('RES-001', 'Jan Kowalski', 'Catan', '2026-11-15', 'PENDING'),
    ('RES-002', 'Anna Nowak', 'Dixit', '2026-11-16', 'CONFIRMED'),
    ('RES-003', 'Piotr Zielinski', 'Carcassonne', '2026-11-17', 'CANCELLED');


-- ===== LAB 02 · rental =====
INSERT INTO rental
(rental_code, game_title, rented_on, due_on,
 returned, customer_name, customer_email)
VALUES
    ('RENT-001', 'Catan', '2026-11-10', '2026-11-20',
     false, 'Jan Kowalski', 'jan@example.com'),
    ('RENT-002', 'Dixit', '2026-11-05', '2026-11-15',
     true, 'Anna Nowak', 'anna@example.com'),
    ('RENT-003', 'Carcassonne', '2026-11-12', '2026-11-22',
     false, 'Piotr Zielinski', 'piotr@example.com');

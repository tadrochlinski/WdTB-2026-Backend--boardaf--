-- ===== LAB 01 · członkowie zespołu =====
INSERT INTO user_account
(display_name, email, role, created_at)
VALUES
    ('Tomasz Drochliński', 'tomasz.drochlinski@mail.com', 'ADMIN', CURRENT_TIMESTAMP),
    ('Zuzanna Zając', 'zuzanna.zajac@mail.com', 'PARTNER', CURRENT_TIMESTAMP),
    ('Weronika Burzyńska', 'weronika.burzynska@mail.com', 'USER', CURRENT_TIMESTAMP);


-- ===== LAB 03 · konta klientów =====
INSERT INTO user_account
(display_name, email, role, created_at)
VALUES
    ('Jan Kowalski', 'jan@example.com', 'USER', CURRENT_TIMESTAMP),
    ('Anna Nowak', 'anna@example.com', 'USER', CURRENT_TIMESTAMP),
    ('Piotr Zielinski', 'piotr@example.com', 'USER', CURRENT_TIMESTAMP);


-- ===== LAB 03 · customer_profile =====
INSERT INTO customer_profile
(customer_number, phone, registered_on, active, user_account_id)
VALUES
    ('CUS-001', NULL, '2026-10-01', true, 4),
    ('CUS-002', NULL, '2026-10-05', true, 5),
    ('CUS-003', NULL, '2026-10-10', true, 6);


-- ===== LAB 02 · board_game =====
INSERT INTO board_game
(title, publisher, min_players, max_players, available)
VALUES
    ('Catan', 'Galakta', 3, 4, true),
    ('Dixit', 'Rebel', 3, 6, true),
    ('Carcassonne', 'Bard', 2, 5, false);


-- ===== LAB 02 · reservation (relacje LAB 03) =====
INSERT INTO reservation
(reservation_code, customer_profile_id, board_game_id, reserved_on, status)
VALUES
    ('RES-001', 1, 1, '2026-11-15', 'PENDING'),
    ('RES-002', 2, 2, '2026-11-16', 'CONFIRMED'),
    ('RES-003', 3, 3, '2026-11-17', 'CANCELLED');


-- ===== LAB 02 · rental (relacje LAB 03) =====
INSERT INTO rental
(rental_code, board_game_id, rented_on, due_on,
 returned, customer_name, customer_email)
VALUES
    ('RENT-001', 1, '2026-11-10', '2026-11-20',
     false, 'Jan Kowalski', 'jan@example.com'),
    ('RENT-002', 2, '2026-11-05', '2026-11-15',
     true, 'Anna Nowak', 'anna@example.com'),
    ('RENT-003', 3, '2026-11-12', '2026-11-22',
     false, 'Piotr Zielinski', 'piotr@example.com');
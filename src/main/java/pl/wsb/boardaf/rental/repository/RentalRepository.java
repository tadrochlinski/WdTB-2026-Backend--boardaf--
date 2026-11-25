package pl.wsb.boardaf.rental.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.boardaf.rental.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByBoardGame_Title(String title);

}
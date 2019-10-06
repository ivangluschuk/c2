package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.WordCardDeck;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordCardDeckRepository extends JpaRepository<WordCardDeck, DomainCompositeKey> {

    List<WordCardDeck> findByTitle(@NonNull String title);
}

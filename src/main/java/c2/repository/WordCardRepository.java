package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.WordCard;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordCardRepository extends JpaRepository<WordCard, DomainCompositeKey> {

    List<WordCard> findByWord(@NonNull String word);
}

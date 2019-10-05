package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.WordCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordCardRepository extends JpaRepository<WordCard, DomainCompositeKey> {
}

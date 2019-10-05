package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, DomainCompositeKey> {
}

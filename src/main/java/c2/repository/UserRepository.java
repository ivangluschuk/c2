package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, DomainCompositeKey> {

    List<User> findByName(@NonNull String name);
}

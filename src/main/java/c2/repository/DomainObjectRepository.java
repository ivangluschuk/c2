package c2.repository;

import c2.model.DomainObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainObjectRepository extends JpaRepository<DomainObject, Long> {
}

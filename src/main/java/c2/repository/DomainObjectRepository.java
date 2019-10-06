package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.DomainObject;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainObjectRepository extends JpaRepository<DomainObject, DomainCompositeKey> {

    List<DomainObject> findByDomainIdType(@NonNull Integer domainIdType);
}

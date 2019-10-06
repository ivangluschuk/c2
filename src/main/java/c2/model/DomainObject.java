package c2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "domain_object")
@IdClass(DomainCompositeKey.class)
@NoArgsConstructor
@RequiredArgsConstructor
public class DomainObject {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Id
    @Column(name = "id_type", nullable = false)
    private Integer idType = DomainObjectIdType.DOMAIN_OBJECT.getIdType();

    @Getter
    @Setter
    @NonNull
    @Column(name = "domain_id_type", nullable = false)
    private Integer domainIdType;

    @Getter
    @Setter
    @NonNull
    @Column(name = "domain_id_type_value", nullable = false)
    private String domainIdTypeValue;
}

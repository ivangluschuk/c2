package c2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "domain_object")
@NoArgsConstructor
@RequiredArgsConstructor
public class DomainObject {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @NonNull
    @Column(name = "id_type")
    private String idType;

}

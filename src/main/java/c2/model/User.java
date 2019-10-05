package c2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@IdClass(DomainCompositeKey.class)
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Getter
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Id
    @Column(name = "id_type")
    private String idType = "usr";


    @Getter
    @Setter
    @NonNull
    @Column(name = "name")
    private String name;
}

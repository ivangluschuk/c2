package c2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "word_card")
@IdClass(DomainCompositeKey.class)
@NoArgsConstructor
@RequiredArgsConstructor
public class WordCard {

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
    private Integer idType = DomainObjectIdType.WORD_CARD.getIdType();

    @Getter
    @Setter
    @NonNull
    @Column(name = "word", nullable = false)
    private String word;

    @Getter
    @Setter
    @NonNull
    @Column(name = "translation", nullable = false)
    private String translation;

    @Getter
    @Setter
    @Column(name = "definition")
    private String definition;
}

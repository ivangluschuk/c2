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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @NonNull
    @Id
    @Column(name = "id_type")
    private String idType = "word_card";

    @Getter
    @Setter
    @NonNull
    @Column(name = "word")
    private String word;

    @Getter
    @Setter
    @NonNull
    @Column(name = "translation")
    private String translation;

    @Getter
    @Setter
    @NonNull
    @Column(name = "definition")
    private String definition;


}

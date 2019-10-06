package c2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "word_card_deck")
@IdClass(DomainCompositeKey.class)
//@NoArgsConstructor
//@RequiredArgsConstructor
public class WordCardDeck {

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
    private Integer idType = DomainObjectIdType.WORD_CARD_DECK.getIdType();

    @Getter
    @Setter
    private int size;

    @Getter
    @Setter
    @NonNull
    private String title;

    @Getter
    @Setter
    @OneToMany(
        targetEntity = WordCard.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JoinColumns({
        @JoinColumn(name = "deck_id", referencedColumnName = "id"),
        @JoinColumn(name = "deck_id_type", referencedColumnName = "id_type"),
    })
    List<WordCard> wordCards;
}

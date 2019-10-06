package c2.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
@IdClass(DomainCompositeKey.class)
public class User {

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
    private Integer idType = DomainObjectIdType.USR.getIdType();

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @OneToMany(
        targetEntity = WordCard.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JoinColumns({
        @JoinColumn(name = "owner_id", referencedColumnName = "id"),
        @JoinColumn(name = "owner_id_type", referencedColumnName = "id_type"),
    })
    List<WordCard> wordCards;

    @Getter
    @Setter
    @OneToMany(
        targetEntity = WordCardDeck.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JoinColumns({
        @JoinColumn(name = "owner_id", referencedColumnName = "id"),
        @JoinColumn(name = "owner_id_type", referencedColumnName = "id_type"),
    })
    List<WordCardDeck> wordCardDecks;
}

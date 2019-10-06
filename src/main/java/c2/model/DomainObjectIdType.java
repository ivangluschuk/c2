package c2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DomainObjectIdType {
    DOMAIN_OBJECT(1000),
    USR(1001),
    WORD_CARD(1002),
    WORD_CARD_DECK(1003);

    @Getter
    private int idType;
}

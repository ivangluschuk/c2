package c2.repository;

import c2.model.WordCard;
import c2.model.WordCardDeck;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WordCardDeckRepositoryTest {

    @Autowired
    WordCardDeckRepository wordCardDeckRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void addWordCardDeck() {

        var wordCards = new ArrayList<WordCard>();
        wordCards.add(new WordCard("a word", "слово"));
        wordCards.add(new WordCard("a title", "название"));

        var wordCardDeck = new WordCardDeck();
        wordCardDeck.setTitle("deck title");
        wordCardDeck.setWordCards(wordCards);

        Assertions.assertThatCode(() -> wordCardDeckRepository.save(wordCardDeck))
                .doesNotThrowAnyException();
    }

    @Test
    @Transactional
    public void findWordCardDeckByTitle() {

        var wordCards = new ArrayList<WordCard>();
        wordCards.add(new WordCard("a word", "слово"));
        wordCards.add(new WordCard("a title", "название"));

        var wordCardDeck = new WordCardDeck();
        wordCardDeck.setTitle("deck title");
        wordCardDeck.setWordCards(wordCards);

        Assertions.assertThatCode(() -> {
            wordCardDeckRepository.save(wordCardDeck);
            var newWordCardDecks = wordCardDeckRepository.findByTitle("deck title");

            var newWordCards = newWordCardDecks.get(0).getWordCards();

            Assert.assertEquals(newWordCardDecks.get(0).getTitle(), "deck title");
            Assert.assertEquals(newWordCardDecks.get(0).getWordCards().size(), 2);
            Assert.assertEquals(newWordCards.get(0).getWord(), "a word");
            Assert.assertEquals(newWordCards.get(1).getWord(), "a title");
        }).doesNotThrowAnyException();
    }
}

package c2.repository;

import c2.model.WordCard;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WordCardRepositoryTest{

    @Autowired
    WordCardRepository wordCardRepository;

    @Test
    public void addWordCard() {

        var wordCard = new WordCard();
        wordCard.setWord("a word");
        wordCard.setTranslation("слово");

        Assertions.assertThatCode(() -> wordCardRepository.save(wordCard))
                .doesNotThrowAnyException();
    }

    @Test
    public void findWordCardByWord() {

        var wordCard = new WordCard();
        wordCard.setWord("a word");
        wordCard.setTranslation("слово");

        Assertions.assertThatCode(() -> {
            wordCardRepository.save(wordCard);
            var words = wordCardRepository.findByWord("a word");

            Assert.assertEquals(words.get(0).getWord(), "a word");
        }).doesNotThrowAnyException();
    }
}

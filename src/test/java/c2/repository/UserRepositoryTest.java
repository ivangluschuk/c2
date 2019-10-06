//package c2.repository;
//
//import c2.model.DomainCompositeKey;
//import c2.model.User;
//import c2.model.WordCard;
//import org.assertj.core.api.Assertions;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestPropertySource("/application-test.properties")
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//public class UserRepositoryTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    public void addUser() {
//
//        var user = new User();
//        user.setName("Eve");
//
//        Assertions.assertThatCode(() -> userRepository.save(user))
//                .doesNotThrowAnyException();
//    }
//
//    @Test
//    public void findUserByName() {
//
//        var user = new User();
//        user.setName("Eve");
//
//        Assertions.assertThatCode(() -> {
//
//            userRepository.save(user);
//            var users = userRepository.findByName("Eve");
//
//            Assert.assertEquals("Eve", users.get(0).getName());
//        }).doesNotThrowAnyException();
//    }
//
//    @Test
//    @Transactional
//    public void addWordCard() {
//
//        var user = new User();
//        user.setName("Eve");
//
//        Assertions.assertThatCode(() -> {
//            List<WordCard> wordCards = new ArrayList<>();
//            wordCards.add(new WordCard("a word", "слово"));
//            user.setWordCards(wordCards);
//            userRepository.save(user);
//
//            var users = userRepository.findByName("Eve");
//            wordCards = users.get(0).getWordCards();
//
//            Assert.assertEquals(wordCards.get(0).getWord(), "a word");
//            Assert.assertEquals(wordCards.get(0).getTranslation(), "слово");
//        }).doesNotThrowAnyException();
//    }
//}

package c2.repository;

import c2.model.DomainCompositeKey;
import c2.model.DomainObject;
import c2.model.DomainObjectIdType;
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
public class DomainObjectRepositoryTest{

    @Autowired
    DomainObjectRepository domainObjectRepository;

    @Test
    public void addDomainObject() {

        var domainObject = new DomainObject();
        domainObject.setDomainIdType(DomainObjectIdType.USR.getIdType());
        domainObject.setDomainIdTypeValue(DomainObjectIdType.USR.name());

        Assertions.assertThatCode(() -> domainObjectRepository.save(domainObject))
                .doesNotThrowAnyException();
    }

    @Test
    public void findDomainObjectById() {

        var domainObject = new DomainObject();
        domainObject.setDomainIdType(DomainObjectIdType.USR.getIdType());
        domainObject.setDomainIdTypeValue(DomainObjectIdType.USR.name());

        Assertions.assertThatCode(() -> {
            domainObjectRepository.save(domainObject);
            var domainObjects = domainObjectRepository
                    .findByDomainIdType(DomainObjectIdType.USR.getIdType());

            Assert.assertEquals((Integer) DomainObjectIdType.USR.getIdType(), domainObjects.get(0).getDomainIdType());
            Assert.assertEquals(DomainObjectIdType.USR.name(), domainObjects.get(0).getDomainIdTypeValue());
        }).doesNotThrowAnyException();
    }
}

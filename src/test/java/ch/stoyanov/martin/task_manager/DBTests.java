package ch.stoyanov.martin.task_manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ch.stoyanov.martin.task_manager.people.People;
import ch.stoyanov.martin.task_manager.people.PeopleRepository;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DBTests {
    
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void insertPeople() {
        People peopleA = this.peopleRepository.save(new People(null, "username1", "martin", "stoyanov", 17));
        Assertions.assertNotNull(peopleA.getFirstName());
        People peopleB = this.peopleRepository.save(new People(null, "username1", "martin", "stoyanov", 17));
        Assertions.assertNotNull(peopleB.getFirstName());
    }
}

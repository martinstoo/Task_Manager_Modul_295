package ch.stoyanov.martin.task_manager.people;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    List<People> findByOrderByUsernameAsc();
}

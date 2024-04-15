package ch.stoyanov.martin.task_manager;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskManagerRepository extends JpaRepository<TaskManager, Long> {
    List<TaskManager> findByOrderByNameAsc();
}

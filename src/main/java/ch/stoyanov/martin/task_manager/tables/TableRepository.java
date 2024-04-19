package ch.stoyanov.martin.task_manager.tables;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> findByOrderByTitleAsc();
}

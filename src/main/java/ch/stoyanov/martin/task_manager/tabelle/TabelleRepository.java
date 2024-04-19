package ch.stoyanov.martin.task_manager.tabelle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelleRepository extends JpaRepository<Tabelle, Long> {
    List<Tabelle> findByOrderByTitleAsc();
}

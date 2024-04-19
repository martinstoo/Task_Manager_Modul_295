package ch.stoyanov.martin.task_manager.tables;

import org.springframework.stereotype.Service;

import ch.stoyanov.martin.task_manager.EntityNotFoundException;

import java.util.List;

@Service
public class TableService {
    
    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<Table> getTables() {
        return repository.findByOrderByTitleAsc();
    }

    public Table getTable(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id, Table.class));
    }

    public Table insertTable(Table table) {
        return repository.save(table);
    }

    public Table updateTable(Table table, Long id) {
        return repository.findById(id)
            .map(tableOrig -> {
                tableOrig.setTitle(tableOrig.getTitle());
                return repository.save(tableOrig);
            })
            .orElseGet (() -> repository.save(table));
    }

    public void deleteTable(Long id) {
        repository.deleteById(id);
    }

}
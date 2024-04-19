package ch.stoyanov.martin.task_manager.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Table {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String title;
    
    @Column(nullable = false)
    private Number taskLimit;

    public Table() {
    }

    public Table(Long id, String title, Number taskLimit) {
        this.id = id;
        this.title = title;
        this.taskLimit = taskLimit;
    }

}
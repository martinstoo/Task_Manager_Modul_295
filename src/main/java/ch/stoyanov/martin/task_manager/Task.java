package ch.stoyanov.martin.task_manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String title;
    
    @Column(nullable = false)
    private String assignee;
    
    @Column(nullable = false)
    private String assignedBy;
    
    private String description;
    



    public Task() {
    }

    public Task(String title, String assignee, String assignedBy, String description) {
        this.title = title;
        this.assignee = assignee;
        this.assignedBy = assignedBy;
        this.description = description;
    }
}

package ch.stoyanov.martin.task_manager.tasks;

import ch.stoyanov.martin.task_manager.people.People;
import ch.stoyanov.martin.task_manager.tabelle.Tabelle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long task_id;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String title;
    
    @Column(nullable = false)
    private String assignee;
    
    @Column(nullable = false)
    private String assignedBy;
    
    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "tabelle_id")
    private Tabelle tabelle;

    @ManyToOne
    private People assignedTo;

    public Task() {
    }

//    public Task(Long task_id, String title, String assignee, String assignedBy, String description, Tabelle tabelle, People assignedTo) {
//        this.task_id = task_id;
//        this.title = title;
//        this.assignee = assignee;
//        this.assignedBy = assignedBy;
//        this.description = description;
//        this.tabelle = tabelle;
//        this.assignedTo = assignedTo;
//    }
}

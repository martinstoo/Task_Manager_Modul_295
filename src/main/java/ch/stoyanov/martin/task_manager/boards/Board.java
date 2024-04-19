package ch.stoyanov.martin.task_manager.boards;

import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String title;
    
    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private List members;

    public Board() {
    }

    public Board(Long id, String title, String description, List members) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.members = members;
    }
}

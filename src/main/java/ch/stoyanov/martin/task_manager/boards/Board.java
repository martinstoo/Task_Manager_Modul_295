package ch.stoyanov.martin.task_manager.boards;


import ch.stoyanov.martin.task_manager.people.People;
import ch.stoyanov.martin.task_manager.tabelle.Tabelle;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long board_id;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String title;
    
    @Column(nullable = true)
    private String description;

    @OneToMany
    private List<People> people;

    public Board() {
    }

    public Board(Long board_id, String title, String description, List<People> people) {
        this.board_id = board_id;
        this.title = title;
        this.description = description;
        this.people = people;
    }
}

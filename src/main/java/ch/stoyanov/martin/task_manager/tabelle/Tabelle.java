package ch.stoyanov.martin.task_manager.tabelle;

import ch.stoyanov.martin.task_manager.boards.Board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Tabelle {

    @Id
    @GeneratedValue
    private Long tabelle_id;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String title;
    
    @Column(nullable = false)
    private Number taskLimit;

    @ManyToOne
    private Board board;

    public Tabelle() {
    }



}

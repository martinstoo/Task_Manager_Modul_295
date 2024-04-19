package ch.stoyanov.martin.task_manager.people;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class People {

    @Id
    @GeneratedValue
    private Long people_id;

    @Column(nullable = false)
    @Size(max = 255)
    private String username;

    @Column(nullable = false)
    @Size(max = 255)
    private String firstName;
    
    @Column(nullable = false)
    @Size(max = 255)
    private String lastName;

    @Column(nullable = false)
    private Number age;

    public People() {
    }

    public People(Long people_id, String username, String firstName, String lastName, Number age) {
        this.people_id = people_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}

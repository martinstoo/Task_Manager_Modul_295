package ch.stoyanov.martin.task_manager;

import lombok.Data;

@Data
public class TaskManager {
    private String  name;
    private String  lastname;
    private Number  age;

    public TaskManager(String name, String lastname, Number age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
}

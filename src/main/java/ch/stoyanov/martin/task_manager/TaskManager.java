package ch.stoyanov.martin.task_manager;

import lombok.Data;

@Data
public class TaskManager {

    private String  title;
    private Number  age;

    public TaskManager(String title, Number age) {
        this.title = title;
        this.age = age;
    }

}
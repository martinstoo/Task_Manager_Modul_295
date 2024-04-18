package ch.stoyanov.martin.task_manager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TaskManagerController {

    @GetMapping("/")
    public ResponseEntity <TaskManager> title(
            @RequestParam (value="title", defaultValue ="World")String title) {
        
        TaskManager taskmanager = new TaskManager(title, 17);
        return new ResponseEntity<>(taskmanager, HttpStatus.OK);
    }
    
}
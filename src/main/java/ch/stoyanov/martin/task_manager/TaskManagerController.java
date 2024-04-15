package ch.stoyanov.martin.task_manager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskManagerController {
    @GetMapping("/")
    public ResponseEntity <TaskManager> name(
            @RequestParam (value="name", defaultValue ="World")String name) {
        
                TaskManager hello = new TaskManager(name, "Stoyanov", 17);
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }       
}

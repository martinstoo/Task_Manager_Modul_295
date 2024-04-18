package ch.stoyanov.martin.task_manager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TaskManagerController {
    @GetMapping("/")
    public ResponseEntity <Task> name(
            @RequestParam (value="title", defaultValue ="World")String title) {
        
                Task hello = new Task("Test", "aed", "asd", "asddsa");
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }       
}

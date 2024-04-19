package ch.stoyanov.martin.task_manager.tasks;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ch.stoyanov.martin.task_manager.security.Roles;
import io.micrometer.common.lang.NonNull;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Validated

public class TaskController {

    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    
    @GetMapping("api/tasks")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Task>> all() {
        List<Task> result = taskService.getTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/tasks/{id}")
    public ResponseEntity<Task> one(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    
    @PostMapping("api/tasks")
    @RolesAllowed(Roles.Manager)
    public ResponseEntity<Task> newTask(@Valid @RequestBody @NonNull Task task) {
        Task savedTask = taskService.insertTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @PutMapping("api/tasks/{id}")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody @NonNull Task task, @PathVariable @NonNull Long id) {
        Task savedTask = taskService.updateTask(task, id);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @DeleteMapping("api/tasks/{id}")
    public void deleteTask(@PathVariable @NonNull Long id) {
        taskService.deleteTask(id);
    }

}

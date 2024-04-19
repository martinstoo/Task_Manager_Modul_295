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

    @GetMapping("api/tasks/{task_id}")
    public ResponseEntity<Task> one(@PathVariable Long task_id) {
        Task task = taskService.getTask(task_id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("api/tasks")
    @RolesAllowed(Roles.Manager)
    public ResponseEntity<Task> newTask(@Valid @RequestBody @NonNull Task task) {
        Task savedTask = taskService.insertTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @PutMapping("api/tasks/{task_id}")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody @NonNull Task task, @PathVariable @NonNull Long task_id) {
        Task savedTask = taskService.updateTask(task, task_id);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @DeleteMapping("api/tasks/{task_id}")
    public void deleteTask(@PathVariable @NonNull Long task_id) {
        taskService.deleteTask(task_id);
    }
}

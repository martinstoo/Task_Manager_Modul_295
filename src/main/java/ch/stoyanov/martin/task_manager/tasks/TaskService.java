package ch.stoyanov.martin.task_manager.tasks;

import org.springframework.stereotype.Service;

import ch.stoyanov.martin.task_manager.EntityNotFoundException;

import java.util.List;

@Service
public class TaskService {
    
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getTasks() {
        return repository.findByOrderByTitleAsc();
    }

    public Task getTask(Long task_id) {
        return repository.findById(task_id)
        .orElseThrow(() -> new EntityNotFoundException(task_id, Task.class));
    }

    public Task insertTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Task task, Long task_id) {
        return repository.findById(task_id)
            .map(taskOrig -> {
                taskOrig.setTitle(taskOrig.getTitle());
                return repository.save(taskOrig);
            })
            .orElseGet (() -> repository.save(task));
    }

    public void deleteTask(Long task_id) {
        repository.deleteById(task_id);
    }

}
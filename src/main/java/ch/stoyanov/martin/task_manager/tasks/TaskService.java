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

    public Task getTask(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id, Task.class));
    }

    public Task insertTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Task task, Long id) {
        return repository.findById(id)
            .map(taskOrig -> {
                taskOrig.setTitle(taskOrig.getTitle());
                return repository.save(taskOrig);
            })
            .orElseGet (() -> repository.save(task));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}
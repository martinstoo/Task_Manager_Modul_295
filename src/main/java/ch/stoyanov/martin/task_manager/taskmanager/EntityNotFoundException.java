package ch.stoyanov.martin.task_manager.taskmanager;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class c) {
        super("Could not find " + c.getSimpleName() + " " + id);
    }
}
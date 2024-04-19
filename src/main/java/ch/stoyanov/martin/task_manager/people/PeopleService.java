package ch.stoyanov.martin.task_manager.people;

import org.springframework.stereotype.Service;

import ch.stoyanov.martin.task_manager.EntityNotFoundException;

import java.util.List;

@Service
public class PeopleService {
    
    private final PeopleRepository repository;

    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<People> getPeoples() {
        return repository.findByOrderByTitleAsc();
    }

    public People getPeople(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id, People.class));
    }

    public People insertPeople(People people) {
        return repository.save(people);
    }

    public People updatePeople(People people, Long id) {
        return repository.findById(id)
            .map(peopleOrig -> {
                peopleOrig.setUsername(peopleOrig.getUsername());
                return repository.save(peopleOrig);
            })
            .orElseGet (() -> repository.save(people));
    }

    public void deletePeople(Long id) {
        repository.deleteById(id);
    }

}
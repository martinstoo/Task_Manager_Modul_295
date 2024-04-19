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
        return repository.findByOrderByUsernameAsc();
    }

    public People getPeople(Long people_id) {
        return repository.findById(people_id)
        .orElseThrow(() -> new EntityNotFoundException(people_id, People.class));
    }

    public People insertPeople(People people) {
        return repository.save(people);
    }

    public People updatePeople(People people, Long people_id) {
        return repository.findById(people_id)
            .map(peopleOrig -> {
                peopleOrig.setUsername(peopleOrig.getUsername());
                return repository.save(peopleOrig);
            })
            .orElseGet (() -> repository.save(people));
    }

    public void deletePeople(Long people_id) {
        repository.deleteById(people_id);
    }

}
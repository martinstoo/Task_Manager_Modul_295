package ch.stoyanov.martin.task_manager.people;

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

public class PeopleController {

    private final PeopleService peopleService;

    PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    
    @GetMapping("api/people")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<People>> all() {
        List<People> result = peopleService.getPeoples();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/people/{people_id}")
    public ResponseEntity<People> one(@PathVariable Long people_id) {
        People people = peopleService.getPeople(people_id);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
    
    @PostMapping("api/people")
    @RolesAllowed(Roles.Manager)
    public ResponseEntity<People> newPeople(@Valid @RequestBody @NonNull People people) {
        People savedPeople = peopleService.insertPeople(people);
        return new ResponseEntity<>(savedPeople, HttpStatus.OK);
    }

    @PutMapping("api/people/{people_id}")
    public ResponseEntity<People> updatePeople(@Valid @RequestBody @NonNull People people, @PathVariable @NonNull Long people_id) {
        People savedPeople = peopleService.updatePeople(people, people_id);
        return new ResponseEntity<>(savedPeople, HttpStatus.OK);
    }

    @DeleteMapping("api/people/{people_id}")
    public void deletePeople(@PathVariable @NonNull Long people_id) {
        peopleService.deletePeople(people_id);
    }

}

package ch.stoyanov.martin.task_manager.tables;

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

public class TableController {

    private final TableService tableService;

    TableController(TableService tableService) {
        this.tableService = tableService;
    }

    
    @GetMapping("api/tables")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Table>> all() {
        List<Table> result = tableService.getTables();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/tables/{id}")
    public ResponseEntity<Table> one(@PathVariable Long id) {
        Table table = tableService.getTable(id);
        return new ResponseEntity<>(table, HttpStatus.OK);
    }
    
    @PostMapping("api/tables")
    @RolesAllowed(Roles.Manager)
    public ResponseEntity<Table> newTable(@Valid @RequestBody @NonNull Table table) {
        Table savedTable = tableService.insertTable(table);
        return new ResponseEntity<>(savedTable, HttpStatus.OK);
    }

    @PutMapping("api/tables/{id}")
    public ResponseEntity<Table> updateTable(@Valid @RequestBody @NonNull Table table, @PathVariable @NonNull Long id) {
        Table savedTable = tableService.updateTable(table, id);
        return new ResponseEntity<>(savedTable, HttpStatus.OK);
    }

    @DeleteMapping("api/tables/{id}")
    public void deleteTable(@PathVariable @NonNull Long id) {
        tableService.deleteTable(id);
    }

}

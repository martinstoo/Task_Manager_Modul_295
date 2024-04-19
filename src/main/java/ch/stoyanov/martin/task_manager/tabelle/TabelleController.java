package ch.stoyanov.martin.task_manager.tabelle;

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

public class TabelleController {

    private final TabelleService tabelleService;

    TabelleController(TabelleService tabelleService) {
        this.tabelleService = tabelleService;
    }

    
    @GetMapping("api/tabelles")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Tabelle>> all() {
        List<Tabelle> result = tabelleService.getTabelles();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/tabelles/{tabelle_id}")
    public ResponseEntity<Tabelle> one(@PathVariable Long tabelle_id) {
        Tabelle tabelle = tabelleService.getTabelle(tabelle_id);
        return new ResponseEntity<>(tabelle, HttpStatus.OK);
    }
    
    @PostMapping("api/tabelles")
    @RolesAllowed(Roles.Manager)
    public ResponseEntity<Tabelle> newTabelle(@Valid @RequestBody @NonNull Tabelle tabelle) {
        Tabelle savedTabelle = tabelleService.insertTabelle(tabelle);
        return new ResponseEntity<>(savedTabelle, HttpStatus.OK);
    }

    @PutMapping("api/tabelles/{tabelle_id}")
    public ResponseEntity<Tabelle> updateTabelle(@Valid @RequestBody @NonNull Tabelle tabelle, @PathVariable @NonNull Long tabelle_id) {
        Tabelle savedTabelle = tabelleService.updateTabelle(tabelle, tabelle_id);
        return new ResponseEntity<>(savedTabelle, HttpStatus.OK);
    }

    @DeleteMapping("api/tabelles/{tabelle_id}")
    public void deleteTabelle(@PathVariable @NonNull Long tabelle_id) {
        tabelleService.deleteTabelle(tabelle_id);
    }

}

package ch.stoyanov.martin.task_manager.tabelle;

import org.springframework.stereotype.Service;

import ch.stoyanov.martin.task_manager.EntityNotFoundException;

import java.util.List;

@Service
public class TabelleService {
    
    private final TabelleRepository repository;

    public TabelleService(TabelleRepository repository) {
        this.repository = repository;
    }

    public List<Tabelle> getTabelles() {
        return repository.findByOrderByTitleAsc();
    }

    public Tabelle getTabelle(Long tabelle_id) {
        return repository.findById(tabelle_id)
        .orElseThrow(() -> new EntityNotFoundException(tabelle_id, Tabelle.class));
    }

    public Tabelle insertTabelle(Tabelle tabelle) {
        return repository.save(tabelle);
    }

    public Tabelle updateTabelle(Tabelle tabelle, Long tabelle_id) {
        return repository.findById(tabelle_id)
            .map(tabelleOrig -> {
                tabelleOrig.setTitle(tabelleOrig.getTitle());
                return repository.save(tabelleOrig);
            })
            .orElseGet (() -> repository.save(tabelle));
    }

    public void deleteTabelle(Long tabelle_id) {
        repository.deleteById(tabelle_id);
    }

}
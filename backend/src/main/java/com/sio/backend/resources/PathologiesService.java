package com.sio.backend.resources;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PathologiesService {

    private final PathologiesRepository repo;
    private final PathologiesMapper mapper;

    public PathologiesService(PathologiesRepository repo, PathologiesMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    // Metodo per ottenere tutte le patologie
    @Transactional(readOnly = true)
    public List<PathologiesDTO> getAllPathologies() {
        log.debug("Recupero di tutte le patologie dal database");
        List<Pathologies> list = repo.findAll();
        List<PathologiesDTO> dtos = new ArrayList<>();

        for (Pathologies e : list){
            dtos.add(mapper.toDTO(e));
        }

        // return repo.findAll().stream().map(mapper::toDTO).toList();
        return dtos;
    }

    public Page<PathologiesDTO> getAllPathologiesPaginated(Pageable pageable) {
        Page<Pathologies> entityPage = repo.findAll(pageable);

        return entityPage.map(mapper::toDTO);
    }

    public PathologiesDTO getPathologiesById(String code) {
        Pathologies e = repo.findById(code).orElseThrow();
        return mapper.toDTO(e);
    }

    // Metodo per creare una nuova patologia

    /**
     * @param dto
     * @return
     */
    public PathologiesDTO createNewPathology(PathologiesDTO dto) {
        log.info("Creazione di una nuova entità pathology con codice: {}", dto.code()); // Log di informazione per indicare la creazione di una nuova entità pathology con il codice specificato
        log.debug("Entità in creazione con codice: {}, e descrizione {}", dto.code(), dto.description()); // Log di debug per fornire ulteriori dettagli sulla nuova entità in creazione, inclusi il codice e la descrizione

        // Controllo se il codice della patologia esiste già nel database. Se esiste, viene generata un'eccezione IllegalArgumentException con un messaggio appropriato.
        if(repo.existsById(dto.code())) {
            log.warn("Tentativo di creare una patologia con codice già esistente: {}", dto.code()); // Log di avviso per indicare che si sta tentando di creare una patologia con un codice già esistente
            throw new IllegalArgumentException("Patologia con codice: " + dto.code() + " già esistente");
        }

        Pathologies entity = mapper.toEntity(dto);
        entity = repo.save(entity);

        log.info("Entità pathology creata con successo con codice: {}", entity.getCode()); // Log di informazione per indicare che l'entità pathology è stata creata con successo con il codice specificato
        return mapper.toDTO(entity);
    }

    // Metodo per eliminare una patologia per il suo codice
    public void deletePathology(String code){
        repo.deleteById(code);
    }

    // Metodo per modificare una patologia esistente
    public PathologiesDTO editPathology(PathologiesDTO dto) {
        Pathologies e = repo.findById(dto.code())
                .orElseThrow(() -> new EntityNotFoundException("Patologia con codce: " + dto.code() + " non trovata"));

        e.setDescription(dto.description());

        Pathologies savedEntity = repo.save(e);

        return mapper.toDTO(savedEntity);
    }

}

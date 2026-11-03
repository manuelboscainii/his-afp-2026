package com.sio.backend.resources;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PathologiesService {

    // @Autowired
    private final PathologiesRepository repo;
    private final PathologiesMapper mapper;

    public PathologiesService(PathologiesRepository repo, PathologiesMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    // Method to retrieve all pathologies
    public List<PathologiesDTO> getAllPathologies() {
        List<Pathologies> list = repo.findAll();
        List<PathologiesDTO> dtos = new ArrayList<>();

        for (Pathologies e : list){
            dtos.add(mapper.toDTO(e));
        }

        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public PathologiesDTO getPathologiesById(String code) {
        Pathologies e = repo.findById(code).orElseThrow();
        return mapper.toDTO(e);
    }

    // Method to create a new pathology
    public PathologiesDTO createNewPathology(PathologiesDTO dto) {
        Pathologies entity = mapper.toEntity(dto);
        entity = repo.save(entity);

        return mapper.toDTO(entity);
    }

    // Method to delete a pathology by its code
    public void deletePathology(String code){
        repo.deleteById(code);
    }

    public void editPathology(PathologiesDTO dto) {
        Optional<Pathologies> entity = repo.findById(dto.code());

        if(entity.isEmpty()) throw new NoSuchElementException("Patologia cercata, non trovata");

        // if(entity.get().getCode().equals(dto.code())) throw new Exception("Codici id non corrispondenti");

        repo.deleteById(entity.get().getCode());

        repo.save(mapper.toEntity(dto));
    }

}

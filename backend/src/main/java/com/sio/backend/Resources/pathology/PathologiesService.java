package com.sio.backend.Resources.pathology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PathologiesService {
    @Autowired
    private PathologiesRepository repo;

    @Autowired
    private PathologiesMapper mapper;

    public List<PathologiesDTO> getAllPathologies() {
        List<Pathologies> list = repo.findAll();
        List<PathologiesDTO> dtos = new ArrayList<>();

        for (Pathologies e : list){
            dtos.add(mapper.toDTO(e));
        }

        return repo.findAll().stream().map(mapper::toDTO).toList();
    }
}

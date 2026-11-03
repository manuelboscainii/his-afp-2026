package com.sio.backend.resources;

import org.springframework.stereotype.Component;


@Component
public class PathologiesMapper {
    public PathologiesDTO toDTO(Pathologies entity) {
        if (entity == null) return null;

        return new PathologiesDTO(
                entity.getCode(),
                entity.getDescription()
        );
    }

    public Pathologies toEntity(PathologiesDTO dto) {
        if (dto == null) return null;

        Pathologies entity = new Pathologies();
        entity.setCode(dto.code());
        entity.setDescription(dto.description());

        return entity;
    }

}

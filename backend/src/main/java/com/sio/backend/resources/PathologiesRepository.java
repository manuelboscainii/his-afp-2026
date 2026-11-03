package com.sio.backend.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathologiesRepository extends JpaRepository<Pathologies, String> {

}
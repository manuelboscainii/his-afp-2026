package com.sio.backend.Resources.pathology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PathologiesRepository extends JpaRepository<Pathologies, Long> {

}
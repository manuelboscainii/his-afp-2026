package com.sio.backend.patients;

import org.springframework.stereotype.Component;

@Component
class PatientMapper {
    public PatientDTO toDTO(Patient pt) {
        return new PatientDTO(
                pt.getCodiceFiscale(),
                pt.getNome(),
                pt.getCognome(),
                pt.getDataNascita(),
                pt.getSex(),
                pt.getIndirizzoVia(),
                pt.getIndirizzoCivico(),
                pt.getComune(),
                pt.getProvincia()
        );
    }

    public Patient toEntity(PatientDTO dto) {
        if (dto == null) return null;

        Patient pt = new Patient();
        pt.setCodiceFiscale(dto.codiceFiscale());
        pt.setNome(dto.name());
        pt.setCognome(dto.cognome());
        pt.setDataNascita(dto.dataNascita());
        pt.setSex(dto.sex());
        pt.setIndirizzoVia(dto.indirizzoVia());
        pt.setIndirizzoCivico(dto.indirizzoCivico());
        pt.setComune(dto.comune());
        pt.setProvincia(dto.provincia());

        return pt;
    }
}

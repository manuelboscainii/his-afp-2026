package com.sio.backend.patients;

import com.sio.backend.generics.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/{cf}")
    public ApiResponse<PatientDTO> getPatientByCF(@PathVariable("cf") String cf) {
        return ApiResponse.success(service.getPatientByCodiceFiscale(cf));
    }

    @GetMapping("/search")
    public ApiResponse<List<PatientDTO>> getPatientByNominativo(
            @RequestParam String nome,
            @RequestParam String cognome,
            @RequestParam String dataNascita,
            @RequestParam String sex
    ) {
        return ApiResponse.success(
                service.getPatientByNominativo(
                        nome,
                        cognome,
                        LocalDate.parse(dataNascita),
                        PatientSex.valueOf(sex.toUpperCase())
                ));
    }

}

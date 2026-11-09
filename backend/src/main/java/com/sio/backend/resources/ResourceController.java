package com.sio.backend.resources;

import com.sio.backend.generics.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
@Tag(name = "Gestione risorse SIO", description = "Endpoint per la gestione delle risorse SIO")
public class ResourceController {

    // Inject the PathologiesService to handle business logic
    @Autowired
    private PathologiesService pathologiesService;

    /*
    // Endpoint to retrieve all pathologies
    @GetMapping("/pathologies")
    public List<PathologiesDTO> getPathologies() {
        return pathologiesService.getAllPathologies();
    }
     */

    @Operation(summary = "Recupera tutte le patologie", description = "Restituisce una lista di tutte le patologie disponibili")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Elenco delle patologie recuperato con successo"
            )
    })
    @GetMapping("/pathologies")
    public ApiResponse<List<PathologiesDTO>> getAllPathologies(){
        return ApiResponse.success(
                pathologiesService.getAllPathologies()
        );
    }

    @Operation(
            summary = "Recupera una patologia per codice",
            description = "Restituisce i dettagli di una patologia specifica in base al codice fornito"
    )
    @GetMapping("/pathologies/{code}")
    public ApiResponse<PathologiesDTO> getPathologiesByCode(
            @Parameter(description = "Codice identificativo della patologia")
            @Valid
            @PathVariable String code
    )
    {
        PathologiesDTO dto = pathologiesService.getPathologiesById(code);
        return ApiResponse.success(dto);
    }

    // Endpoint to create a new pathology
    @PostMapping("/pathologies")
    public PathologiesDTO createPathology(@RequestBody PathologiesDTO dto) {
        return pathologiesService.createNewPathology(dto);
    }

    // Endpoint to delete a pathology by its code
    @DeleteMapping("/pathologies")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> deletePathology(@RequestParam String code) {
        pathologiesService.deletePathology(code);

        return ApiResponse.success((Void) null);
    }

    @PutMapping("/pathologies")
    public ApiResponse<PathologiesDTO> editPathology(@RequestBody PathologiesDTO dto) {
        PathologiesDTO newDto = pathologiesService.editPathology(dto);
        return ApiResponse.success(newDto);
    }

    @GetMapping("/sim-error")
    public ApiResponse<PathologiesDTO> getSimError() throws Exception {
        throw new Exception("Eccezione dinamica lanciata");
        // throw new IllegalArgumentException("Dati non validi");
        // return ApiResponse.error("Messaggio di errore simulato", 500);
    }

}

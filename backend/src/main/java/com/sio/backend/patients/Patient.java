package com.sio.backend.patients;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {

    @ColumnDefault("'M'")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) // Usa il tipo ENUM per la colonna "sex", che memorizza i valori come stringhe (M o F) nel database
    @Column(name = "sex", columnDefinition = "patient_sex not null")
    private PatientSex sex;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Size(max = 5)
    @Column(name = "provincia", length = 5)
    private String provincia;

    @Size(max = 100)
    @Column(name = "comune", length = 100)
    private String comune;

    @Size(max = 20)
    @Column(name = "indirizzo_civico", length = 20)
    private String indirizzoCivico;

    @Size(max = 255)
    @Column(name = "indirizzo_via")
    private String indirizzoVia;
    @NotNull
    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @Size(max = 100)
    @NotNull
    @Column(name = "cognome", nullable = false, length = 100)
    private String cognome;

    @Size(max = 100)
    @NotNull
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Size(max = 16)
    @NotNull
    @Column(name = "codice_fiscale", nullable = false, length = 16)
    private String codiceFiscale;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @PrePersist
    protected void onCreate(){
        if(this.createdAt == null){
            this.createdAt = Instant.now();
        }
        if(this.sex==null){
            this.sex = PatientSex.M;
        }
    }

}

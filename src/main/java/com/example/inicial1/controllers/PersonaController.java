package com.example.inicial1.controllers;

import com.example.inicial1.services.PersonaServiceImpl;
import com.example.inicial1.entities.Persona;
import lombok.Getter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas") //ruta de acceso al recurso
@CrossOrigin(origins = "*")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{ \"error \":\"" + e.getMessage() + " \"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{ \"error \":\"" + e.getMessage() + " \"}"));
        }
    }
}
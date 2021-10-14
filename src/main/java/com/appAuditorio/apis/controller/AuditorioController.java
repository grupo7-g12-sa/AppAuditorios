/*
 * Creación de API /Audience/ con peticiones GET, POST, PUT y DELETE.
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Auditorio;
import com.appAuditorio.apis.service.AuditorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author J. Sebastián Beltrán
 */
@RestController
@RequestMapping("/api/Audience")
public class AuditorioController {
    /**
     * Instancia de AuditorioService.
     */
    @Autowired
    private AuditorioService servicioAud;
    
    /**
     * Petición GET para API Audience.
     * @return lista de auditorios encontrados.
     */
    @GetMapping("/all")
    public List<Auditorio> getAllAuditorios(){
        return servicioAud.getAllAuditorios();
    }
    
    /**
     * Petición POST para API Audience.
     * @param auditorio el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveAuditorio(@RequestBody Auditorio auditorio){
        servicioAud.saveAuditorio(auditorio);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Audience.
     * @param auditorio el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateAuditorio(@RequestBody Auditorio auditorio){
        servicioAud.updateAuditorio(auditorio);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Audience.
     * @param auditorio objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204)
     */
    @DeleteMapping("/delete")
    public ResponseEntity deleteAuditorio(@RequestBody Auditorio auditorio){
        servicioAud.deleteAuditorio(auditorio.getId());
        
        return ResponseEntity.status(204).build();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Audience;
import com.appAuditorio.apis.service.AudienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author REIDEH
 */
@RestController
@RequestMapping("/api/Audience")
public class AudienceController {
     /**
     * Instancia de AuditorioService.
     */
    @Autowired
    private AudienceService servicioAud;
    
   
    /**
     * Petición GET para API Audience.
     * @return lista de auditorios encontrados.
     */
    @GetMapping("/all")
    public List<Audience> getAllAuditorios(){
        return servicioAud.getAllAuditorios();
    }
    
    /**
     * Petición POST para API Audience.
     * @param auditorio el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveAuditorio(@RequestBody Audience auditorio){
        servicioAud.saveAuditorio(auditorio);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Audience.
     * @param auditorio el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateAuditorio(@RequestBody Audience auditorio){
        servicioAud.updateAuditorio(auditorio);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Audience.
     * @param auditorio objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204)
     */
    /*@DeleteMapping("/delete")
    public ResponseEntity deleteAuditorio(@RequestBody Audience auditorio){
        servicioAud.deleteAuditorio(auditorio.getId());
        
        return ResponseEntity.status(204).build();
    }*/
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") int id){
        servicioAud.deleteAuditorio(id);
        
        return ResponseEntity.status(204).build();
    }
}
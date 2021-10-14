/*
 * Creación de API /Score/ con peticiones GET, POST, PUT y DELETE.
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Calificacion;
import com.appAuditorio.apis.service.CalificacionService;
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
@RequestMapping("/api/Score")
public class CalificacionController {
    /**
     * Instancear el servicio de Calificacion.
     */
    @Autowired
    private CalificacionService servicioCalif;
    
    /**
     * Petición GET para API Score.
     * @return lista de calificaciones encontradas.
     */
    @GetMapping("/all")
    public List<Calificacion> getAllCalificaciones(){
        return servicioCalif.getAllCalificaciones();
    }
    
    /**
     * Petición POST para API Score.
     * @param calificacion el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveCalificacion(@RequestBody Calificacion calificacion){
        servicioCalif.saveCalificacion(calificacion);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Score.
     * @param calificacion el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateCalificacion(@RequestBody Calificacion calificacion){
        servicioCalif.updateCalificacion(calificacion);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Score.
     * @param calificacion objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204)
     */
    @DeleteMapping("/delete")
    public ResponseEntity deleteCalificacion(@RequestBody Calificacion calificacion){
        servicioCalif.deleteCalificacion(calificacion.getId());
        
        return ResponseEntity.status(204).build();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Mensaje;
import com.appAuditorio.apis.service.MensajeService;
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
 * @author HEDIER ALVAREZ GRUPO 12
 */

@RestController
@RequestMapping("/api/Message")

public class MensajeController {
    
    /**
     * Instancear el servicio de Category.
     */
    @Autowired
    private MensajeService servicioMensaje;
    
    /**
     * Petición GET para API Category.
     * @return lista de administradores encontrados.
     */
    @GetMapping("/all")
    public List <Mensaje> getAllMensaje(){
        return servicioMensaje.getAllMensaje();
    }
    
     /**
     * Petición POST para API Mensaje.
     * @param mensaje el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveMensaje(@RequestBody Mensaje mensaje){
        servicioMensaje.saveMensaje(mensaje);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Mensaje.
     * @param mensaje el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateMensaje(@RequestBody Mensaje mensaje){
        servicioMensaje.updateMensaje(mensaje);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Mensaje.
     * @param mensaje el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMensaje(@PathVariable("id") int id){
        servicioMensaje.deleteMensaje(id);
        
        return ResponseEntity.status(204).build();
    }
}

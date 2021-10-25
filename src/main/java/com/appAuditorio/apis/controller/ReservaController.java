/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Reserva;
import com.appAuditorio.apis.service.ReservaService;
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
 * @author Hedier Alvarez Ovalle Grupo 12
 */
@RestController
@RequestMapping("/api/Reservation")
public class ReservaController {
    
    /**
     * Instancear el servicio de Category.
     */
    @Autowired
    private ReservaService servicioReserva;
    
     /**
     * Petición GET para API Category.
     * @return lista de administradores encontrados.
     */
    @GetMapping("/all")
    public List <Reserva> getAllReserva(){
        return servicioReserva.getAllReserva();
    }
    
     /**
     * Petición POST para API Reserva.
     * @param reserva el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveReserva(@RequestBody Reserva reserva){
        servicioReserva.saveReserva(reserva);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Reserva.
     * @param reserva el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateReserva(@RequestBody Reserva reserva){
        servicioReserva.updateReserva(reserva);
        
        return ResponseEntity.status(201).build();
    }
    
     /**
     * Petición DELETE para API Category.
     * @param category el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") int id){
        servicioReserva.deleteReserva(id);
        
        return ResponseEntity.status(204).build();
    }
    
    
    
}

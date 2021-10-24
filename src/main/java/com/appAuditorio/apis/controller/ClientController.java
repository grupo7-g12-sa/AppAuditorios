/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Client;
import com.appAuditorio.apis.service.ClientService;
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
 * @author Hedier Alvarez Grupo 12
 */

@RestController
@RequestMapping("/api/Client")
public class ClientController {
    /**
     * Instancear el servicio de Client.
     */
    @Autowired
    private ClientService servicioClient;
    
    /**
     * Petición GET para API Admin.
     * @return lista de administradores encontrados.
     */
    @GetMapping("/all")
    public List <Client> getAllClient(){
        return servicioClient.getAllClient();
    }
    
    /**
     * Petición POST para API Client.
     * @param client el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody Client client){
        servicioClient.saveClient(client);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Client.
     * @param client el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client){
        servicioClient.updateClient(client);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Client.
     * @param client el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") int id){
        servicioClient.deleteClient(id);
        
        return ResponseEntity.status(204).build();
    }
    
    
}

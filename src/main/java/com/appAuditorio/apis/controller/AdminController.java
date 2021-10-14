/*
 * Creación de API /Admin/ con peticiones GET, POST, PUT y DELETE.
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Admin;
import com.appAuditorio.apis.service.AdminService;
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
@RequestMapping("/api/Admin")
public class AdminController {
    /**
     * Instancear el servicio de Admin.
     */
    @Autowired
    private AdminService servicioAdmin;
    
    /**
     * Petición GET para API Admin.
     * @return lista de administradores encontrados.
     */
    @GetMapping("/all")
    public List <Admin> getAllAdmins(){
        return servicioAdmin.getAllAdmins();
    }
    
    /**
     * Petición POST para API Admin.
     * @param admin el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveAdmin(@RequestBody Admin admin){
        servicioAdmin.saveAdmin(admin);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Admin.
     * @param admin el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin){
        servicioAdmin.updateAdmin(admin);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Admin.
     * @param admin el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/delete")
    public ResponseEntity deleteAdmin(@RequestBody Admin admin){
        servicioAdmin.deleteAdmin(admin.getId());
        
        return ResponseEntity.status(204).build();
    }
}

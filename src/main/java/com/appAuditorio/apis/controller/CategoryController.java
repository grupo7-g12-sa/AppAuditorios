/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.controller;

import com.appAuditorio.apis.entity.Category;
import com.appAuditorio.apis.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hedier Alvarez Grupo 12
 */

@RestController
@RequestMapping("/api/Category")

public class CategoryController {
    
    /**
     * Instancear el servicio de Category.
     */
    @Autowired
    private CategoryService servicioCategory;
    
    /**
     * Petición GET para API Category.
     * @return lista de administradores encontrados.
     */
    @GetMapping("/all")
    public List <Category> getAllCategory(){
        return servicioCategory.getAllCategory();
    }
    
    /**
     * Petición POST para API Category.
     * @param category el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody Category category){
        servicioCategory.saveCategory(category);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Category.
     * @param category el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        servicioCategory.updateCategory(category);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Category.
     * @param category el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") int id){
        servicioCategory.deleteCategory(id);
        
        return ResponseEntity.status(204).build();
    }
   /* @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int categoriaId) {
        return ResponseEntity.deleteCategory(categoriaId);
    }*/
    
}

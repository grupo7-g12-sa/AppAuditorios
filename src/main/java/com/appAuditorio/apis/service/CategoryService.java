/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.service;


import com.appAuditorio.apis.entity.Category;
import com.appAuditorio.apis.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author REIDEH
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repositorioCategory;
    
    /**
     * Devuelve una lista con los registros de la tabla Categoy.
     * @return la lista con los objetos Admin de la tabla Categoy.
     */
    public List<Category> getAllCategory(){
        return repositorioCategory.findAll();
    }
    
     /**
     * Crea una nueva categoria en la tabla Category.
     * @param category el category que se creará.
     * @return el objeto Category creado.
     */
    public Category saveCategory(Category category){
        return repositorioCategory.save(category);
    }
    
    /**
     * Actualiza la información de una Categoria  de la tabla Category.
     * @param category el administrador con los nuevos valores.
     * @return el objeto Admin modificado.
     */
    public Category updateCategory(Category category){
        /**
         * Intenta recuperar la categoria usando el id y la guarda en
         * categoryMod; si no la encuenta, guarda el valor null.
         */
        Category categoryMod = repositorioCategory.findById(category.getId()).orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        categoryMod.setName(category.getName());
        categoryMod.setDescription(category.getDescription());
        
        /**
         * Guardar los cambios en la tabla.
         */
        repositorioCategory.save(categoryMod);
        
        return categoryMod;
    }
    
    /**
     * Elimina un administrador de la tabla Administrador.
     * @param id el id del administrador que se borrará.
     * @return un aviso de eliminado con el Id del administrador eliminado.
     */
    public String deleteCategory(int id){
        repositorioCategory.deleteById(id);
        
        return "Administrador eliminado. Id: " + id;
    }
    
    
    
}

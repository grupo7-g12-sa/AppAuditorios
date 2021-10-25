/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.service;

import com.appAuditorio.apis.entity.Audience;
import com.appAuditorio.apis.repository.AudienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author REIDEH
 */
@Service
public class AudienceService {
    
    @Autowired
    private AudienceRepository repositorioAudience;
    
    /**
     * Devuelve una lista con los registros de la tabla auditorio.
     * @return la lista con los objetos Auditorio de la tabla auditorio.
     */
    public List<Audience> getAllAuditorios(){
        return repositorioAudience.findAll();
    }
    
    /**
     * Crea un nuevo auditorio en la tabla auditorio.
     * @param auditorio el auditorio que se creará.
     * @return un objeto Auditorio
     */
    public Audience saveAuditorio(Audience auditorio){
        return repositorioAudience.save(auditorio);
    }
    
    /**
     * Actualiza la información de un auditorio de la tabla auditorio.
     * @param auditorio el auditorio con los nuevos valores.
     * @return el objeto Auditorio modificado.
     */
    public Audience updateAuditorio(Audience auditorio){
        /**
         * Intenta recuperar el auditorio usando el id y lo guarda en
         * auditorioMod; si no lo encuenta, guarda el valor null.
         */
        Audience auditorioMod = repositorioAudience.findById(auditorio.getId())
                                                  .orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        auditorioMod.setOwner(auditorio.getOwner());
        auditorioMod.setName(auditorio.getName());
        auditorioMod.setCapacity(auditorio.getCapacity());
        auditorioMod.setDescription(auditorio.getDescription());
        auditorioMod.setCategory(auditorio.getCategory()); //sin relaciones en categoria
        
        /**
         * Guardar los cambios en la tabla auditorio.
         */
        repositorioAudience.save(auditorioMod);
        
        return auditorioMod;
    }
    
    /**
     * Elimina un auditorio de la tabla auditorio.
     * @param id el id del auditorio que se borrará.
     * @return un aviso de eliminado con el Id del auditorio eliminado.
     */
    public String deleteAuditorio(int id){
        repositorioAudience.deleteById(id);        
        return "Auditorio eliminado. Id: " + id;
    }
}


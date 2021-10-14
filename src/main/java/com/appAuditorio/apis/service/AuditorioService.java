/*
 * Creación de servicio para la ejecución de operaciones CRUD en tabla auditorio.
 */
package com.appAuditorio.apis.service;

import com.appAuditorio.apis.entity.Auditorio;
import com.appAuditorio.apis.repository.AuditorioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class AuditorioService {
    @Autowired
    private AuditorioRepository repositorioAud;
    
    /**
     * Devuelve una lista con los registros de la tabla auditorio.
     * @return la lista con los objetos Auditorio de la tabla auditorio.
     */
    public List<Auditorio> getAllAuditorios(){
        return repositorioAud.findAll();
    }
    
    /**
     * Crea un nuevo auditorio en la tabla auditorio.
     * @param auditorio el auditorio que se creará.
     * @return un objeto Auditorio
     */
    public Auditorio saveAuditorio(Auditorio auditorio){
        return repositorioAud.save(auditorio);
    }
    
    /**
     * Actualiza la información de un auditorio de la tabla auditorio.
     * @param auditorio el auditorio con los nuevos valores.
     * @return el objeto Auditorio modificado.
     */
    public Auditorio updateAuditorio(Auditorio auditorio){
        /**
         * Intenta recuperar el auditorio usando el id y lo guarda en
         * auditorioMod; si no lo encuenta, guarda el valor null.
         */
        Auditorio auditorioMod = repositorioAud.findById(auditorio.getId())
                                                  .orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        auditorioMod.setOwner(auditorio.getOwner());
        auditorioMod.setName(auditorio.getName());
        auditorioMod.setCapacity(auditorio.getCapacity());
        auditorioMod.setDescription(auditorio.getDescription());
        auditorioMod.setCategory(auditorio.getCategory());
        
        /**
         * Guardar los cambios en la tabla auditorio.
         */
        repositorioAud.save(auditorioMod);
        
        return auditorioMod;
    }
    
    /**
     * Elimina un auditorio de la tabla auditorio.
     * @param id el id del auditorio que se borrará.
     * @return un aviso de eliminado con el Id del auditorio eliminado.
     */
    public String deleteAuditorio(int id){
        repositorioAud.deleteById(id);
        
        return "Auditorio eliminado. Id: " + id;
    }
}

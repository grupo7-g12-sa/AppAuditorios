/*
 * Creación de servicio para la ejecución de operaciones CRUD en tabla
 * Calificacion.
 */
package com.appAuditorio.apis.service;

import com.appAuditorio.apis.entity.Calificacion;
import com.appAuditorio.apis.repository.CalificacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository repositorioCalif;
    
    /**
     * Devuelve una lista con los registros de la tabla Calificacion.
     * @return la lista con los objetos Calificacion de la tabla Calificacion.
     */
    public List<Calificacion> getAllCalificaciones(){
        return repositorioCalif.findAll();
    }
    
    /**
     * Crea una nueva calificación en la tabla Calificacion.
     * @param calificacion la calificación que se creará.
     * @return el objeto Calificacion creado.
     */
    public Calificacion saveCalificacion(Calificacion calificacion){
        return repositorioCalif.save(calificacion);
    }
    
    /**
     * Actualiza la información de una calificación de la tabla Calificacion.
     * @param calificacion la calificación con los nuevos valores.
     * @return el objeto Calificacion modificado.
     */
    public Calificacion updateCalificacion(Calificacion calificacion){
        /**
         * Intenta recuperar la calificacion usando el id y la guarda en
         * califMod; si no la encuenta, guarda el valor null.
         */
        Calificacion califMod = repositorioCalif.findById(calificacion.getId())
                                                .orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        califMod.setScore(calificacion.getScore());
        califMod.setMessage(calificacion.getMessage());
        //califMod.setReservation(calificacion.getReservation());
        /**
         * Guardar los cambios en la tabla.
         */
        repositorioCalif.save(califMod);
        
        return califMod;
    }
    
    /**
     * Elimina una calificación de la tabla Calificacion.
     * @param id el id de la calificación que se borrará.
     * @return un aviso de eliminado con el Id de la calificación eliminada.
     */
    public String deleteCalificacion(int id){
        repositorioCalif.deleteById(id);
        return "Calificación eliminada. Id: " + id;
    }
}

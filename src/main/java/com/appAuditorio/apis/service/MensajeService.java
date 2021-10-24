/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.service;

import com.appAuditorio.apis.entity.Mensaje;
import com.appAuditorio.apis.repository.MensajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hedier Alvarez ovalle
 */
@Service
public class MensajeService {
    @Autowired
    private MensajeRepository repositorioMensaje;
    
    /**
     * Devuelve una lista con los registros de la tabla Mensaje.
     * @return la lista con los objetos Admin de la tabla Mensaje.
     */
    public List<Mensaje> getAllMensaje(){
        return repositorioMensaje.findAll();
    }
    
    /**
     * Crea una nueva categoria en la tabla Category.
     * @param category el category que se creará.
     * @return el objeto Category creado.
     */
    public Mensaje saveMensaje(Mensaje mensaje){
        return repositorioMensaje.save(mensaje);
    }
    
     /**
     * Actualiza la información de un Mensaje  de la tabla Mensaje.
     * @param meensaje el administrador con los nuevos valores.
     * @return el objeto mesnaje modificado.
     */
    public Mensaje updateMensaje(Mensaje mensaje){
        /**
         * Intenta recuperar el mensaje  usando el id y la guarda en
         * emsanejeMod; si no la encuenta, guarda el valor null.
         */
        Mensaje mensajeMod = repositorioMensaje.findById(mensaje.getIdMessage()).orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        mensajeMod.setMessageText(mensaje.getMessageText());
        
        
        /**
         * Guardar los cambios en la tabla.
         */
        repositorioMensaje.save(mensajeMod);
        
        return mensajeMod;
    }
    
    /**
     * Elimina un Mensaje de la tabla Mensajes.
     * @param id el id del mensaje que se borrará.
     * @return un aviso de eliminado con el Id del mensaje eliminado.
     */
    public String deleteMensaje(int id){
        repositorioMensaje.deleteById(id);        
        return "Mensaje eliminado. Id: " + id;
    }
}

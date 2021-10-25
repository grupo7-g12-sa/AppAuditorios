/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.service;


import com.appAuditorio.apis.entity.Reserva;
import com.appAuditorio.apis.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hedier Alvarez Grupo 12
 */
@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repositoryReserva;
    
    /**
     * Devuelve una lista con los registros de la tabla Reserva.
     * @return la lista con los objetos Reserva de la tabla Reserva.
     */
    public List<Reserva> getAllReserva(){
        return repositoryReserva.findAll();
    }
    
    /**
     * Crea una nueva Reserva en la tabla Reserva.
     * @param reserva  que se creará.
     * @return el objeto Reserva creado.
     */
    public Reserva saveReserva(Reserva reserva){
        return repositoryReserva.save(reserva);
    }
    
      /**
     * Actualiza la información de una Reserva  de la tabla Reserva.
     * @param reserva el administrador con los nuevos valores.
     * @return el objeto reserva modificado.
     */
    public Reserva updateReserva(Reserva reserva){
        /**
         * Intenta recuperar la categoria usando el id y la guarda en
         * categoryMod; si no la encuenta, guarda el valor null.
         */
        Reserva reservaMod = repositoryReserva.findById(reserva.getIdReservation()).orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        reservaMod.setStartDate(reserva.getStartDate());
        reservaMod.setDevolutionDate(reserva.getDevolutionDate());
        reservaMod.setStatus(reserva.getStatus());       
        
        /**
         * Guardar los cambios en la tabla.
         */
        repositoryReserva.save(reservaMod);
        
        return reservaMod;
    }
    
    /**
     * Elimina una reserva de la tabla Reserva.
     * @param id el id de la reserva que se borrará.
     * @return un aviso de eliminado con el Id de la reserva eliminado.
     */
    public String deleteReserva(int id){
        repositoryReserva.deleteById(id);        
        return "Administrador eliminado. Id: " + id;
    }
    
}

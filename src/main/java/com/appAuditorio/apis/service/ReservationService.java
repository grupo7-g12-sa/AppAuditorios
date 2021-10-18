package com.appAuditorio.apis.service;


import com.appAuditorio.apis.entity.Reservation;
import com.appAuditorio.apis.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilson Velasco
 */

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }
    
    public Reservation getReservationById(int id){
        return reservationRepository.findById(id).orElse(null);
    }
    
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    
    public Reservation updateReservation(Reservation reservation){
        
        //Reservation reservationMod = reservationRepository.findById(reservation.getId_reserva())
        //                                                  .orElse(null);
        Reservation reservationMod = getReservationById(reservation.getIdReservation());
        
        reservationMod.setStartDate(reservation.getStartDate());
        reservationMod.setDevolutionDate(reservation.getDevolutionDate());
        reservationMod.setClient(reservation.getClient());
        reservationMod.setAudience(reservation.getAudience());
        
        return reservationRepository.save(reservationMod);
        
    }
    
    /**
     * Elimina un auditorio de la tabla auditorio.
     * @param id el id del auditorio que se borrará.
     */
    public void deleteReservation(int id){
        reservationRepository.deleteById(id);
        
    }
    
}

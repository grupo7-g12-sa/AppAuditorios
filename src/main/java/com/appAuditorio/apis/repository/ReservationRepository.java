package com.appAuditorio.apis.repository;

/**
 *
 * @author Wilson Velasco
 */
import com.appAuditorio.apis.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Wilson Velasco
 */

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
}

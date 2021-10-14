/*
 * Creación de repositorio para la tabla Calificacion.
 */

package com.appAuditorio.apis.repository;

import com.appAuditorio.apis.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán
 */
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{
    
}

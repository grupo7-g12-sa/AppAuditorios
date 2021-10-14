/*
 * Creación de repositorio para la tabla Auditorio.
 */
package com.appAuditorio.apis.repository;

import com.appAuditorio.apis.entity.Auditorio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán
 */
public interface AuditorioRepository extends JpaRepository <Auditorio, Integer> {
    
}

/*
 * Creación de repositorio para la tabla Admin.
 */
package com.appAuditorio.apis.repository;

import com.appAuditorio.apis.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán S
 */
public interface AdminRepository extends JpaRepository <Admin, Integer> {
    
}

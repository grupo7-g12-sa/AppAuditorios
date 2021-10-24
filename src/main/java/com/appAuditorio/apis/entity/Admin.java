/*
 * Creación de entidad "Admin" y de tabla "Administrador"
 */
package com.appAuditorio.apis.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="administrador")
public class Admin implements Serializable {
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name", nullable=false, length=250)
    private String name;
    
    @Column(name="email", nullable=false, length=45)
    private String email;
    
    @Column(name="password", nullable=false, length=45)
    private String password;
}

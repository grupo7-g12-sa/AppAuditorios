/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.appAuditorio.apis.interfaces;

import com.appAuditorio.apis.entity.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author REIDEH
 */
public interface InterfacesMensaje extends CrudRepository<Mensaje,Integer>
{
    
}

/*
 * Creación de servicio para la ejecución de operaciones CRUD en tabla Admin.
 */
package com.appAuditorio.apis.service;

import com.appAuditorio.apis.entity.Admin;
import com.appAuditorio.apis.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repositorioAdmin;
    
    /**
     * Devuelve una lista con los registros de la tabla Administrador.
     * @return la lista con los objetos Admin de la tabla Administrador.
     */
    public List<Admin> getAllAdmins(){
        return repositorioAdmin.findAll();
    }
    
    /**
     * Crea un nuevo administrador en la tabla Administrador.
     * @param admin el admin que se creará.
     * @return el objeto Admin creado.
     */
    public Admin saveAdmin(Admin admin){
        return repositorioAdmin.save(admin);
    }
    
    /**
     * Actualiza la información de un administrador de la tabla Administrador.
     * @param admin el administrador con los nuevos valores.
     * @return el objeto Admin modificado.
     */
    public Admin updateAdmin(Admin admin){
        /**
         * Intenta recuperar el administrador usando el id y la guarda en
         * adminMod; si no la encuenta, guarda el valor null.
         */
        Admin adminMod = repositorioAdmin.findById(admin.getId()).orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        adminMod.setName(admin.getName());
        adminMod.setEmail(admin.getEmail());
        adminMod.setPassword(admin.getPassword());
        /**
         * Guardar los cambios en la tabla.
         */
        repositorioAdmin.save(adminMod);
        
        return adminMod;
    }
    
    /**
     * Elimina un administrador de la tabla Administrador.
     * @param id el id del administrador que se borrará.
     * @return un aviso de eliminado con el Id del administrador eliminado.
     */
    public String deleteAdmin(int id){
        repositorioAdmin.deleteById(id);
        
        return "Administrador eliminado. Id: " + id;
    }
}

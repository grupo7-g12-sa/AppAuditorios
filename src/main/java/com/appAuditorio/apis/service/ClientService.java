/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.service;

import com.appAuditorio.apis.entity.Client;
import com.appAuditorio.apis.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hedier Alvarez Grupo 12 
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repositoryClient;
    
    /**
     * Devuelve una lista con los registros de la tabla Clientes.
     * @return la lista con los objetos Client de la tabla Clientes.
     */
    public List<Client> getAllClient(){
        return repositoryClient.findAll();
    }
    
    /**
     * Crea un nuevo Cliente en la tabla Clientes.
     * @param client el Cliente que se creará.
     * @return el objeto client creado.
     */
    public Client saveClient(Client client){
        return repositoryClient.save(client);
    }
    
     /**
     * Actualiza la información de un Cliente de la tabla Clientes.
     * @param client el administrador con los nuevos valores.
     * @return el objeto Client modificado.
     */
    public Client updateClient(Client client){
        /**
         * Intenta recuperar el Cliente usando el idCliente y la guarda en
         * clientMod; si no la encuenta, guarda el valor null.
         */
        Client clientMod = repositoryClient.findById(client.getIdClient()).orElse(null);
        /**
         * Reemplazar los valores existentes con los ingresados.
         */
        clientMod.setName(client.getEmail());
        clientMod.setPassword(client.getPassword());
        clientMod.setName(client.getName());
        clientMod.setAge(client.getAge());        
        /**
         * Guardar los cambios en la tabla.
         */
        repositoryClient.save(clientMod);        
        return clientMod;
    }
    /**
     * Elimina un Cliente de la tabla Clientes.
     * @param id_client el id del Cliente que se borrará.
     * @return un aviso de eliminado con el Id del Cliente eliminado.
     */
    public String deleteClient(int id){
        repositoryClient.deleteById(id);        
        return "Cliente eliminado Id: " + id;
    }
    
    
    
    
}

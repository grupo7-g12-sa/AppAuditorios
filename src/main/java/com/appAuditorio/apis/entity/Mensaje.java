/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author REIDEH
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Mensaje implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idMessage")
    private int idMessage;
    
    @Column(name="messageText", nullable=false, length=250)
    private String messageText;
    
    //@ManyToOne //(cascade = {CascadeType.PERSIST},mappedBy="audicence")  
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="id")
    //@JoinColumn(name="id", nullable=false)
    //@JoinColumn(name="id", nullable=false)    
    @JsonIgnoreProperties({"messages","reservations"})
    private List<Audience> Audicence;
    
    @ManyToOne //(cascade = {CascadeType.PERSIST},mappedBy="category")  
    @JoinColumn(name="idClient", nullable=false) 
    @JsonIgnoreProperties({"messages","reservations"})
    private Client Client;
    

}

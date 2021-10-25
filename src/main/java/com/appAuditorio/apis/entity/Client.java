/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idClient")
    private int idClient;
    
    @Column(name="email", nullable=false, length=45)
    private String email;
    
    @Column(name="password", nullable=false, length=45)
    private String password;
    
    @Column(name="name", nullable=false, length=250)
    private String name;
    
    @Column(name="age", nullable=false)
    private int age;
    
   /* @OneToMany //(cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties({"category","message"})
    private List<Audience> Audiences;*/
    
    /*@OneToMany //(cascade = {CascadeType.PERSIST},mappedBy="category")    
    private Mensaje Messages;*/
    
    @OneToOne //(cascade = {CascadeType.PERSIST},mappedBy="category")
    //@JsonIgnoreProperties({"category","message"})
    private Mensaje Messages;
    
    @OneToMany //(cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties({"category","message"})
    private List<Reserva> Reservations;
    
}

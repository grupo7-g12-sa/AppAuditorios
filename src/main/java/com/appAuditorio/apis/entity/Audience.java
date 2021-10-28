/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appAuditorio.apis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="audience")
public class Audience {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", nullable=false, length=45)
    private String name;
    
    @Column(name="owner", nullable=false, length=45)
    private String owner;
        
    @Column(name="capacity")
    private Integer capacity;
    
    @Column(name="description", length=250)
    private String description;
    
    @ManyToOne//(optional=false)
  //  @JoinColumn(name="id", nullable=false)
    @JsonIgnoreProperties("audiences")
    private Category category;
    
    @OneToMany
    //@OneToMany(cascade={CascadeType.PERSIST}, mappedBy="idMessage")
    //@JsonIgnoreProperties({"client", "audience"})
    //@JoinColumn(name="idMessage", nullable=false)
    //@JsonIgnoreProperties({"messages", "reservations"})
    private List<Mensaje> messages; 
    
    @OneToMany//(cascade={CascadeType.PERSIST}, mappedBy="audience")
    //@JsonIgnoreProperties("audience")
    private List<Reserva> reservations;
}

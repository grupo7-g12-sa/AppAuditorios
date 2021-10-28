/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Hedier Alvarez Ovalle    Grupo 12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="score")

public class Score implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idscore")
    private int idscore;
    /*
    @Column(name="startDate", nullable=false, length=450)
    private String startDate;
    
    @Column(name="devolutionDate", nullable=false, length=450)
    private String devolutionDate;
    
    //@Column(name="status", nullable=false, length=450)
    //private String status;
    
   /* 
    @ManyToOne//(cascade={CascadeType.PERSIST}, mappedBy="audience")
    @JsonIgnoreProperties("reservations")
    @JoinColumn(name="id", nullable=false)
    private Audience audience;
    
    @ManyToOne//(cascade={CascadeType.PERSIST}, mappedBy="audience")
    //@JsonIgnoreProperties("audience")
    @JoinColumn(name="idClient", nullable=false)
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
    */
    
    
    
}

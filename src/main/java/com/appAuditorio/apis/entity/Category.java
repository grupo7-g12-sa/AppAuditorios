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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hedier alvarez grupo 12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")

public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name", nullable=false, length=45)
    private String name;
    
    @Column(name="description", length=250)
    private String description;
    
    @OneToMany//(cascade = {CascadeType.PERSIST},mappedBy="category")
    //@JsonIgnoreProperties({"category","message"})
    private List<Audience> Audiences;

}

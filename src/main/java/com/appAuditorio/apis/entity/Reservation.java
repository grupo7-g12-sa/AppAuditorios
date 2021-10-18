
package com.appAuditorio.apis.entity;

/**
 *
 * @author Wilson Velasco
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Reservation")
public class Reservation  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private int idReservation;
    

    @Column(name="startDate")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd")
    private Date startDate;
    
    @Column(name="devolutionDate")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd")
    private Date devolutionDate;
    
    @Column(name="status")
    @Temporal(TemporalType.DATE)
    private String status = "created";
    
    @ManyToOne(optional = false)
    @JoinColumn(name="audience", nullable = false)
    @JsonIgnoreProperties("reservations")
    private Auditorio audience;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="idClient", nullable = false)
    @JsonIgnoreProperties("reservations")
    private Client client;
       
    
}
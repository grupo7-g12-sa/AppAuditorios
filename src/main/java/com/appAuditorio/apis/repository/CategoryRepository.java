/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.appAuditorio.apis.repository;

import com.appAuditorio.apis.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author REIDEH
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}

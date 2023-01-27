/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.meza.anggotaservice.Repository;

import com.meza.anggotaservice.Entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ASUS
 */
public interface AnggotaRepository extends JpaRepository<Anggota, Long>{

    public Anggota findByAnggotaId(Long anggotaId);
    
}
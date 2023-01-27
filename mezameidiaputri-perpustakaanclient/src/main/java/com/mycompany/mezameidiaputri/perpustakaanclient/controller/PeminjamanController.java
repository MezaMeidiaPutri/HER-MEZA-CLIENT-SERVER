/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mezameidiaputri.perpustakaanclient.controller;

import com.mycompany.mezameidiaputri.perpustakaanclient.FormPeminjaman;
import com.mycompany.mezameidiaputri.perpustakaanclient.model.Peminjaman;
import com.mycompany.mezameidiaputri.perpustakaanclient.service.PeminjamanService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ASUS
 */
public class PeminjamanController {
    private final PeminjamanService peminjamanService;
    private final FormPeminjaman formPeminjaman;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        this.formPeminjaman = formPeminjaman;
        peminjamanService = new PeminjamanService();
    }
    
    public void bersihForm(){
        formPeminjaman.getTxtPeminjamanId().setText("");
        formPeminjaman.getTxtBukuId().setText("");
        formPeminjaman.getTxtAnggotaId().setText("");
        formPeminjaman.getTxtTanggalPinjam().setText("");
        formPeminjaman.getTxtTanggalKembali().setText("");
    }
    
    public void getPeminjamanId(){
        Long id = Long.parseLong(formPeminjaman.getTxtPeminjamanId().getText());
        Peminjaman peminjaman = (Peminjaman) peminjamanService.getPeminjaman(id);
        if(peminjaman!=null){
            formPeminjaman.getTxtBukuId().setText(peminjaman.getBukuId().toString());
            formPeminjaman.getTxtAnggotaId().setText(peminjaman.getAnggotaId().toString());
            formPeminjaman.getTxtTanggalPinjam().setText(peminjaman.getTglPinjam());
            formPeminjaman.getTxtTanggalKembali().setText(peminjaman.getTglKembali());
        }else{
            JOptionPane.showMessageDialog(formPeminjaman, "Data Tidak Ditemukan");
        }
    }
    
    public Peminjaman savePeminjaman() {
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtBukuId().getText()));
        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtAnggotaId().getText()));
        peminjaman.setTglPinjam(formPeminjaman.getTxtTanggalPinjam().getText());
        peminjaman.setTglKembali(formPeminjaman.getTxtTanggalKembali().getText());
        peminjaman = (Peminjaman) peminjamanService.savePeminjaman(peminjaman);
        if (peminjaman != null) {
            formPeminjaman.getTxtPeminjamanId().setText(peminjaman.getPeminjamanId().toString());
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Data Gagal");
        }
        return (Peminjaman) peminjamanService.savePeminjaman(peminjaman);
    }
    
     public void updatePeminjaman() {
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setPeminjamanId(Long.parseLong(formPeminjaman.getTxtPeminjamanId().getText()));
        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtBukuId().getText()));
        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtAnggotaId().getText()));
        peminjaman.setTglPinjam(formPeminjaman.getTxtTanggalPinjam().getText());
        peminjaman.setTglKembali(formPeminjaman.getTxtTanggalKembali().getText());
        peminjaman = (Peminjaman) peminjamanService.savePeminjaman(peminjaman);
        if (peminjaman != null) {
            formPeminjaman.getTxtPeminjamanId().setText(peminjaman.getPeminjamanId().toString());
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Gagal");
        }
    }
    
    public void deletePeminjaman(){
        Long id = Long.parseLong(formPeminjaman.getTxtPeminjamanId().getText());
        peminjamanService.deletePeminjaman(id);
        JOptionPane.showMessageDialog(formPeminjaman, "Delete Data Berhasil");
    }
    
        public void viewTabel(){
        DefaultTableModel tabelModel = (DefaultTableModel) formPeminjaman.getTabelPeminjaman().getModel();
        tabelModel.setRowCount(0);
        List<Peminjaman> peminjamanList = peminjamanService.getAllPeminjaman();
        for(Peminjaman peminjaman : peminjamanList){
            Object[] row = {
                peminjaman.getPeminjamanId(),
                peminjaman.getBukuId(),
                peminjaman.getAnggotaId(),
                peminjaman.getTglPinjam(),
                peminjaman.getTglKembali()
            };
            tabelModel.addRow(row);
        }
    } 
}

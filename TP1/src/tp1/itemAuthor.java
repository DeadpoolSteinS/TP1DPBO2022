/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tp1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nichiyo
 */
public class itemAuthor extends javax.swing.JPanel {

    /**
     * Creates new form itemAuthor
     */
    dbConnection dbcon = new dbConnection();
    private Author aut;
    private Integer id;
    private String fixJumlah;
        
    public itemAuthor(Integer id, String imgName, String nama, Integer jumlah) {
        initComponents();
        this.aut = new Author(imgName,nama,jumlah);
        try {
            BufferedImage imageData = (BufferedImage) ImageIO.read(new File("src/assets/" + imgName));
            Image dimg = imageData.getScaledInstance(110,110,Image.SCALE_SMOOTH);
            imageLabel.setIcon(new javax.swing.ImageIcon(dimg));
        } catch (IOException e) {
            System.err.println("Gagal Memasang Gambar " + e.getMessage());
        }
        namaLabel.setText(nama);
        jumlahLabel.setText("Jumlah Buku: " + jumlah.toString());
        this.id = id;
        this.fixJumlah = jumlah.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        namaLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jumlahLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(187, 187, 187));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMaximumSize(new java.awt.Dimension(32767, 118));
        setMinimumSize(new java.awt.Dimension(0, 118));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        namaLabel.setText("Novaldi Sandi Ago");

        imageLabel.setText("jLabel1");

        jumlahLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn))
                    .addComponent(namaLabel)
                    .addComponent(jumlahLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(namaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jumlahLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn)
                            .addComponent(deleteBtn)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        formAuthor masukanAuthor = new formAuthor(this.id, namaLabel.getText(), fixJumlah);
        masukanAuthor.setVisible(true);
        masukanAuthor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try {
            dbcon.stm.execute("DELETE FROM author WHERE id=" + this.id.toString() + ";");
            JOptionPane.showMessageDialog(null, "Delete Berhasil!");
        } catch (SQLException e) {
            System.err.println("Delete Gagal " + e.getMessage());
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jumlahLabel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

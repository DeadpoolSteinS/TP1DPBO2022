/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nichiyo
 */
public class dbConnection {
    public static Connection con;
    public static Statement stm;
    
    public void connect() {
        try {
            String url  = "jdbc:mysql://localhost/prak_dpbo";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,user,pass);
            stm = (Statement) con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
    }
    
    public DefaultTableModel readTable() {
        DefaultTableModel dataTabel = null;
        try {
            Object[] column = {"No", "Nama", "NIM"};
            connect();
            dataTabel = new DefaultTableModel(null, column);
            String sql = "SELECT nama,nim FROM mahasiswa";
            ResultSet res = stm.executeQuery(sql);
            
            int no = 1;
            while(res.next()){
                Object[] hasil = new Object[3];
                hasil[0] = no;
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("nim");
                no++;
                System.out.print(hasil[1]);
                dataTabel.addRow(hasil);
            }
        } catch (SQLException e) {
            System.err.println("Read Gagal " + e.getMessage());
        }
        return dataTabel;
    }
    
    public ResultSet query(String inputan) {
        ResultSet res = null;
        try {
            connect();
            String sql = inputan;
            res = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Read Gagal " + e.getMessage());
        }
        return res;
    }
}

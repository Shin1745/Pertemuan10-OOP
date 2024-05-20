/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Muhammad Agriyansyah (2201010410)
 * 20-05-2024
 */
public class Pertemuan10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        list_all();
    }
    
   private static void list_all() throws SQLException{
        Connection cnn = koneksi.getKoneksi();
        if(cnn.isClosed()){
            System.out.println("Koneksi Gagal");
        }
        else{
            PreparedStatement PS = cnn.prepareStatement("select * from data_teman;");
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
              System.out.println( "No Record: "+ rs.getInt("IdTeman"));
              System.out.println("Nama : "+ rs.getString("Nama"));
              System.out.println("Alamat : "+ rs.getString("Alamat"));
              System.out.println("Telp : "+ rs.getString("Telepon"));
              
            }
            cnn.close();
        }
        
    }
}

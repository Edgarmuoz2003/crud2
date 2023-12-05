/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDconeccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Esteban Rodriguez
 */
public class Coneccion {

    public Connection conection;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String BD_URL = "jdbc:mysql://localhost:3307/crud";
    private final String USER = "root";
    private final String PASSWORD = "";
    
    public void conectar(){
        try {
            Class.forName(JDBC_DRIVER);
            conection = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        } catch (Exception e) {
        }
    }
    
    public void cerrar() throws SQLException{
        if(conection != null){
            if(!conection.isClosed()){
                conection.close();
            }
        }
    }
    
}


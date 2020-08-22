package productos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class conectar {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/agropecuario"; 

    public conectar() {
        conn =null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url,usuario,password);
            if(conn !=null){
                System.out.println("todo bien");
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("error al conectar"+ e); 
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Te desconectaste");
        }
    }
    
    
    
}

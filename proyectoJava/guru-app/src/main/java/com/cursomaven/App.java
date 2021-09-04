package com.cursomaven;

import com.cursomaven.clases.Contacto;
import com.cursomaven.connection.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App{
    public static final String HOST = "localhost:3306";
    public static final String BD = "cursomaven";
    public static final String USER = "root";
    public static final String PASSW = "root";
    public static final String QUERY = "SELECT COUNT(*) FROM cursomaven.contacto";

    public static void main( String[] args ){
        System.out.println( "\t======== [Guru Project] ======" );
        testA();
        testB();
    }

    public static void testB(){
        DatabaseConnectionManager dcm = new DatabaseConnectionManager(HOST,BD,USER,PASSW);
        int cantidad = 0;
        try{
            Connection connection = dcm.getConnection();
            System.out.println("Conexion: "+connection.toString());
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(QUERY);
            
            while(resultSet.next()){
                cantidad = resultSet.getInt(1);
            }
            System.out.println("No. de registros: "+cantidad);


            if(resultSet != null){
                resultSet.close();
            }

            if(statement != null){
                statement.close();
            }

            if(connection != null){
                connection.close();
            }
        }catch(SQLException sqle){
            System.err.println("Ha ocurrido una excepcion: "+sqle.getMessage());
        }finally{
            System.out.println("Hecho!!");
        }
    }

    public static void testA(){
        Contacto contacto = new Contacto();
        contacto.setId(1);
        contacto.setNombre("Juana");
        contacto.setApellidos("Alvirde");
        contacto.setTelefono("7332114567");
        contacto.setCorreo("juana.alvirde@hotmail.com");
        System.out.println(contacto);
    }
}



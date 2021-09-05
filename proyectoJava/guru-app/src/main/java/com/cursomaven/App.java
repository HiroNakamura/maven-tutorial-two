package com.cursomaven;

import com.cursomaven.clases.Contacto;
import com.cursomaven.connection.DatabaseConnectionManager;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App{
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String HOST = "localhost:3306";
    public static final String BD = "cursomaven";
    public static final String USER = "root";
    public static final String PASSW = "1234567";
    public static final String QUERY = "SELECT COUNT(*) FROM cursomaven.contacto";


    public static void main( String[] args ){
        System.out.println( "\t======== [Guru Project] ======" );
        //testA();
        testB();
    }

    public static void testB(){
        DatabaseConnectionManager dcm = new DatabaseConnectionManager(HOST,BD,USER,PASSW);
        int cantidad = 0;
        try{
            Class.forName(DRIVER);
            //Class.forName(DRIVER).newInstance();  
            Connection connection = dcm.getConnection(); //  DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BD+"?useSSL=false",USER, PASSW);      
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            
            while(resultSet.next()){
                cantidad = resultSet.getInt(1);
            }
            System.out.println("No. de registros: "+cantidad);
            
            if(cantidad > 0){
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT id, nombre, apellidos, telefono, correo FROM cursomaven.contacto");
            }

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
            System.err.println("Ha ocurrido una excepcion [SQLException]: "+sqle.getMessage());
            sqle.printStackTrace();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Ha ocurrido una excepcion [ClassNotFoundException]: "+cnfe.getMessage());
        }finally{
            System.exit(0);
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



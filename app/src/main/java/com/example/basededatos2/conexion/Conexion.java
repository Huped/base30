package com.example.basededatos2.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private String db = "fgstock1";
    private String user = "fg_admin@fgstock";
    private String pass = "Maxifer123";
    private String url = "jdbc:postgresql://fgstock.postgres.database.azure.com:5432/fgstock1";
    public Connection conn = null;

    public Conexion(){
        try {
            //Utilizamos el Driver Postgresql
            Class.forName("org.postgresql.Driver");

            //Realizamos la conexión
            conn = DriverManager.getConnection(this.url, this.user, this.pass);

            //Validamos la conexión
            if (conn != null) {
                System.out.println("-- CONEXIÓN ESTABLECIDA --");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Método para cerrar la conexión
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

}

package com.example.basededatos2;

import android.content.Context;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.example.basededatos2.modelo.Articulo;
import com.example.basededatos2.dao.ArticuloDAOJDBC;

public class Hilo1 extends Thread {

    private String codigo;
    private Articulo xArticulo;

    public Hilo1(String codigo) {
        this.codigo=codigo;
    }

    public void run() {

        try {

            //Creamos un lista de productos
            List<Articulo> artiLista = new ArrayList<>();

            //Creamos nuestra clase que realizará las consultas Postgre
            ArticuloDAOJDBC artiDao = new ArticuloDAOJDBC();

            xArticulo = new Articulo();
            try {
                // Intentamos ejecutar la consulta y obtener una lista de objetos tipo productos
                artiLista = artiDao.selectxCod(codigo);

                //Iteramos sobre la lista he imprimimos uno a uno los objetos obtenidos
                for(Articulo xarti:artiLista){
                    System.out.println(xarti.toString());
                    xArticulo = xarti;
                }

            } catch (SQLException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
    } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Articulo getxArticulo() {
        return xArticulo;
    }
}

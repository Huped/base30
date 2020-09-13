package com.example.basededatos2.dao;

import com.example.basededatos2.modelo.Articulo;
import java.sql.SQLException;
import java.util.List;

public interface ArticuloDAO {

    /*Definimos lo métodos que realizaran las operaciones básicas */

    public int insert(Articulo articulo) //Definición del método que insertará
            throws SQLException;

    public int update(Articulo articulo) //Definición del método que actualizará
            throws SQLException;

    public int delete(Articulo articulo) //Definición del método que borrará
            throws SQLException;

    public List<Articulo> select()       //Definición del método que Seleccionará
            throws SQLException;

    public List<Articulo> selectxCod(String codigo)       //Definición del método que Seleccionará por codigo de articulo
            throws SQLException;

    public List<Articulo> selectxDescri(String codigo)       //Definición del método que Seleccionará por Descripciond de Articulo
            throws SQLException;

}

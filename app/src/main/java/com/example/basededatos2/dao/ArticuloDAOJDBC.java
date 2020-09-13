package com.example.basededatos2.dao;

import com.example.basededatos2.modelo.Articulo;
import com.example.basededatos2.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOJDBC implements ArticuloDAO {

    /*Declaramos atributos que contengan la conexión y las sentencias SQL*/
    private Conexion conn;

    //Constantes
    private final String SQL_INSERT = "INSERT INTO  articulo('art_codigo','art_descri') VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE articulo SET art_nombre=?, art_descri=? WHERE art_codigo=?";
    private final String SQL_DELETE = "DELETE FROM articulo WHERE art_codigo = ?";
    private final String SQL_SELECT = "SELECT * FROM articulo";
    private final String SQL_SELECTXCOD = "SELECT * FROM articulo WHERE art_codigo = ?";
    private final String SQL_SELECTXDES = "SELECT * FROM articulo WHERE art_descri like ?";

    //Creamos un constructor vacio y otro que obtenga la conexión
    public ArticuloDAOJDBC() {
    }

    public ArticuloDAOJDBC(Conexion conn) {
        this.conn = conn;
    }

    @Override
    public int insert(Articulo articulo) throws SQLException {

        //Variable de conexión
        Conexion conn1 = null;
        PreparedStatement stmt = null;

        int rows = 0;

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_INSERT);

        //Definimos el indice que sustiuirá a los parámetros
        int index = 1;

        //Indicamos el valor codigo
        stmt.setString(index++, articulo.getCodigo());

        //Indicamos el valor descri
        stmt.setString(index++, articulo.getDescri());

        //Por último el valor barra
        stmt.setString(index, articulo.getBarra());

        //Ejecutamos el insert
        rows = stmt.executeUpdate();

        //Cerramos la conexión
        conn1.close();

        return rows;

    }

    @Override
    public int update(Articulo articulo) throws SQLException {
        //Variable de conexión
        Conexion conn1 = null;
        PreparedStatement stmt = null;

        int rows = 0;

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_UPDATE);

        //Definimos el indice que sustiuirá a los parámetros
        int index = 1;

        //Indicamos el valor codigo
        stmt.setString(index++, articulo.getCodigo());

        //Indicamos el valor descri
        stmt.setString(index++, articulo.getDescri());

        //Por último el valor barra
        stmt.setString(index, articulo.getBarra());

        //Ejecutamos el insert
        rows = stmt.executeUpdate();

        //Cerramos la conexión
        conn1.close();

        return rows;
    }

    @Override
    public int delete(Articulo articulo) throws SQLException {
        //Variable de conexión
        Conexion conn1 = null;

        //Variable encargada de ejecutar la operación SQL
        PreparedStatement stmt = null;

        int rows = 0;

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_DELETE);

        //Definimos el indice que sustiuirá a los parámetros
        int index = 1;

        //Indicamos el id a borrar
        stmt.setString(index++, articulo.getCodigo());

        //Ejecutamos el delete
        rows = stmt.executeUpdate();

        //Cerramos la conexión
        conn1.close();

        return rows;
    }

    @Override
    public List<Articulo> select() throws SQLException {

        Conexion conn1 = null;
        PreparedStatement stmt = null;

        //Variable que almacenará el resultado de la consulta
        ResultSet rs = null;

        Articulo articulo = new Articulo();

        //Creamos la lista de tipo Articulo
        List<Articulo> articuloLista = new ArrayList<Articulo>();

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la consulta
        stmt = conn1.conn.prepareStatement(SQL_SELECT);

        rs = stmt.executeQuery();

        while(rs.next()){

            //Preparamos el objeto
            articulo.setCodigo(rs.getString(1)) ;
            articulo.setDescri(rs.getString(2));
            articulo.setBarra(rs.getString(3));
            articulo.setGrupo(rs.getInt(4));
            articulo.setCospro(rs.getDouble(5));
            articulo.setCosult(rs.getDouble(6));
            articulo.setPreven(rs.getDouble(7));
            articulo.setPreve2(rs.getDouble(8));
            articulo.setPreve3(rs.getDouble(9));
            articulo.setMoneda(rs.getString(10));
            articulo.setStock1(rs.getDouble(11));
            articulo.setStock2(rs.getDouble(12));

            System.out.println(rs.getString(2));

            //Lo añadimos a la lista
            articuloLista.add(articulo);
        }

        //Cerramos la conexión
        conn1.close();

        //Variable de retorno 
        return articuloLista;
    }

    @Override
    public List<Articulo> selectxCod(String codigo) throws SQLException {

        Conexion conn1 = null;
        PreparedStatement stmt = null;

        //Variable que almacenará el resultado de la consulta
        ResultSet rs = null;

        Articulo Articulo = new Articulo();

        //Creamos la lista de tipo Articulo
        List<Articulo> ArticuloLista = new ArrayList<Articulo>();

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la consulta
        stmt = conn1.conn.prepareStatement(SQL_SELECTXCOD);
        stmt.setString(1, codigo);

        rs = stmt.executeQuery();

        while(rs.next()){

            //Preparamos el objeto
            Articulo.setCodigo(rs.getString(1)) ;
            Articulo.setDescri(rs.getString(2));
            Articulo.setBarra(rs.getString(3));
            Articulo.setGrupo(rs.getInt(4));
            Articulo.setCospro(rs.getDouble(5));
            Articulo.setCosult(rs.getDouble(6));
            Articulo.setPreven(rs.getDouble(7));
            Articulo.setPreve2(rs.getDouble(8));
            Articulo.setPreve3(rs.getDouble(9));
            Articulo.setMoneda(rs.getString(10));
            Articulo.setStock1(rs.getDouble(11));
            Articulo.setStock2(rs.getDouble(12));

            //Lo añadimos a la lista
            ArticuloLista.add(Articulo);
        }

        //Cerramos la conexión
        conn1.close();

        //Variable de retorno
        return ArticuloLista;
    }

    @Override
    public List<Articulo> selectxDescri(String codigo) throws SQLException {

        Conexion conn1 = null;
        PreparedStatement stmt = null;

        //Variable que almacenará el resultado de la consulta
        ResultSet rs = null;

        Articulo articulo = new Articulo();

        //Creamos la lista de tipo Articulo
        List<Articulo> articuloLista = new ArrayList<Articulo>();

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la consulta
        stmt = conn1.conn.prepareStatement(SQL_SELECTXDES);
        stmt.setString(1, "%"+codigo+"%");

        rs = stmt.executeQuery();

        while(rs.next()){

            //Preparamos el objeto
            articulo.setCodigo(rs.getString(1)) ;
            articulo.setDescri(rs.getString(2));
            articulo.setBarra(rs.getString(3));
            articulo.setGrupo(rs.getInt(4));
            articulo.setCospro(rs.getDouble(5));
            articulo.setCosult(rs.getDouble(6));
            articulo.setPreven(rs.getDouble(7));
            articulo.setPreve2(rs.getDouble(8));
            articulo.setPreve3(rs.getDouble(9));
            articulo.setMoneda(rs.getString(10));
            articulo.setStock1(rs.getDouble(11));
            articulo.setStock2(rs.getDouble(12));

            //Lo añadimos a la lista
            articuloLista.add(articulo);
        }

        //Cerramos la conexión
        conn1.close();

        //Variable de retorno
        return articuloLista;
    }

}


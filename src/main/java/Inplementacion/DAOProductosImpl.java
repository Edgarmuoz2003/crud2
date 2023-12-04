/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inplementacion;

import BDconeccion.Coneccion;
import intefazDAO.DAOProductos;
import java.sql.PreparedStatement;
import java.util.List;
import tablas.CProductos;

/**
 *
 * @author edgar
 */
public class DAOProductosImpl extends Coneccion implements DAOProductos{

    @Override
    public void registrar(CProductos Productos) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conection.prepareStatement("INSERT INTO crud (id, categoria, descripcion, valorIVA, valorCompra, valorVenta) VALUES(?,?,?,?,?,?) ");
            st.setInt(1, Productos.getId());
            st.setString(2, Productos.getCategoria());
            st.setString(3, Productos.getDescripcion());
            st.setInt(4, Productos.getIVA());
            st.setInt(5, Productos.getPrecioCompra());
            st.setInt(6, Productos.getPrecioVenta()); 
            st.executeUpdate();
            
            
                    
        } catch (Exception e) {
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void editar(CProductos editarProductos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int productoId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CProductos> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CProductos> Buscar(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CProductos getProductos(int productosId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

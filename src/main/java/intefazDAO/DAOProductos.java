/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package intefazDAO;

import java.util.List;
import tablas.CProductos;

/**
 *
 * @author edgar
 */
public interface DAOProductos {

   
    public void registrar(CProductos Productos)throws Exception;
    public void editar(CProductos editarProductos) throws Exception;
    public void eliminar(int productoId) throws Exception;   
    public List <CProductos >listar()throws Exception;
    public List <CProductos>Buscar(String name)throws Exception;
    public CProductos getProductos(int productosId)throws Exception;
    
}

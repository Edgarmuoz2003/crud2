/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inplementacion;

import BDconeccion.Coneccion;
import intefazDAO.DAOProductos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tablas.CProductos;

/**
 *
 * @author edgar
 */
public class DAOProductosImpl extends Coneccion implements DAOProductos {

    @Override
    public void registrar(CProductos Productos) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conection.prepareStatement("INSERT INTO productos (id, categoria, descripcion, valorIVA, valorCompra, valorVenta) VALUES(?,?,?,?,?,?) ");
            st.setInt(1, Productos.getId());
            st.setString(2, Productos.getCategoria());
            st.setString(3, Productos.getDescripcion());
            st.setInt(4, Productos.getIVA());
            st.setInt(5, Productos.getPrecioCompra());
            st.setInt(6, Productos.getPrecioVenta());
            st.executeUpdate();

        } catch (Exception e) {
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void editar(CProductos editarProductos) throws Exception {
        try {
// Aquí debes escribir el código para realizar la actualización en la base de datos
            this.conectar(); // Método ficticio para obtener una conexión a la base de datos
            String sql = "UPDATE productos SET categoria=?, descripcion=?, valorIVA=?, valorCompra=?, valorVenta=? WHERE id=?";
            try (PreparedStatement stmt = conection.prepareStatement(sql)) {
                stmt.setString(1, editarProductos.getCategoria());
                stmt.setString(2, editarProductos.getDescripcion());
                stmt.setDouble(4, editarProductos.getIVA());
                stmt.setDouble(3, editarProductos.getPrecioCompra());
                stmt.setDouble(5, editarProductos.getPrecioVenta());
                stmt.setInt(6, editarProductos.getId());

// Ejecutar la actualización
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
// Manejar la excepción adecuadamente
            throw new Exception("Error al modificar el producto en la base de datos", e);
        }
    }

    @Override
    public void eliminar(int productoId) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conection.prepareStatement("DELETE FROM productos WHERE id = ?;");
            st.setInt(1, productoId);
            st.executeUpdate();
        } catch (Exception e) {
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<CProductos> listar() throws Exception {
        List<CProductos> productos = new ArrayList<>();

        // Establecer la conexión a la base de datos (reemplaza las credenciales y la URL según tu configuración)
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/crud", "root", "")) {
            // Preparar la consulta SQL
            String sql = "SELECT * FROM productos";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Ejecutar la consulta y obtener resultados
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Iterar sobre los resultados y agregar productos a la lista
                    while (resultSet.next()) {
                        CProductos producto = new CProductos();
                        producto.setId(resultSet.getInt("id"));
                        producto.setCategoria(resultSet.getString("categoria"));
                        producto.setDescripcion(resultSet.getString("descripcion"));
                        producto.setIVA(resultSet.getInt("valorIVA"));
                        producto.setPrecioCompra(resultSet.getInt("valorCompra"));
                        producto.setPrecioVenta(resultSet.getInt("valorVenta"));

                        productos.add(producto);
                    }
                }
            }
        }

        return productos;
    }

    @Override
    public List<CProductos> Buscar(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CProductos getProductos(int productosId) throws Exception {
        CProductos producto = new CProductos();

        try {
            this.conectar();
            PreparedStatement st = this.conection.prepareStatement("SELECT * FROM productos WHERE id = ?");
            st.setInt(1, productosId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioCompra(rs.getInt("precioCompra"));
                producto.setIVA(rs.getInt("IVA"));
                producto.setPrecioVenta(rs.getInt("precioVenta"));

            }
        } catch (Exception e) {
        } finally {
            this.cerrar();
        }
        return producto;
    }

}

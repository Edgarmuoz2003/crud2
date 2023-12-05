/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Inplementacion.DAOProductosImpl;
import intefazDAO.DAOProductos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tablas.CProductos;

/**
 *
 * @author edgar
 */
public final class FormProductos extends javax.swing.JFrame {

    /**
     * Creates new form FormProductos
     */
    public FormProductos() {
        initComponents();
        cargarProducto();
    }

    public void cargarProducto() {
        try {
            DAOProductos dao = new DAOProductosImpl();
            DefaultTableModel tablaP = (DefaultTableModel) tablaProductos.getModel();
            List<CProductos> productos = dao.listar();

            // Verificar si hay productos en la lista antes de mostrarlos
            if (!productos.isEmpty()) {
                for (CProductos producto : productos) {
                    Object[] rowData = {
                        producto.getId(),
                        producto.getCategoria(),
                        producto.getDescripcion(),
                        producto.getPrecioCompra(),
                        producto.getIVA(),
                        producto.getPrecioVenta()
                    };
                    // Agregar la fila al modelo
                    tablaP.addRow(rowData);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay productos en la base de datos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            // Manejar la excepción adecuadamente
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripción", "Precio compra", "IVA", "Precio venta"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormRegistrarProducto ventanaRegistrar = new FormRegistrarProducto();
        ventanaRegistrar.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tablaProductos.getSelectedRow() > -1) {
            try {
                int proId = (int) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0);
                DAOProductos dao = new DAOProductosImpl();
                CProductos producto = dao.getProductos(proId);

// Crear una instancia de tu ventana de edición
                Editar ventanaEdicion = new Editar();

// Configurar la interfaz de edición con los detalles del producto
                ventanaEdicion.cargarDatos(producto);

// Mostrar la ventana de edición
                ventanaEdicion.setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar el producto a editar.",
                    "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel tablaP = (DefaultTableModel) tablaProductos.getModel();

        // Limpia todas las filas existentes en la tabla
        tablaP.setRowCount(0);

        // Aquí deberías cargar los datos desde tu fuente de datos (base de datos, lista, etc.)
        List<CProductos> productos = obtenerDatosActualizados();

        // Añade las filas con los datos actualizados al modelo de la tabla
        for (CProductos producto : productos) {
            Object[] rowData = {producto.getId(), producto.getCategoria(), producto.getDescripcion(),
                producto.getPrecioCompra(), producto.getIVA(), producto.getPrecioVenta()};
            tablaP.addRow(rowData);
        }
    }

    // Método para obtener datos actualizados
    private List<CProductos> obtenerDatosActualizados() {
        // Aquí obtene los datos desde la base de datos
        DAOProductos dao = new DAOProductosImpl();
        try {
            return dao.listar();
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of(); // Devuelve una lista vacía en caso de error
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DAOProductos dao = new DAOProductosImpl();
        DefaultTableModel tablaP = (DefaultTableModel) tablaProductos.getModel();
        if (tablaProductos.getSelectedRow() > -1) {
            for (int i : tablaProductos.getSelectedRows()) {
                try {
                    dao.eliminar((int) tablaProductos.getValueAt(i, 0));
                    tablaP.removeRow(i);
                    String mensajeUsuario = "EL PRODUCTO FUE ELIMINADO CORRECTAMENTE ";
                    JOptionPane.showMessageDialog(this, mensajeUsuario,
                            "MENSAJE INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                } finally {
                }
            }
        } else {
            String mensajeUsuario = "Debes seleccionar el producto a eliminar. ";
            JOptionPane.showMessageDialog(this, mensajeUsuario,
                    "MENSAJE INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProductos().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}

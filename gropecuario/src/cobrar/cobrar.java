/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.Menu;
import productos.conectar;

/**
 *
 * @author USER
 */
public class cobrar extends javax.swing.JFrame {

    Menu men;
    conectar con; // para crear la conexion
    PreparedStatement ps; // para decir lo que queremos hacer
    ResultSet rs; // aqui se guarda el resutlado de la conexion
    Connection cone = null; // para poder interacturar con la conexion
    private List<String> nombres;
    private List<String> ID;
    String IdSeleccionada;
    
    
    public cobrar() {
        initComponents();
        con = new conectar(); // esto hace la conexion con la base
        Connection reg = con.getConnection(); // hace la conexion con la base
        nombres = new ArrayList<>(); // la lista donde vamos a poner lso nombres
        ID = new ArrayList<>();
        
        
        try {
            cone = con.getConnection(); // abrimos la conexion
            ps = cone.prepareStatement("SELECT * FROM productos"); // decimos que queremos hacer
            rs = ps.executeQuery(); // hacemos lo anterior
            while(rs.next()){
                ID.add(rs.getString("ID"));
                IdSeleccionada = rs.getString("ID");
                nombres.add(rs.getString("Nombre")); // anade los nombres de los productos a la lista
                this.ComboNombres.addItem(rs.getString("Nombre")); // agrega los productos al combobox
                this.ComboNombres.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ps = cone.prepareStatement("SELECT * FROM productos WHERE Nombre=?"); // decimos que queremos hacer
                            ps.setString(1, ComboNombres.getSelectedItem().toString());
                            rs = ps.executeQuery(); // hacemos lo anterior
                            rs.next();
                            IDTxt.setText(rs.getString("ID"));
                            PrecioLbl.setText(String.valueOf(rs.getInt("Precio")));
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(cobrar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                });
            }//fin del while
        } catch (SQLException ex) {
            Logger.getLogger(cobrar.class.getName()).log(Level.SEVERE, null, ex);
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

        RegresarBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        IDTxt = new javax.swing.JTextField();
        ComboNombres = new javax.swing.JComboBox<>();
        IDLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PrecioLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar");

        IDLbl.setText("ID:");

        jLabel1.setText("Precio: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegresarBtn)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ComboNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(IDLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrecioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLbl)
                    .addComponent(jLabel1)
                    .addComponent(PrecioLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(RegresarBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBtnActionPerformed
        this.setVisible(false);
        men = new Menu();
        men.setVisible(true);
    }//GEN-LAST:event_RegresarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cobrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboNombres;
    private javax.swing.JLabel IDLbl;
    private javax.swing.JTextField IDTxt;
    private javax.swing.JLabel PrecioLbl;
    private javax.swing.JButton RegresarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

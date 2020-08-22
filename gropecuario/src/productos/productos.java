/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import menu.Menu;

/**
 *
 * @author USER
 */
public class productos extends javax.swing.JFrame  {

    conectar con; // para crear la conexion
    PreparedStatement ps; // para decir lo que queremos hacer
    ResultSet rs; // aqui se guarda el resutlado de la conexion
    Connection cone = null; // para poder interacturar con la conexion
    boolean consultar = true;
    int contador = 0;
    private List<JLabel> nombres;
    private List<JLabel> ids;
    private List<JLabel> precios;
    private List<JLabel> cantidades;
    private List<JButton> botones;
    Menu men;

    public productos() {
        initComponents();
        con = new conectar(); // esto hace la conexion con la base
        Connection reg = con.getConnection(); // hace la conexion con la base 
        nombres = new ArrayList<>(); // la lista donde vamos a poner lso nombres
        ids = new ArrayList<>(); // la lista donde vamos a poner lso nombres
        precios = new ArrayList<>(); // la lista donde vamos a poner lso nombres
        cantidades = new ArrayList<>(); // la lista donde vamos a poner lso nombres
        botones = new ArrayList<>();

        try {
            cone = con.getConnection(); // abrimos la conexion
            ps = cone.prepareStatement("SELECT * FROM productos"); // decimos que queremos hacer
            rs = ps.executeQuery(); // hacemos lo anterior

            while (rs.next()) { // recorremos toda la lista

                System.out.println(rs.getString("Nombre")); // imprimimos la columna Nombre de la BD
                JLabel nom = new JLabel(rs.getString("Nombre"));
                JLabel id = new JLabel(rs.getString("ID"));
                JLabel precio = new JLabel(rs.getString("Precio"));
                JLabel cantidad = new JLabel(rs.getString("Cantidad"));
                JButton btn = new JButton ("Usar");
                panel.add(nom); // agregamos la label al panel
                nombres.add(nom); // agregamos la label a la lista de nombres
                panel.add(id);
                ids.add(id);
                panel.add(precio);
                precios.add(precio);
                panel.add(cantidad);
                cantidades.add(cantidad);
                botones.add(btn);
                panel.add(btn);
                panel.updateUI();// actualizamos la UI para que aparezca
                
                btn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    NombreTxt.setText(nom.getText());
                    IDTxt.setText(id.getText());
                    PrecioTxt.setText(precio.getText());
                    CantidadTxt.setText(cantidad.getText());
                    IDTxt.setEditable(false);
                    }
                
                });
                
                

            }// fin del while

        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NombreLbl = new javax.swing.JLabel();
        IDLbl = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        CantidadLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        NombreTxt = new javax.swing.JTextField();
        IDTxt = new javax.swing.JTextField();
        PrecioTxt = new javax.swing.JTextField();
        CantidadTxt = new javax.swing.JTextField();
        ConsularBtn = new javax.swing.JButton();
        EliminarBtn = new javax.swing.JButton();
        AnadirBtn = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        LimpiarBtn = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Productos");

        NombreLbl.setText("Nombre");

        IDLbl.setText("ID");

        Precio.setText("Precio");

        CantidadLbl.setText("Cantidad");

        panel.setLayout(new java.awt.GridLayout(0, 5));
        jScrollPane1.setViewportView(panel);

        IDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IDTxtMouseClicked(evt);
            }
        });

        ConsularBtn.setText("Consultar");
        ConsularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsularBtnActionPerformed(evt);
            }
        });

        EliminarBtn.setText("Eliminar");
        EliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBtnActionPerformed(evt);
            }
        });

        AnadirBtn.setText("Añadir");
        AnadirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirBtnActionPerformed(evt);
            }
        });

        EditarBtn.setText("Editar");
        EditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBtnActionPerformed(evt);
            }
        });

        LimpiarBtn.setText("Limpiar");
        LimpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarBtnActionPerformed(evt);
            }
        });

        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreLbl)
                            .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(IDLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Precio)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(CantidadLbl))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ConsularBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(AnadirBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EditarBtn))
                            .addComponent(LimpiarBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliminarBtn)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegresarBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LimpiarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLbl)
                    .addComponent(IDLbl)
                    .addComponent(Precio)
                    .addComponent(CantidadLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsularBtn)
                    .addComponent(AnadirBtn)
                    .addComponent(EditarBtn)
                    .addComponent(EliminarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegresarBtn))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsularBtnActionPerformed
        // TODO add your handling code here:
        // consultar = !consultar;

        String nombre = "%%%%";
        this.Precio.setVisible(true);
        this.PrecioTxt.setVisible(true);
        this.NombreLbl.setVisible(true);
        this.NombreTxt.setVisible(true);
        this.CantidadLbl.setVisible(true);
        this.CantidadTxt.setVisible(true);
        if (this.IDTxt.getText().equals("")) {
            this.IDTxt.setEditable(true);
        } else {
            this.IDTxt.setEditable(false);
        }
        Connection cone = null;
        int res;
        cone = this.con.getConnection();

        try { // este try es lo que le mete los datos a los recuadros para poder editar los datos
            if (!this.IDTxt.getText().equals("") ) {
                ps = cone.prepareStatement("SELECT * FROM productos WHERE ID=?"); // seleccionamos todo donde el ID sea igual al introducido
                ps.setString(1, this.IDTxt.getText()); // como tiene ? en esta linea se quita ? y se pone el introducido
                rs = ps.executeQuery(); //ejecutar
                rs.next();
                this.NombreTxt.setText(rs.getString("Nombre"));
                this.PrecioTxt.setText(rs.getString("Precio"));
                this.CantidadTxt.setText(rs.getString("Cantidad"));
                

            }

            if (this.IDTxt.getText().equals("") && !this.NombreTxt.getText().equals("")) {
                ps = cone.prepareStatement("SELECT * FROM productos WHERE Nombre LIKE ?");
                //se concatenan por que para SQL %%%% es que puede ir lo que sea asi que nos regresa todo lo parecido
                ps.setString(1, nombre.concat(this.NombreTxt.getText().concat("%%%%%%%%%%%%%%%%%%%")));
                rs = ps.executeQuery();

            }
            this.panel.removeAll();
            while (rs.next()) {

                System.out.println(rs.getString("Nombre")); // imprimimos la columna Nombre de la BD
                JLabel nom = new JLabel(rs.getString("Nombre"));
                JLabel id = new JLabel(rs.getString("ID"));
                JLabel precio = new JLabel(rs.getString("Precio"));
                JLabel cantidad = new JLabel(rs.getString("Cantidad"));
                JButton btn = new JButton ("Usar");
                panel.add(nom); // agregamos la label al panel
                nombres.add(nom); // agregamos la label a la lista de nombres
                panel.add(id);
                ids.add(id);
                panel.add(precio);
                precios.add(precio);
                panel.add(cantidad);
                cantidades.add(cantidad);
                contador++;
                botones.add(btn);
                panel.add(btn);
                panel.updateUI();// actualizamos la UI para que aparezca
                
                btn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    NombreTxt.setText(nom.getText());
                    IDTxt.setText(id.getText());
                    PrecioTxt.setText(precio.getText());
                    CantidadTxt.setText(cantidad.getText());
                    IDTxt.setEditable(false);
                    }
                
                });
                
                

                //  }// fin del while
            }

            if (this.IDTxt.getText().equals("")) {
                this.NombreTxt.setText("");
                this.IDTxt.setText("");
                this.PrecioTxt.setText("");
                this.CantidadTxt.setText("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_ConsularBtnActionPerformed

    
    private void EliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBtnActionPerformed
        // TODO add your handling code here:
        Connection cone = null;
        int res;
        try {
            //INCIA PARTE PARA ELIMINAR
            cone = this.con.getConnection();
            ps = cone.prepareStatement("DELETE FROM productos WHERE ID=?");
            ps.setInt(1, Integer.parseInt(this.IDTxt.getText()));
            res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
            //TERMINA PARTE PARA ELIMINAR 

            //INICIA PARTE PARA ACTUALIZAR 
            this.limpiar();
            //TERMINA PARTE PARA ACTUALIZAR
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EliminarBtnActionPerformed

    private void AnadirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirBtnActionPerformed

        Connection cone = null;
        try {
            cone = this.con.getConnection();
            ps = cone.prepareStatement("INSERT INTO productos (Nombre,Precio,Cantidad) VALUES (?,?,?)");
            //como el ID es autoincremental no se ocupa llenar
            ps.setString(1, this.NombreTxt.getText());
            ps.setInt(2, Integer.parseInt(this.PrecioTxt.getText()));
            ps.setInt(3, Integer.parseInt(this.CantidadTxt.getText()));
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado con exito");
                this.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se puedo Agregar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AnadirBtnActionPerformed

    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
        Connection cone = null;
        int res;
        cone = this.con.getConnection();
        try {
            // PARTE PARA EDITAR
            ps = cone.prepareStatement("UPDATE productos SET Nombre=?,ID=?,Precio=?,Cantidad=? WHERE ID=?");
            ps.setString(1, this.NombreTxt.getText());
            ps.setInt(2, Integer.parseInt(this.IDTxt.getText()));
            ps.setInt(3, Integer.parseInt(this.PrecioTxt.getText()));
            ps.setInt(4, Integer.parseInt(this.CantidadTxt.getText()));
            ps.setInt(5, Integer.parseInt(this.IDTxt.getText()));
            res = ps.executeUpdate();

            //TERMINA PARTE PARA EDITAR
            //PARTE PARA ACTUALIZAR LA INFORMACION
            this.limpiar();
            //TERMINA PARTE PARA ACTUALIZAR

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado");

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EditarBtnActionPerformed

    private void IDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IDTxtMouseClicked
        // TODO add your handling code here:
        if (!this.IDTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puedes modificar el ID de un producto");
        }
    }//GEN-LAST:event_IDTxtMouseClicked

    private void LimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarBtnActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_LimpiarBtnActionPerformed

    private void RegresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBtnActionPerformed

        this.setVisible(false);
        men = new Menu();
        men.setVisible(true);
    }//GEN-LAST:event_RegresarBtnActionPerformed

    public void limpiar() {
        this.NombreTxt.setText("");
        this.IDTxt.setText("");
        this.PrecioTxt.setText("");
        this.CantidadTxt.setText("");
        this.IDTxt.setEditable(true);
        
        
        this.panel.removeAll();
        try {
            ps = cone.prepareStatement("SELECT * FROM productos"); // decimos que queremos hacer
            rs = ps.executeQuery(); // hacemos lo anterior

            while (rs.next()) { // recorremos toda la lista

                System.out.println(rs.getString("Nombre")); // imprimimos la columna Nombre de la BD
                JLabel nom = new JLabel(rs.getString("Nombre"));
                JLabel id = new JLabel(rs.getString("ID"));
                JLabel precio = new JLabel(rs.getString("Precio"));
                JLabel cantidad = new JLabel(rs.getString("Cantidad"));
                JButton btn = new JButton ("Usar");
                panel.add(nom); // agregamos la label al panel
                nombres.add(nom); // agregamos la label a la lista de nombres
                panel.add(id);
                ids.add(id);
                panel.add(precio);
                precios.add(precio);
                panel.add(cantidad);
                cantidades.add(cantidad);
                contador++;
                botones.add(btn);
                panel.add(btn);
                panel.updateUI();// actualizamos la UI para que aparezca
                
                btn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    NombreTxt.setText(nom.getText());
                    IDTxt.setText(id.getText());
                    PrecioTxt.setText(precio.getText());
                    CantidadTxt.setText(cantidad.getText());
                    IDTxt.setEditable(false);
                    }
                
                });

            }// fin del while
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnadirBtn;
    private javax.swing.JLabel CantidadLbl;
    private javax.swing.JTextField CantidadTxt;
    private javax.swing.JButton ConsularBtn;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JLabel IDLbl;
    private javax.swing.JTextField IDTxt;
    private javax.swing.JButton LimpiarBtn;
    private javax.swing.JLabel NombreLbl;
    private javax.swing.JTextField NombreTxt;
    private javax.swing.JLabel Precio;
    private javax.swing.JTextField PrecioTxt;
    private javax.swing.JButton RegresarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    
    
}

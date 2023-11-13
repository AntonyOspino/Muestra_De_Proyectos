/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIpackage;

import conexiones.ConexionBD;
import conexiones.Proyecto;
import conexiones.Usuario;
import conexiones.Opiniones;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejo
 */
public class AdministrativoGUI extends javax.swing.JFrame {
   int x,y;
    ConexionBD con = new ConexionBD();
    private Usuario user = null;
    private ArrayList<Proyecto> lp;
    String [] notas = {"1","2","3","4","5"};
    boolean wasEmpty = true;
    /**
     * Creates new form vistaAdministrativoGUI
     */
    public AdministrativoGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public AdministrativoGUI(Usuario user){
        initComponents();
        this.setLocationRelativeTo(null);
        resetComboProyecto(cmbProyecto, "Seleccione un proyecto");
        resetComboNotas(cmbNota,"Seleccione su nota");
        this.user=user;
        cmbProyecto.addActionListener((ActionEvent e) -> {
        String proyectoSeleccionado = (String) cmbProyecto.getSelectedItem();

    if (!(proyectoSeleccionado.equals("Seleccione un proyecto"))) {
        con.ConectarBD();
        Proyecto proyecto = obtenerInformacionProyecto(proyectoSeleccionado);
        actualizarTextArea(proyecto);

        // Obtener y mostrar la opinión existente si la hay
        int idProyecto = con.ObtenerIdProyecto(proyectoSeleccionado);
        int idUsuario = user.getId();
        Opiniones opinion = con.obtenerOpinion(idProyecto, idUsuario);

        if (opinion != null) {
            cmbNota.setSelectedItem(String.valueOf(opinion.getNota()));
            txtAreaComentario.setText(opinion.getOpinion());
            wasEmpty=false;
        } else {
            cmbNota.setSelectedIndex(0); // Selecciona "Seleccione su nota"
            txtAreaComentario.setText(""); // Limpia el JTextArea
            wasEmpty=true;
        }

        con.DesconectarBD();
    } else {
        txtAreaProyecto.setText("");
        // Resetear los componentes si se selecciona "Seleccione un proyecto"
        resetearComponentes();
    }
        });
    }
    
    private Proyecto obtenerInformacionProyecto(String nombreProyecto) {
    // Iterar sobre la lista de proyectos para encontrar el seleccionado
    for (Proyecto p : lp) {
        if (p.getNombreProyecto().equals(nombreProyecto)) {
            return p;
        }
    }
    return null; // Devolver null si no se encuentra el proyecto
}

 private void resetComboProyecto(JComboBox<String> combo, String info){
    combo.removeAllItems();
    con.ConectarBD();
    lp = con.obtenerProyectosConDetalles();
    combo.addItem(info);
    for(Proyecto p : lp){
    combo.addItem(p.getNombreProyecto());
    }
    con.DesconectarBD();
    }
    
    private void resetComboNotas(JComboBox<String> combo, String info){
    combo.removeAllItems();
    combo.addItem(info);
    for(String nota :notas){
    combo.addItem(nota);
    }
    }
    
     private void actualizarTextArea(Proyecto proyecto) {
        // Mostrar la información en el JTextArea
        txtAreaProyecto.setText(""+ proyecto.getDescripcionProyecto()+"\nfuncionalidad: "+proyecto.getFuncionalidad()+ "\nIntegrantes: " + proyecto.getIntegrantesProyectos()+"\nCarrera: "+proyecto.getCarrera()+"\nSemestre: "+proyecto.getSemestre());
    }
     
    private void resetearComponentes() {
    cmbProyecto.setSelectedIndex(0); // Selecciona "Seleccione un proyecto"
    cmbNota.setSelectedIndex(0); // Selecciona "Seleccione su nota"
    txtAreaComentario.setText(""); // Limpia el JTextArea
}
    
    private int mostrarDialogoPregunta(String mensaje) {
    return JOptionPane.showOptionDialog(
            null,
            mensaje,
            "ADMINISTRACION DE PROYECTOS",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"SÍ", "NO"},
            "NO"
    );
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnGuardarOpinion = new javax.swing.JButton();
        cmbProyecto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaProyecto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbNota = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaComentario = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(51, 51, 51));
        btnSalir.setText("SALIR");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 140, 40));

        btnGuardarOpinion.setBackground(new java.awt.Color(0, 204, 205));
        btnGuardarOpinion.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnGuardarOpinion.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardarOpinion.setText("GUARDAR");
        btnGuardarOpinion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarOpinion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarOpinionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarOpinionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarOpinionMouseExited(evt);
            }
        });
        jPanel1.add(btnGuardarOpinion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, 140, 40));

        cmbProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 180, -1));

        txtAreaProyecto.setEditable(false);
        txtAreaProyecto.setColumns(20);
        txtAreaProyecto.setLineWrap(true);
        txtAreaProyecto.setRows(5);
        txtAreaProyecto.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAreaProyecto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 440, 260));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROYECTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 160, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOTA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 180, 20));

        cmbNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNotaActionPerformed(evt);
            }
        });
        jPanel1.add(cmbNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 180, -1));

        txtAreaComentario.setColumns(20);
        txtAreaComentario.setLineWrap(true);
        txtAreaComentario.setRows(5);
        txtAreaComentario.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtAreaComentario);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 280, 260));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 150, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADMINISTRACION DE PROYECTOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 810, 50));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img-login.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 600));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        pnlExit.setBackground(new java.awt.Color(255, 255, 255));

        btnExit.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(51, 51, 51));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(1047, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Opinion del proyecto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 240, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Detalles del proyecto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 440, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 610, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            if(user.getIdPerfil() == 1){
            JOptionPane.showMessageDialog(this, "¡¡ Hasta La Proxima Sr(a) "+user.getNombre()+" !!", "CREACION DE PROYECTOS", JOptionPane.INFORMATION_MESSAGE);
            new AdministradorGUI(user).setVisible(true);
            this.dispose();
        }
        
            if(user.getIdPerfil() == 2){
                JOptionPane.showMessageDialog(this, "¡¡ Hasta La Proxima Sr(a) "+user.getNombre()+" !!", "CREACION DE PROYECTOS", JOptionPane.INFORMATION_MESSAGE);
                new loginGUI().setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        this.setLocation(evt.getXOnScreen()-x, evt.getYOnScreen()-y);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
         pnlExit.setBackground(Color.red);
         btnExit.setForeground(Color.white);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        pnlExit.setBackground(Color.white);
        btnExit.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void cmbNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNotaActionPerformed

    private void btnGuardarOpinionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarOpinionMouseClicked
        
    String proyectoSeleccionado = (String) cmbProyecto.getSelectedItem();
    String notaSeleccionada = (String) cmbNota.getSelectedItem();
    String opinion = txtAreaComentario.getText();

   
    if (proyectoSeleccionado.equals("Seleccione un proyecto") || notaSeleccionada.equals("Seleccione su nota") || opinion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un proyecto y una nota, escriba su opinión antes de poder guardar.","ADMINISTRACION DE PROYECTOS",0);
        return;
    }
    int opcion;
    if(wasEmpty){
    opcion = mostrarDialogoPregunta("¿Desea ingresar su opinion?");
    }
    else{
    opcion = mostrarDialogoPregunta("¿Este proyecto ya posee una opinion suya ¿desea actualizarla?");
    }
    if(opcion == JOptionPane.YES_OPTION){
    con.ConectarBD();
 
    int idProyecto = con.ObtenerIdProyecto(proyectoSeleccionado);
        
    int idUsuario = user.getId();
       
    con.DesconectarBD();
        
  
    con.ConectarBD();
       
    con.insertarActualizarOpinion(idProyecto, idUsuario, notaSeleccionada, opinion);
      
    con.DesconectarBD();
       

    // Resetear los componentes después de guardar la opinión
    JOptionPane.showMessageDialog(this, "registro guardado de manera exitosa", "INFORMACION",1);
    resetearComponentes();
   }
    
    }//GEN-LAST:event_btnGuardarOpinionMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(new Color(255,55,102));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnGuardarOpinionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarOpinionMouseEntered
        btnGuardarOpinion.setBackground(new Color(0,150,205));
    }//GEN-LAST:event_btnGuardarOpinionMouseEntered

    private void btnGuardarOpinionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarOpinionMouseExited
        btnGuardarOpinion.setBackground(new Color(0,204,205));
    }//GEN-LAST:event_btnGuardarOpinionMouseExited

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
            java.util.logging.Logger.getLogger(AdministrativoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrativoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrativoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrativoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrativoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnGuardarOpinion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbNota;
    private javax.swing.JComboBox<String> cmbProyecto;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JTextArea txtAreaComentario;
    private javax.swing.JTextArea txtAreaProyecto;
    // End of variables declaration//GEN-END:variables
}

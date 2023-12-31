package GUIpackage;

import conexiones.ConexionBD;
import conexiones.Proyecto;
import conexiones.Usuario;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejo
 */
public class UsuarioGUI extends javax.swing.JFrame {
    
    private Usuario usuario = null;
    int x,y ;
    Proyecto proy = new Proyecto();
    ConexionBD con = new ConexionBD();
    
    /**
     * Creates new form vistaUsuarioGUI
     */
    public UsuarioGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.cargarCarreras();
        this.cargarFuncionalidad();
        JOptionPane.showMessageDialog(this,"Al Momento De Escribir Los Integrantes Del Proyecto\nSeparelos Por Una Coma  =>  ',' ","RECOMENDACION",1);
    }
    
    public UsuarioGUI(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.cargarCarreras();
        this.cargarFuncionalidad();
        this.usuario = usuario;
        JOptionPane.showMessageDialog(this,"Al Momento De Escribir Los Integrantes Del Proyecto\nSeparelos Por Una Coma  =>  ',' ","RECOMENDACION",1);
    }
    
    private boolean camposVacios() {
    // Verifica si alguno de los campos está vacío o sin marcar
    return this.txtNombreProyecto.getText().isEmpty() ||
           this.txtDescripcionProyecto.getText().isEmpty() ||
           this.txtIntegrantes.getText().isEmpty() ||
           this.cmbCarrera.getSelectedItem() == null ||
            this.cmbFuncionalidad.getSelectedItem() == null;
    }
    
    public void cargarCarreras(){
        try {
            ConexionBD bd = new ConexionBD();
            bd.ConectarBD();
            ResultSet res = bd.ConsultaBD("SELECT *  FROM carrera WHERE estado = 'ACTIVO' ");
            this.cmbCarrera.removeAllItems();
            while(res.next()){
                cmbCarrera.addItem(res.getString("nombre"));
            }
            bd.DesconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarFuncionalidad(){
        try {
            ConexionBD bd = new ConexionBD();
            bd.ConectarBD();
            ResultSet res = bd.ConsultaBD("SELECT *  FROM funcionalidad WHERE estado = 'ACTIVO' ");
            this.cmbFuncionalidad.removeAllItems();
            while(res.next()){
                cmbFuncionalidad.addItem(res.getString("nombre"));
            }
            bd.DesconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void resetearValores(){
        this.txtNombreProyecto.setText("");
        this.txtIntegrantes.setText("");
        this.cmbCarrera.setSelectedIndex(0);
        this.cmbSemestre.setSelectedIndex(0);
        this.cmbFuncionalidad.setSelectedIndex(0);
        this.txtDescripcionProyecto.setText("");
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
        btnSalir2 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        imgUsuario = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbFuncionalidad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombreProyecto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionProyecto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtIntegrantes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cmbCarrera = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbSemestre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir2.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnSalir2.setForeground(new java.awt.Color(51, 51, 51));
        btnSalir2.setText("SALIR");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalir2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalir2MouseExited(evt);
            }
        });
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 204, 205));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 130, 40));

        imgUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imgUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img-usuario.jpg"))); // NOI18N
        jPanel1.add(imgUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 600));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        pnlExit.setBackground(new java.awt.Color(255, 255, 255));

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setText("X");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExitLayout.createSequentialGroup()
                .addComponent(btnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(753, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(pnlExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 28));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre Del Proyecto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jPanel1.add(cmbFuncionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Funcionalidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 160, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 200, 10));

        txtNombreProyecto.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreProyecto.setBorder(null);
        jPanel1.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 190, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 128, 114, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Descripcion Del Proyecto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        txtDescripcionProyecto.setColumns(20);
        txtDescripcionProyecto.setLineWrap(true);
        txtDescripcionProyecto.setRows(5);
        txtDescripcionProyecto.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(txtDescripcionProyecto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 440, 160));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Integrantes Del Proyecto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 200, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 470, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CREACION DE PROYECTOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 530, -1));

        txtIntegrantes.setColumns(20);
        txtIntegrantes.setLineWrap(true);
        txtIntegrantes.setRows(5);
        txtIntegrantes.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(txtIntegrantes);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 200, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Semestre En Curso");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 160, -1));

        jPanel1.add(cmbCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 200, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Carrera En Formacion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 160, -1));

        cmbSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanel1.add(cmbSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        pnlExit.setBackground(Color.red);
        btnSalir.setForeground(Color.white);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:
        pnlExit.setBackground(Color.white);
        btnSalir.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_btnSalirMouseExited

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        // TODO add your handling code here:
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        // TODO add your handling code here:
        this.setLocation(evt.getXOnScreen()-x,evt.getYOnScreen()-y);
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if( this.camposVacios() ){
            JOptionPane.showMessageDialog(this," Todos Los Campos \n Deben Ser Llenados O Marcados ","CREACION DE PROYECTOS",0);
        }else{
            int opcion = JOptionPane.showOptionDialog(this, "¿Desea guardar este proyecto?", "CREACION DE PROYECTOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "NO");

            // Verificar la opción seleccionada por el usuario
            if (opcion == JOptionPane.YES_OPTION) {
                
                ConexionBD con = new ConexionBD();
                con.ConectarBD();
                if(con.ValidarProyecto(this.txtNombreProyecto.getText())){
                    JOptionPane.showMessageDialog(this,"Nombre De Proyecto Ya Existe","CREACION DE PROYECTOS",0);
                }else{
                    String carrera = (String)cmbCarrera.getSelectedItem();
                    String funcionalidad = (String)cmbFuncionalidad.getSelectedItem();
                    int semestre = Integer.parseInt(((String)cmbSemestre.getSelectedItem()));
                    
                    con.InsertarProyecto(txtNombreProyecto.getText(), txtIntegrantes.getText(), carrera, funcionalidad, txtDescripcionProyecto.getText(), semestre, usuario);
                    JOptionPane.showMessageDialog(this, "Proyecto guardado exitosamente", "CREACION DE PROYECTOS", JOptionPane.INFORMATION_MESSAGE);
                    this.resetearValores();
                }
                con.DesconectarBD();
            } 
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
        try {
            //primer es solo de prueba ejecutando solo el GUI de Usuario sin el login
//            if(usuario == null){
//            JOptionPane.showMessageDialog(this, "¡¡Hasta La Proxima null!!", "CREACION DE PROYECTOS", JOptionPane.INFORMATION_MESSAGE);
//            this.dispose();
//            }
            
            if(usuario.getIdPerfil() == 1){
                JOptionPane.showMessageDialog(this, "¡¡ Hasta La Proxima Sr(a) "+usuario.getNombre()+" !!", "CREACION DE PROYECTOS", JOptionPane.INFORMATION_MESSAGE);
                new AdministradorGUI(usuario).setVisible(true);
                this.dispose();
            }
        
            if(usuario.getIdPerfil() == 3 || usuario.getIdPerfil() == 2){
                JOptionPane.showMessageDialog(this, "¡¡ Hasta La Proxima Sr(a) "+usuario.getNombre()+" !!", "CREACION DE PROYECTOS", JOptionPane.INFORMATION_MESSAGE);
                new loginGUI().setVisible(true);
                this.dispose();
            }  
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        // TODO add your handling code here:
        btnGuardar.setBackground(new Color(0,150,205));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        // TODO add your handling code here:
        btnGuardar.setBackground(new Color(0,204,205));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnSalir2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir2MouseEntered
        // TODO add your handling code here:
        btnSalir2.setBackground(new Color(255,55,102));
    }//GEN-LAST:event_btnSalir2MouseEntered

    private void btnSalir2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir2MouseExited
        // TODO add your handling code here:
        btnSalir2.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_btnSalir2MouseExited

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
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JComboBox<String> cmbFuncionalidad;
    private javax.swing.JComboBox<String> cmbSemestre;
    private javax.swing.JLabel imgUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTextArea txtDescripcionProyecto;
    private javax.swing.JTextArea txtIntegrantes;
    private javax.swing.JTextField txtNombreProyecto;
    // End of variables declaration//GEN-END:variables
}

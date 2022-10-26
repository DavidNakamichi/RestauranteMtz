
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.lang.NullPointerException;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author vch_92
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Crea un nuevo marco de formulario
     */
    // declarando una nueva instancia de nuestra clase de base de datos
    database a  = new database();
    //Declarando una nueva instancia de clases
    Employee e = new Employee();
    //Creando un número aleatorio para ser usado como número de empleado
    Random rand = new Random();
    int x = rand.nextInt(10000);
    DefaultTableModel model;
    public Frame() {
        initComponents();

        model = (DefaultTableModel) tblEmployees.getModel();
        //llamar al método que llenará las tablas tras la inicialización
        populateTable();
        btnAddR.setEnabled(false);
        btnDelete.setEnabled(false);
        
     txtPPSN.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtFirstName.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtLastName.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtWage.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtPosition.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    }
    //poblar la tabla
    public void populateTable()
    {
        // variables de calcomanía
        int EmployeeID;
        String FirstName;
        String LastName;
        String PPSN;
        String Wages;
        String Position;
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();// crea y ejecuta sentencia sql
            ResultSet results = a.stmt.executeQuery("select * from " + a.tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            
            
            while(results.next())
            {              
            //Rellena la tabla hasta que llega al final de la base de datos
            EmployeeID = results.getInt(1);
            FirstName = results.getString(2);
            LastName = results.getString(3);
            PPSN = results.getString(4);
            Wages = results.getString(5);
            Position = results.getString(6);
            model.insertRow(model.getRowCount(), new Object[]{EmployeeID, FirstName, LastName, PPSN, Wages, Position});
            r++;
            }//fin del ciclo while
            // cierra y 'cierra cualquier transmisión y conexión abierta
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        }
              
    }
    
    
    
    
    
        
    //método para insertar empleado en la base de datos
     private void insertEmployee(Employee e)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();//crea y ejecuta declaraciones para llenar la tabla de la base de datos
            a.stmt.execute("insert into " + a.tableName + " values (" +
                    x +  ",'" + e.getFirstName() + "','" + e.getLastName() + "','" + e.getPPSN() + "','" + e.getWage() + "','" + e.getPosition() + "')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
     
        //método utilizado en el detector de documentos con fines de validación
      public void lengthCheck(){
          if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtPPSN.getText().equals("")|| txtWage.getText().equals("")||txtPosition.getText().equals("")){
              btnAddR.setEnabled(false);
              btnDelete.setEnabled(false);
          }
          else if(txtFirstName.getText().length()> 50 || txtLastName.getText().length()>50 || txtPPSN.getText().length()>10|| txtWage.getText().length()>10||txtPosition.getText().length()>30){
               btnAddR.setEnabled(false);
          }
          else{
               btnAddR.setEnabled(true);
          }
      }
      
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtPPSN = new javax.swing.JTextField();
        txtWage = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        btnAddR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUnSelect = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 22, 239, -1));
        getContentPane().add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 60, 239, -1));
        getContentPane().add(txtPPSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 22, 130, -1));
        getContentPane().add(txtWage, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 60, 130, -1));
        getContentPane().add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 98, 439, -1));

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "Nombre", "Apellido", "CURP", "Sueldo Mensual", "Puesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployees.getTableHeader().setReorderingAllowed(false);
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 136, 670, 160));

        btnAddR.setBackground(new java.awt.Color(255, 255, 255));
        btnAddR.setText("Agregar");
        btnAddR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 110, 25));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sueldo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 63, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CURP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 25, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puesto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 101, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellidos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 63, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre(s)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 25, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 110, 25));

        btnUnSelect.setBackground(new java.awt.Color(255, 255, 255));
        btnUnSelect.setText("Deseleccionar");
        btnUnSelect.setToolTipText("Use this to unselect \na row from the table");
        btnUnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(btnUnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 110, 25));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 110, 25));

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Editar Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 110, 25));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blur-lights-restaurant-blurred-background-orange-red-light-blue-green-pink-bokeh-192182748.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRActionPerformed

        model.insertRow(model.getRowCount(), new Object[]{x, txtFirstName.getText(), txtLastName.getText(), txtPPSN.getText(), txtWage.getText(), txtPosition.getText()});
        //Obtiene información de los campos de texto que se usarán para llenar la tabla de la base de datos
        e.setFirstName(txtFirstName.getText());
        e.setLastName(txtLastName.getText());
        e.setPPSN(txtPPSN.getText());
        e.setWage(txtWage.getText());
        e.setPosition(txtPosition.getText());
        
        //borra campos de texto
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtPPSN.setText(null);
        txtWage.setText(null);
        txtPosition.setText(null);
        //llama al método para insertar valores en la base de datos
        insertEmployee(e);
      
        x++;
                
        
    }//GEN-LAST:event_btnAddRActionPerformed
    
    
    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        
    }//GEN-LAST:event_txtFirstNameActionPerformed
  
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //estableciendo la fila seleccionada de la tabla
        int row = tblEmployees.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)tblEmployees.getModel();
        // Establece la variable seleccionada igual al primer valor en la fila seleccionada y la establece en una cadena
        String selected = tblEmployees.getValueAt(row, 3).toString();
        
            
        
        if (row >= 0) {
           
            model.removeRow(row);
        try{
            a.createConnection();// crea la conexion
            //prepara la declaración para eliminar la fila de la base de datos
            PreparedStatement ps = a.conn.prepareStatement("delete from Employee_Table where PPSN='"+selected+"' ");
            ps.executeUpdate();
           
            txtFirstName.setText(null);
            txtLastName.setText(null);
            txtPPSN.setText(null);
            txtWage.setText(null);
            txtPosition.setText(null);
            JOptionPane.showMessageDialog(null, "Empleado Eliminado");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        //Establecer fila igual a la fila seleccionada
        int row = tblEmployees.getSelectedRow();
        
        String selected = tblEmployees.getValueAt(row, 3).toString();
        DefaultTableModel model= (DefaultTableModel)tblEmployees.getModel();
        try{
        if(selected !=null ){
           //muestra información de la fila seleccionada en campos de texto
            txtFirstName.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 1)));
            txtLastName.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 2)));
            txtPPSN.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 3)));
            txtWage.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 4)));
            txtPosition.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 5)));
            btnDelete.setEnabled(true);
            btnAddR.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnUnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnSelectActionPerformed
      
        tblEmployees.getSelectionModel().clearSelection();
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtPPSN.setText(null);
        txtWage.setText(null);
        txtPosition.setText(null);
    }//GEN-LAST:event_btnUnSelectActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuEditor me = new MenuEditor();
        me.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed


    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddR;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnUnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPPSN;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtWage;
    // End of variables declaration//GEN-END:variables
}

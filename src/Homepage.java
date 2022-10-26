
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class Homepage extends javax.swing.JFrame {
   // declarando nuestros modelos de tablas que pertenecen a estructuras de tablas
    DefaultTableModel model;
    DefaultTableModel model1;
    
   // declarando una nueva instancia de nuestra clase de base de datos
    database a =new database();
       // constructor inicial (llamará automáticamente al método de inicialización de componentes)     
    public Homepage() { 
        initComponents();
        
        btnRemoveOrder.setEnabled(false);
        // configurando nuestra información sobre herramientas
        btnRemoveOrder.setToolTipText("Seleccione una fila para eliminar, "
                 + "Esto eliminara las ordenes de la mesa");
        btnNewOrder.setToolTipText("Crear una nueva orden");
        btnAdmin.setToolTipText("Pantalla de administrador");
        //asignando el modelo de tabla predeterminado a nuestras dos tablas
        model = (DefaultTableModel) tblOrders.getModel();
        model1 = (DefaultTableModel) tblBill.getModel();
        //llamar al método que llenará las tablas tras la inicialización
        populateTable();
        populateTable1();
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblOrders.getModel());
        tblOrders.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 0;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        
        TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(tblBill.getModel());
        tblBill.setRowSorter(sorter1);
        List<RowSorter.SortKey> sortKeys1 = new ArrayList<>();
        int columnIndexToSort1 = 0;
        sortKeys1.add(new RowSorter.SortKey(columnIndexToSort1, SortOrder.ASCENDING));
        sorter1.setSortKeys(sortKeys1);
        sorter1.sort();
    }

    private void populateTable(){
        
        int OrderID;
        String Starter;
        String Main;
        String Dessert;
        String Drink;
        String Price;
        int r =0;
 
        try
        {
            
            a.createConnection();//crea conexión a la base de datos
            
           // crea y ejecuta una declaración sql para mostrar toda la información de la variable 'tablename2'
            a.stmt = a.conn.createStatement();
            ResultSet res = a.stmt.executeQuery("select * from " + a.tableName1);
            ResultSetMetaData rsmd = res.getMetaData();
            int numberCols = rsmd.getColumnCount();
            
            
            //el bucle se ejecutará siempre que haya más datos para leer de la base de datos, asignando los valores correspondientes en consecuencia
            while(res.next())
            {
                
            OrderID = res.getInt(1);
            Starter = res.getString(2);
            Main = res.getString(3);
            Dessert = res.getString(4);
            Drink = res.getString(5);
            Price = res.getString(6);
            
            
            //inserta una nueva fila en la tabla que contiene un objeto de pedido con las siguientes propiedades
            model.insertRow(model.getRowCount(), new Object[]{OrderID, Starter, Main, Dessert, Drink, Price});
           
            r++;
            }//finaliza el bucle while
            
            // cierra y 'cierra cualquier transmisión y conexión abierta
            res.close();
            a.stmt.close();
            a.shutdown();
            
            }//finalizar intento
        
        // mostrará la cláusula de captura apropiada si es necesario
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        }
    }
    
    
    private void populateTable1(){
         
        int OrderID;
        String Table;
        String Employee;
        String TotalPrice;
        int r =0;
 
        try
        {
            
            a.createConnection();//crea conexión a la base de datos
            
            // crea y ejecuta una declaración sql para mostrar toda la información de la variable 'tablename2'
            a.stmt = a.conn.createStatement();
            ResultSet res = a.stmt.executeQuery("select * from " + a.tableName2);
            
            ResultSetMetaData rsmd = res.getMetaData();
            int numberCols = rsmd.getColumnCount();
            
           //el bucle se ejecutará siempre que haya más datos para leer de la base de datos, asignando los valores correspondientes en consecuencia
            while(res.next())
            {
                
            OrderID = res.getInt(1);
            Table = res.getString(2);
            Employee = res.getString(3);
            TotalPrice = res.getString(4);
            
            
       
           //inserta una nueva fila en la tabla que contiene un objeto de pedido con las siguientes propiedades
            model1.insertRow(model1.getRowCount(), new Object[]{OrderID, Table, Employee, TotalPrice});
           
            r++;
            }//finaliza el bucle while
            
            // cierra y 'cierra cualquier transmisión y conexión abierta
            res.close();
            a.stmt.close();
            a.shutdown();
        }
        
        // mostrará la cláusula de captura apropiada si es necesario
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "Caracter invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnNewOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnRemoveOrder = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Orden", "No. Mesa", "Empleado", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.getTableHeader().setReorderingAllowed(false);
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBill);
        if (tblBill.getColumnModel().getColumnCount() > 0) {
            tblBill.getColumnModel().getColumn(0).setResizable(false);
            tblBill.getColumnModel().getColumn(1).setResizable(false);
            tblBill.getColumnModel().getColumn(2).setResizable(false);
            tblBill.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 560, 130));

        btnNewOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setText("Nueva Orden");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 25));

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Orden", "Entrada", "Platillo", "Postre", "Bebida", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.setGridColor(new java.awt.Color(255, 255, 255));
        tblOrders.setRowSelectionAllowed(false);
        tblOrders.getTableHeader().setReorderingAllowed(false);
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrders);
        if (tblOrders.getColumnModel().getColumnCount() > 0) {
            tblOrders.getColumnModel().getColumn(0).setResizable(false);
            tblOrders.getColumnModel().getColumn(1).setResizable(false);
            tblOrders.getColumnModel().getColumn(2).setResizable(false);
            tblOrders.getColumnModel().getColumn(3).setResizable(false);
            tblOrders.getColumnModel().getColumn(4).setResizable(false);
            tblOrders.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 560, 183));

        btnRemoveOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoveOrder.setText("Eliminar Orden");
        btnRemoveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 130, 25));

        btnAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnAdmin.setText("Administrador");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 120, 25));

        jLabel3.setBackground(new java.awt.Color(255, 153, 153));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Desglose Ordenes Activas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ordenes del día");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, -1));

        label1.setBackground(new java.awt.Color(255, 153, 102));
        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Bienvenido");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));
        label1.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blur-lights-restaurant-blurred-background-orange-red-light-blue-green-pink-bokeh-192182748.jpg"))); // NOI18N
        jLabel1.setName(""); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 690, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        
        Order o = new Order();
        o.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnRemoveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderActionPerformed
       
        int row = tblBill.getSelectedRow();//crea una variable de fila, la asigna a la fila actual
        
        String selected = tblBill.getValueAt(row, 0).toString();//asigna la variable seleccionada al ID de pedido seleccionado para fines de eliminación
        
            
        
        
        try{
            //crea una conexión, crea y ejecuta consultas sql para eliminar el pedido seleccionado de ambas tablas
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Price_Table where OrderID='"+selected+"' ");
            PreparedStatement ps1 = a.conn.prepareStatement("delete from ORDER_Table where OrderID='"+selected+"' ");
            ps.executeUpdate();
            ps1.executeUpdate();
            
            //crea dos variables para eliminar la fila actual a través de bucles
            int rowCount = model.getRowCount();
            int rowCount1 = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
            }
            for (int ii = rowCount1 - 1; ii >= 0; ii--) {
            model1.removeRow(ii);
            }
            
            //rellena las tablas volviendo a llamar a los métodos
            populateTable();
            populateTable1();
          //restringe la posibilidad de borrar una orden que no esta seleccionada
            btnRemoveOrder.setEnabled(false);
            //confirma la eliminación
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
        
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        
        
    }//GEN-LAST:event_btnRemoveOrderActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        
        btnRemoveOrder.setEnabled(true);
    }//GEN-LAST:event_tblBillMouseClicked
//permite la posibilidad de borrado habilitando el boton
    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
       //crea una nueva instancia del marco de la contraseña de administrador y la configura como visible  
        AdminPassword ap = new AdminPassword();
         ap.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        
    }//GEN-LAST:event_tblOrdersMouseClicked

    
    public static void main(String args[]) {
      
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnRemoveOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Panel panel1;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblOrders;
    // End of variables declaration//GEN-END:variables
}

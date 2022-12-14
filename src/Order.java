
import javax.swing.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;






/**
 *
 * @author vch_92
 */
public class Order extends javax.swing.JFrame {

    public double runningCost;
    public double rowCost;
    //Declarar una nueva instancia de clases
    Starter s = new Starter();
    Main m = new Main();
    Dessert ds = new Dessert();
    Drink dr = new Drink();
    TotalPrice p = new TotalPrice();
    Person_Order o = new Person_Order();
    //Declarar una nueva instancia de la clase de base de datos
    database a = new database();
    //Declarar una nueva instancia de clase aleatoria para usar como número de pedido
    Random rand = new Random();
    int x = rand.nextInt(10000);
    public String xx = Integer.toString(x);
    //declarando nuestros modelos de mesa que pertenecen a estructuras de mesa
    DefaultTableModel model;
    DefaultTableModel Startermodel;
    DefaultTableModel Mainmodel;
    DefaultTableModel Dessertmodel;
    DefaultTableModel Drinkmodel;
     
    public Order(){
        initComponents(); 
        //Esto evitará que el usuario salga del programa a mitad del proceso ya que  causará una inconsistencia en las tablas de la base de datos
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        txtRowCost.setVisible(false);
        Startermodel =  (DefaultTableModel) tblStarters.getModel();
        Mainmodel =     (DefaultTableModel) tblMains.getModel();
        Dessertmodel =  (DefaultTableModel) tblDesserts.getModel();
        Drinkmodel =    (DefaultTableModel) tblDrinks.getModel();
        txtFinish.setEnabled(false);
        btnDelete.setEnabled(false);
       
       
        model = (DefaultTableModel) tblOrder.getModel();
        
//llenar combobox con nombres de empleados
        fill();
        
//llenar tablas con información de la base de datos
        populateStarter();
        populateMain();
        populateDessert();
        populateDrink();
        txtTable.getDocument().addDocumentListener(new DocumentListener() {
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
        txtCost.getDocument().addDocumentListener(new DocumentListener() {
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
    
//método para comprobar el campo de texto para la validación
    public void lengthCheck(){
          if(txtCost.getText().equals("")||txtTable.getText().equals("")||txtCost.getText().equals("0.0")){
              txtFinish.setEnabled(false);
        
          }
          else{
                btnBack.setEnabled(false);
               txtFinish.setEnabled(true);
               
          }
      }
    // método para llenar el cuadro combinado con los nombres de los empleados
    private void fill(){
        try{
            a.createConnection();//crear la conexion
            cbxEmployees.removeAllItems();//eliminar items del combobox
            a.stmt = a.conn.createStatement();//crea una declaración para su ejecución
            ResultSet results = a.stmt.executeQuery("SELECT * from " + a.tableName);
       
           
        while(results.next()){ 
            //llena el combobox
            cbxEmployees.addItem(results.getString("First_Name"));
        }
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch(Exception c){
            c.printStackTrace();
            
        }
    }
    
    
    
    //orden de inserciones a tabla de la misma manera que las inserciones anteriores
    private void insertOrder(Person_Order o)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into ORDER_TABLE values ('" +
                    o.getOrderID() +  "','" + o.getStarter() + "','" + o.getMain() + "','" + o.getDessert() + "','" + o.getDrink() + "','" + o.getPrice() + "')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }   
    //inserta el pedido en tabla de la misma manera que las inserciones anteriores
    private void insertFinalOrder(TotalPrice p)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into Price_TABLE values ('" +
                p.getOrderID() +  "','" + p.getTableNum() + "','" + p.getEmployee() + "','" + p.getTotalPrice() + "')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }  
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStarterValue = new javax.swing.JTextField();
        txtMainValue = new javax.swing.JTextField();
        txtDessertValue = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtDrinkValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        cbxEmployees = new javax.swing.JComboBox();
        txtRowCost = new javax.swing.JTextField();
        txtFinish = new javax.swing.JButton();
        txtTable = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDrinks = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStarters = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMains = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDesserts = new javax.swing.JTable();
        txtStarterPrice = new javax.swing.JTextField();
        txtMainPrice = new javax.swing.JTextField();
        txtDessertPrice = new javax.swing.JTextField();
        txtDrinkPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStarterValue.setEditable(false);
        txtStarterValue.setText("-");
        getContentPane().add(txtStarterValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 369, 188, -1));

        txtMainValue.setEditable(false);
        txtMainValue.setText("-");
        txtMainValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMainValueActionPerformed(evt);
            }
        });
        getContentPane().add(txtMainValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 188, -1));

        txtDessertValue.setEditable(false);
        txtDessertValue.setText("-");
        getContentPane().add(txtDessertValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 431, 188, -1));

        txtCost.setEditable(false);
        txtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostActionPerformed(evt);
            }
        });
        getContentPane().add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 463, 134, -1));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 462, -1, 25));

        txtDrinkValue.setEditable(false);
        txtDrinkValue.setText("-");
        getContentPane().add(txtDrinkValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 463, 188, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("$");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 465, 15, -1));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Orden", "Entrada", "Platillo", "Postre", "Bebida", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.getTableHeader().setReorderingAllowed(false);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setMinWidth(50);
            tblOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblOrder.getColumnModel().getColumn(0).setMaxWidth(50);
            tblOrder.getColumnModel().getColumn(1).setMinWidth(120);
            tblOrder.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblOrder.getColumnModel().getColumn(1).setMaxWidth(120);
            tblOrder.getColumnModel().getColumn(2).setMinWidth(120);
            tblOrder.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblOrder.getColumnModel().getColumn(2).setMaxWidth(120);
            tblOrder.getColumnModel().getColumn(3).setMinWidth(120);
            tblOrder.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblOrder.getColumnModel().getColumn(3).setMaxWidth(120);
            tblOrder.getColumnModel().getColumn(4).setMinWidth(120);
            tblOrder.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblOrder.getColumnModel().getColumn(4).setMaxWidth(120);
            tblOrder.getColumnModel().getColumn(5).setMinWidth(70);
            tblOrder.getColumnModel().getColumn(5).setPreferredWidth(70);
            tblOrder.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 17, 597, 402));

        cbxEmployees.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmployeesActionPerformed(evt);
            }
        });
        getContentPane().add(cbxEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 369, 133, -1));
        getContentPane().add(txtRowCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 82, -1));

        txtFinish.setText("Terminar Orden");
        txtFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinishActionPerformed(evt);
            }
        });
        getContentPane().add(txtFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 490, 130, 25));
        getContentPane().add(txtTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 400, 133, -1));

        tblDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bebida", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDrinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDrinksMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDrinks);
        if (tblDrinks.getColumnModel().getColumnCount() > 0) {
            tblDrinks.getColumnModel().getColumn(1).setMinWidth(70);
            tblDrinks.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDrinks.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 189, 250, 154));

        tblStarters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entrada", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStarters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStartersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStarters);
        if (tblStarters.getColumnModel().getColumnCount() > 0) {
            tblStarters.getColumnModel().getColumn(1).setMinWidth(70);
            tblStarters.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblStarters.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, 250, 154));

        tblMains.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Platillo", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMains.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMains);
        if (tblMains.getColumnModel().getColumnCount() > 0) {
            tblMains.getColumnModel().getColumn(1).setMinWidth(70);
            tblMains.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblMains.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 17, 250, 154));

        tblDesserts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Postre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDesserts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDessertsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDesserts);
        if (tblDesserts.getColumnModel().getColumnCount() > 0) {
            tblDesserts.getColumnModel().getColumn(1).setMinWidth(70);
            tblDesserts.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDesserts.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, 250, 154));

        txtStarterPrice.setEditable(false);
        txtStarterPrice.setText("0.0");
        getContentPane().add(txtStarterPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 369, 54, -1));

        txtMainPrice.setEditable(false);
        txtMainPrice.setText("0.0");
        getContentPane().add(txtMainPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 400, 54, -1));

        txtDessertPrice.setEditable(false);
        txtDessertPrice.setText("0.0");
        getContentPane().add(txtDessertPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 431, 54, -1));

        txtDrinkPrice.setEditable(false);
        txtDrinkPrice.setText("0.0");
        getContentPane().add(txtDrinkPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 463, 54, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empleado");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 370, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No. Mesa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 401, -1, -1));

        btnDelete.setText("Eliminar Orden");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 490, 120, 25));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 90, 25));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGrestauranteMartinez.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 1150, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            
            //Esto se usa para sumar todos los costos y obtener un total
            String starter = txtStarterPrice.getText();           
            runningCost += Double.parseDouble(starter);
            rowCost += Double.parseDouble(starter);
            txtCost.setText(String.valueOf(runningCost));
            txtRowCost.setText(String.valueOf(rowCost));
            
            String main = txtMainPrice.getText();
            runningCost += Double.parseDouble(main);
            rowCost += Double.parseDouble(main);
            txtCost.setText(String.valueOf(runningCost));
            txtRowCost.setText(String.valueOf(rowCost));
            
            
            String d = txtDessertPrice.getText();
            runningCost += Double.parseDouble(d);
            rowCost += Double.parseDouble(d);
            txtCost.setText(String.valueOf(runningCost));
            txtRowCost.setText(String.valueOf(rowCost));
            

            String drink = txtDrinkPrice.getText();
            runningCost += Double.parseDouble(drink);
            rowCost += Double.parseDouble(drink);
            txtCost.setText(String.valueOf(runningCost));
            txtRowCost.setText(String.valueOf(rowCost));
        
        btnBack.setEnabled(false);
        String rowCost1 = Double.toString(rowCost);
        o.setOrderId(xx);
        o.setStarter(txtStarterValue.getText());
        o.setMain(txtMainValue.getText());
        o.setDessert(txtDessertValue.getText());
        o.setDrink(txtDrinkValue.getText());
      
        o.setPrice(rowCost1);
        insertOrder(o);
        
       //Esto crea la tabla en la que se colocan los pedidos de comida y su precio.
        model.insertRow(model.getRowCount(), new Object[]{xx, txtStarterValue.getText(), txtMainValue.getText(), txtDessertValue.getText(), txtDrinkValue.getText(), rowCost1});
        txtStarterValue.setText("-");
        txtMainValue.setText("-");
        txtDessertValue.setText("-");
        txtDrinkValue.setText("-");
        txtRowCost.setText("-");
        txtStarterPrice.setText("0.0");
        txtMainPrice.setText("0.0");
        txtDessertPrice.setText("0.0");
        txtDrinkPrice.setText("0.0");
        rowCost = 0;

    }//GEN-LAST:event_btnAddActionPerformed

    private void cbxEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmployeesActionPerformed

    }//GEN-LAST:event_cbxEmployeesActionPerformed

    private void txtFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinishActionPerformed
        
        //Envía resumen del pedido a la tabla de precios totales
        try{
        Integer.parseInt(txtTable.getText());
        p.setOrderId(xx);
        p.setTableNum(txtTable.getText());
        p.setEmployee((String) cbxEmployees.getSelectedItem());
        p.setTotalPrice(txtCost.getText());
        insertFinalOrder(p);
        
        
        //abre el form homepage
        Homepage h = new Homepage();
        h.setVisible(true);
                this.setVisible(false);
        }//manejo de errores si el usuario ingresa un carácter no numérico
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
            txtTable.setText(null);
        }
    }//GEN-LAST:event_txtFinishActionPerformed

    private void tblDrinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDrinksMouseClicked
        //añade la fila de la tabla seleccionada a los campos de texto
        int row = tblDrinks.getSelectedRow();
        
        String selected = tblDrinks.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblDrinks.getModel();
        try{
            if(selected !=null ){
                txtDrinkValue.setText(String.valueOf(model.getValueAt(tblDrinks.getSelectedRow(), 0)));
                txtDrinkPrice.setText(String.valueOf(model.getValueAt(tblDrinks.getSelectedRow(), 1)));
            }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }

    }//GEN-LAST:event_tblDrinksMouseClicked

    private void tblStartersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStartersMouseClicked
        //añade la fila de la tabla seleccionada a los campos de texto
        int row = tblStarters.getSelectedRow();

        String selected = tblStarters.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblStarters.getModel();
        try{
            if(selected !=null ){
                txtStarterValue.setText(String.valueOf(model.getValueAt(tblStarters.getSelectedRow(), 0)));
                txtStarterPrice.setText(String.valueOf(model.getValueAt(tblStarters.getSelectedRow(), 1)));
            }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
    }//GEN-LAST:event_tblStartersMouseClicked

    private void tblMainsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainsMouseClicked
        //añade la tabla seleccionada a los campos de texto
        int row = tblMains.getSelectedRow();

        String selected = tblMains.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblMains.getModel();
        try{
            if(selected !=null ){
                txtMainValue.setText(String.valueOf(model.getValueAt(tblMains.getSelectedRow(), 0)));
                txtMainPrice.setText(String.valueOf(model.getValueAt(tblMains.getSelectedRow(), 1)));
            }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
    }//GEN-LAST:event_tblMainsMouseClicked

    private void tblDessertsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDessertsMouseClicked
        //añade la fila de la tabla seleccionada a los campos de texto
        int row = tblDesserts.getSelectedRow();

        String selected = tblDesserts.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblDesserts.getModel();
        try{
            if(selected !=null ){
                txtDessertValue.setText(String.valueOf(model.getValueAt(tblDesserts.getSelectedRow(), 0)));
                txtDessertPrice.setText(String.valueOf(model.getValueAt(tblDesserts.getSelectedRow(), 1)));

                
            }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
    }//GEN-LAST:event_tblDessertsMouseClicked

    private void txtMainValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMainValueActionPerformed

    }//GEN-LAST:event_txtMainValueActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //añade la fila de la tabla seleccionada a los campos de texto
        int row = tblOrder.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)tblOrder.getModel();
        String selected = tblOrder.getValueAt(row, 5).toString();
        String Price = tblOrder.getValueAt(row, 5).toString();
        
        
        if (row >= 0) {
            runningCost -= Double.parseDouble(Price);
            txtCost.setText(String.valueOf(runningCost));
            model.removeRow(row);
        try{
            a.createConnection();
             PreparedStatement ps = a.conn.prepareStatement("delete from ORDER_Table where Price='"+selected+"' ");
                    ps.executeUpdate();
                    
                    
            JOptionPane.showMessageDialog(null, "Eliminado");
            btnDelete.setEnabled(false);
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostActionPerformed

    }//GEN-LAST:event_txtCostActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
       // boton borrar habilitado
       btnDelete.setEnabled(true);
        
        
    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //regresa a la pagina anterior
        Homepage h = new Homepage();
        h.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

 
    public static void main(String args[]) {
        
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }
   
    public void populateStarter(){
        String Starter;
        String StarterPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.StarterTable);
            ResultSetMetaData rsmd = results.getMetaData();
           
            
            while(results.next())
            {        
            Starter = results.getString(1);
            StarterPrice = results.getString(2);
          
            Startermodel.insertRow(Startermodel.getRowCount(), new Object[]{Starter, StarterPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //llena la tabla principal
    public void populateMain(){
        String Main;
        String MainPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.MainTable);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {

            }
 
            
            while(results.next())
            {              
            Main = results.getString(1);
            MainPrice = results.getString(2);
          
            Mainmodel.insertRow(Mainmodel.getRowCount(), new Object[]{Main, MainPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "Caracter Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void populateDessert(){
        String Dessert;
        String DessertPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DessertTable);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {

            }

            
            while(results.next())
            {              
            Dessert = results.getString(1);
            DessertPrice = results.getString(2);
          
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{Dessert, DessertPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "Caracter Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void populateDrink(){
        String Drink;
        String DrinkPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DrinkTable);
            ResultSetMetaData rsmd = results.getMetaData();
            while(results.next())
            {              
            Drink = results.getString(1);
            DrinkPrice = results.getString(2);
          
            Drinkmodel.insertRow(Drinkmodel.getRowCount(), new Object[]{Drink, DrinkPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "Caracter Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public String extractDigits(String src) 
    {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < src.length(); i++) {
        char c = src.charAt(i);
        if (Character.isDigit(c)) {
            builder.append(c);
        }
    }
    return builder.toString();
    }
    
    public void openStream(){

            
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox cbxEmployees;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblDesserts;
    private javax.swing.JTable tblDrinks;
    private javax.swing.JTable tblMains;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblStarters;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDessertPrice;
    private javax.swing.JTextField txtDessertValue;
    private javax.swing.JTextField txtDrinkPrice;
    private javax.swing.JTextField txtDrinkValue;
    private javax.swing.JButton txtFinish;
    private javax.swing.JTextField txtMainPrice;
    private javax.swing.JTextField txtMainValue;
    private javax.swing.JTextField txtRowCost;
    private javax.swing.JTextField txtStarterPrice;
    private javax.swing.JTextField txtStarterValue;
    private javax.swing.JTextField txtTable;
    // End of variables declaration//GEN-END:variables
}

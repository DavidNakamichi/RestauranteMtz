
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author vch_92
 */
public class MenuEditor extends javax.swing.JFrame {

    /**
     * Crea un nuevo formulario MenuEditor
     */
    // declarando una nueva instancia de nuestra clase de base de datos
    database a  = new database();
    //Declarando una nueva instancia de clases
    Starter s = new Starter();
    Main m = new Main();
    Dessert ds = new Dessert();
    Drink dr = new Drink();
    // declarando nuestros modelos de tablas que pertenecen a estructuras de tablas
    DefaultTableModel Startermodel;
    DefaultTableModel Mainmodel;
    DefaultTableModel Dessertmodel;
    DefaultTableModel Drinkmodel;
    public MenuEditor() {
        initComponents();

       //asignando el modelo de tabla predeterminado a nuestras tablas
        Startermodel =  (DefaultTableModel) tblStarters.getModel();
        Mainmodel =     (DefaultTableModel) tblMains.getModel();
        Dessertmodel =  (DefaultTableModel) tblDesserts.getModel();
        Drinkmodel =    (DefaultTableModel) tblDrinks.getModel();
        
        populateStarterTable();
        populateMainTable();
        populateDessertTable();
        populateDrinkTable();
        //Deshabilitar botones para propósitos de validación
        btnAdd.setEnabled(false);
        btnAddMain.setEnabled(false);
        btnAddDessert.setEnabled(false);
        btnAddDrink.setEnabled(false);
        btnDelete.setEnabled(false);
        btnDeleteMain.setEnabled(false);
        btnDeleteDessert.setEnabled(false);
        btnDeleteDrink.setEnabled(false);
        
        txtStarter.getDocument().addDocumentListener(new DocumentListener() 
        {
        @Override
          
        public void changedUpdate(DocumentEvent e){
          StarterlengthCheck();
         }
            @Override
        public void insertUpdate(DocumentEvent e) {
          StarterlengthCheck();
         }
        @Override
        public void removeUpdate(DocumentEvent e) {
           StarterlengthCheck();
         }
        });
        txtStarterPrice.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
          
        public void changedUpdate(DocumentEvent e){
          StarterlengthCheck();
         }
            @Override
        public void insertUpdate(DocumentEvent e) {
          StarterlengthCheck();
         }
        @Override
        public void removeUpdate(DocumentEvent e) {
           StarterlengthCheck();
         }
        });
        
        txtMain.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          MainlengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          MainlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           MainlengthCheck();
        }
        });
        txtMainPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          MainlengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          MainlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           MainlengthCheck();
        }
        });
         
        txtDessert.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override 
        public void changedUpdate(DocumentEvent e){
          DessertlengthCheck();
        }
            @Override
        public void insertUpdate(DocumentEvent e) {
          DessertlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DessertlengthCheck();
         }
        });
          
        txtDessertPrice.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
          
        public void changedUpdate(DocumentEvent e){
          DessertlengthCheck();
        }
            @Override
        public void insertUpdate(DocumentEvent e) {
          DessertlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DessertlengthCheck();
        }
        });
         
        txtDrink.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          DrinklengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          DrinklengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DrinklengthCheck();
        }
        });
    
        txtDrinkPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          DrinklengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          DrinklengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DrinklengthCheck();
        }
        });
        }
    
   
    
  
    public void populateStarterTable()
    {
       
        String Starter;
        String StarterPrice;
        int r =0;
 
        try
        {
            a.createConnection();
            //crea conexión a la base de datos
            // crea y ejecuta una declaración sql para mostrar toda la información de la variable 'StarterTable'
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.StarterTable);
            
            
            
           //el loop se ejecutará siempre que haya más datos para leer de la base de datos, asignando los valores correspondientes en consecuencia
            while(results.next())
            {              
            Starter = results.getString(1);
            StarterPrice = results.getString(2);
            //inserta una nueva fila en la tabla que contiene un objeto de pedido con las siguientes propiedades
            Startermodel.insertRow(Startermodel.getRowCount(), new Object[]{Starter, StarterPrice});
            r++;
            }//finaliza el bucle while
            // cierra cualquier transmisión y conexión abierta
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        } 
              
    }
    
    private void insertStarter(Starter s)
    {
        a.createConnection();//Crea una conexión a la base de datos
        try
        {
            a.stmt = a.conn.createStatement();//crea y ejecuta una declaración sql para insertar toda la información de los campos de texto
            a.stmt.execute("insert into " + a.StarterTable + " values ('" +
                    s.getStarter() + "','" + s.getStarterPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();//cierra la conexión
    }
    //método utilizado en el documento Listener para propósitos de validación
    public void StarterlengthCheck(){
        if(txtStarter.getText().equals("") || txtStarterPrice.getText().equals("")){
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
        }
        else if(txtStarter.getText().length()> 100 || txtStarter.getText().length()>100){
            btnAdd.setEnabled(false);
        }
        else{
            btnAdd.setEnabled(true);
        }
      }
    
    @SuppressWarnings("unchecked")
    
     public void populateMainTable()
    {
       
        String Main;
        String MainPrice;
        int r =0;
 
        try
        {
            a.createConnection();//crea una conexion a la base de datos
            // crea y ejecuta una declaración sql para mostrar toda la información de la variable 'StarterTable'
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.MainTable);
            ResultSetMetaData rsmd = results.getMetaData();
            //Rellena la Tabla hasta llegar al final de la base de datos
            while(results.next())
            {              
            Main = results.getString(1);
            MainPrice = results.getString(2);
            //inserta una nueva fila en la tabla que contiene un objeto de pedido con las siguientes propiedades
            Mainmodel.insertRow(Mainmodel.getRowCount(), new Object[]{Main, MainPrice});
            r++;
            }//fin del ciclo
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
    
    private void insertMain(Main m)
    {
        a.createConnection();//crea una conexion a la base de datos
        try
        {
            a.stmt = a.conn.createStatement();//crea y ejecuta una instrucción sql para insertar datos en la base de datos
            a.stmt.execute("insert into " + a.MainTable + " values ('" +
                            m.getMain() + "','" + m.getMainPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    //Crea el método utilizado en el detector de documentos
    public void MainlengthCheck(){
        if(txtMain.getText().equals("") || txtMainPrice.getText().equals("")){
            btnAddMain.setEnabled(false);
            btnDeleteMain.setEnabled(false);
        }
        else if(txtMain.getText().length()> 100 || txtMain.getText().length()>100){
            btnAddMain.setEnabled(false);
        }
        else{
            btnAddMain.setEnabled(true);
        }
      }
    
    @SuppressWarnings("unchecked")
    
     public void populateDessertTable()
    {
       
        String Dessert;
        String DessertPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DessertTable);
            ResultSetMetaData rsmd = results.getMetaData();

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
    
    private void insertDessert(Dessert ds)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.DessertTable + " values ('" +
                    ds.getDessert() + "','" + ds.getDessertPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    //método utilizado en el detector de documentos
    public void DessertlengthCheck(){
          if(txtDessert.getText().equals("") || txtDessertPrice.getText().equals("")){
              btnAddDessert.setEnabled(false);
              btnDeleteDessert.setEnabled(false);
          }
          else if(txtDessert.getText().length()> 100 || txtDessert.getText().length()>100){
               btnAddDessert.setEnabled(false);
          }
          else{
               btnAddDessert.setEnabled(true);
          }
      }
    
    @SuppressWarnings("unchecked")
    //Rellena la tabla de bebidas de la misma manera que los métodos anteriores
    public void populateDrinkTable()
    {
       
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
        }
              
    }
    //inserta la información de la bebida en la tabla de bebidas de la misma manera que en los métodos anteriores
    private void insertDrink(Drink dr)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.DrinkTable + " values ('" +
                    dr.getDrink() + "','" + dr.getDrinkPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    
    public void DrinklengthCheck(){
          if(txtDrink.getText().equals("") || txtDrinkPrice.getText().equals("")){
              btnAddDrink.setEnabled(false);
              btnDeleteDrink.setEnabled(false);
          }
          else if(txtDrink.getText().length()> 100 || txtDrink.getText().length()>100){
               btnAddDrink.setEnabled(false);
          }
          else{
               btnAddDrink.setEnabled(true);
          }
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStarters = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMains = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDesserts = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDrinks = new javax.swing.JTable();
        txtStarter = new javax.swing.JTextField();
        txtStarterPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtMainPrice = new javax.swing.JTextField();
        btnAddMain = new javax.swing.JButton();
        btnDeleteMain = new javax.swing.JButton();
        txtMain = new javax.swing.JTextField();
        txtDessertPrice = new javax.swing.JTextField();
        btnAddDessert = new javax.swing.JButton();
        btnDeleteDessert = new javax.swing.JButton();
        txtDessert = new javax.swing.JTextField();
        btnAddDrink = new javax.swing.JButton();
        txtDrinkPrice = new javax.swing.JTextField();
        btnDeleteDrink = new javax.swing.JButton();
        txtDrink = new javax.swing.JTextField();
        btnDeselectS = new javax.swing.JButton();
        btnDeselectM = new javax.swing.JButton();
        btnDeselectDes = new javax.swing.JButton();
        btnDeselectDr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        btnBack.setText("Back to Home");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStarters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entradas", "Precio"
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
            tblStarters.getColumnModel().getColumn(0).setResizable(false);
            tblStarters.getColumnModel().getColumn(1).setMinWidth(70);
            tblStarters.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblStarters.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 242, 138));

        tblMains.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Platillos", "Precio"
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
            tblMains.getColumnModel().getColumn(0).setResizable(false);
            tblMains.getColumnModel().getColumn(1).setMinWidth(70);
            tblMains.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblMains.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 242, 138));

        tblDesserts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Postres", "Precio"
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
            tblDesserts.getColumnModel().getColumn(0).setResizable(false);
            tblDesserts.getColumnModel().getColumn(1).setMinWidth(70);
            tblDesserts.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDesserts.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 309, 242, 138));

        tblDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bebidas", "Precio"
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
        jScrollPane4.setViewportView(tblDrinks);
        if (tblDrinks.getColumnModel().getColumnCount() > 0) {
            tblDrinks.getColumnModel().getColumn(0).setResizable(false);
            tblDrinks.getColumnModel().getColumn(1).setMinWidth(70);
            tblDrinks.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDrinks.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 458, 242, 138));
        getContentPane().add(txtStarter, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 57, 150, -1));
        getContentPane().add(txtStarterPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 88, 150, -1));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 120, 120, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 120, 120, -1));
        getContentPane().add(txtMainPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 244, 150, -1));

        btnAddMain.setBackground(new java.awt.Color(255, 255, 255));
        btnAddMain.setText("Añadir");
        btnAddMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMainActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 275, 120, -1));

        btnDeleteMain.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteMain.setText("Delete Order");
        btnDeleteMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMainActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 275, 120, -1));
        getContentPane().add(txtMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 213, 150, -1));
        getContentPane().add(txtDessertPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 377, 150, -1));

        btnAddDessert.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDessert.setText("Añadir");
        btnAddDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDessertActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 424, 120, -1));

        btnDeleteDessert.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteDessert.setText("Eliminar");
        btnDeleteDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDessertActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 424, 120, -1));
        getContentPane().add(txtDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 346, 150, -1));

        btnAddDrink.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDrink.setText("Añadir");
        btnAddDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 573, 120, -1));
        getContentPane().add(txtDrinkPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 538, 150, -1));

        btnDeleteDrink.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteDrink.setText("Eliminar");
        btnDeleteDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 573, 120, -1));

        txtDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(txtDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 507, 150, -1));

        btnDeselectS.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectS.setText("Deseleccionar");
        btnDeselectS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectSActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectS, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 70, 90, -1));

        btnDeselectM.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectM.setText("Deseleccionar");
        btnDeselectM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectMActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectM, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 225, 86, -1));

        btnDeselectDes.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectDes.setText("Deseleccionar");
        btnDeselectDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectDesActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 359, 86, -1));

        btnDeselectDr.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectDr.setText("Deseleccionar");
        btnDeselectDr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectDrActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectDr, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 522, 86, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Añadir Entrada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 58, 100, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Precio");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 89, 50, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Añadir Platillo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 214, 100, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Añadir Postre");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 347, 100, -1));

        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Precio");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 245, 50, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Precio");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 378, 50, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Añadir Bebida");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 508, 100, -1));

        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Precio");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 539, -1, -1));

        btnBack1.setBackground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("Regresar al Menu");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 607, 150, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGrestauranteMartinez.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //añadiendo datos a la tabla de inicio
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
       try{
        Double.parseDouble(txtStarterPrice.getText());//Comprobando si el texto es doble en el campo de texto del precio
        //Inserta datos en la tabla
        Startermodel.insertRow(Startermodel.getRowCount(), new Object[]{txtStarter.getText(), txtStarterPrice.getText()});
        //Obtiene información de los campos de texto que se usarán para llenar la tabla de la base de datos
        s.setStarter(txtStarter.getText());
        s.setStarterPrice(txtStarterPrice.getText());
        // Borra campos de texto
        txtStarter.setText(null);
        txtStarterPrice.setText(null);
        //Llama al método insert starter y pasa los valores del campo de texto
        insertStarter(s);
       }
       catch(Exception c){
            // detectó el error si no se ingresa un número en el campo de texto del precio
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
            txtStarter.setText(null);
            txtStarterPrice.setText(null);
            btnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Establece una variable igual a la fila seleccionada
        int row = tblStarters.getSelectedRow();
        // Establece la variable seleccionada igual al primer valor en la fila seleccionada y la establece en una cadena
        String selected = tblStarters.getValueAt(row, 0).toString();
        
            
        
        if (row >= 0) {
                
                Startermodel.removeRow(row);
        try{
            a.createConnection();//crea conexión
            //prepara y ejecuta la instrucción sql para eliminar de la base de datos
            PreparedStatement ps = a.conn.prepareStatement("delete from Starter_Table where Starter='"+selected+"' ");
            ps.executeUpdate();
                    
            txtStarter.setText(null);
            txtStarterPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblStartersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStartersMouseClicked
        //establece la fila seleccionada igual a la variable
        int row = tblStarters.getSelectedRow();
        // Establece la variable 'seleccionada' igual al primer valor en la fila seleccionada y lo establece en una cadena
        String selected = tblStarters.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblStarters.getModel();
        try{
        if(selected !=null ){
            
//Coloca el texto de la fila seleccionada en los campos de texto
            txtStarter.setText(String.valueOf(model.getValueAt(tblStarters.getSelectedRow(), 0)));
            txtStarterPrice.setText(String.valueOf(model.getValueAt(tblStarters.getSelectedRow(), 1)));
           //Deshabilitar botones para propósitos de validación 
            btnDelete.setEnabled(true);
            btnAdd.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
    }//GEN-LAST:event_tblStartersMouseClicked
    //hace lo mismo que el botón Agregar anterior
    private void btnAddMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMainActionPerformed
        try{
        Double.parseDouble(txtMainPrice.getText());
        Mainmodel.insertRow(Mainmodel.getRowCount(), new Object[]{txtMain.getText(), txtMainPrice.getText()});
        m.setMain(txtMain.getText());
        m.setMainPrice(txtMainPrice.getText());
        
        txtMain.setText(null);
        txtMainPrice.setText(null);
        
        insertMain(m);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "Inserte un valor numerico");
            txtMain.setText(null);
            txtMainPrice.setText(null);
            btnAddMain.setEnabled(false);
        }
    }//GEN-LAST:event_btnAddMainActionPerformed
 
    private void btnDeleteMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMainActionPerformed
            
        int row = tblMains.getSelectedRow();
        String selected = tblMains.getValueAt(row, 0).toString();
        if (row >= 0) {

                Mainmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Mains_Table where Main='"+selected+"' ");
            ps.executeUpdate();
                    
            txtMain.setText(null);
            txtMainPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteMainActionPerformed
 
    private void btnAddDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDessertActionPerformed
        try{
            Double.parseDouble(txtDessertPrice.getText());
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{txtDessert.getText(), txtDessertPrice.getText()});
            ds.setDessert(txtDessert.getText());
            ds.setDessertPrice(txtDessertPrice.getText());
            txtDessert.setText(null);
            txtDessertPrice.setText(null);
            insertDessert(ds);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "Inserte un valor numerico");
            txtDessert.setText(null);
            txtDessertPrice.setText(null);
            btnAddDessert.setEnabled(false);
        }
    }//GEN-LAST:event_btnAddDessertActionPerformed
    //does the same as previous delete buttons
    private void btnDeleteDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDessertActionPerformed
        
        int row = tblDesserts.getSelectedRow();
        
        String selected = tblDesserts.getValueAt(row, 0).toString();
        if (row >= 0) {

            Dessertmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Dessert_Table where Dessert='"+selected+"' ");
            ps.executeUpdate();
                    
            txtDessert.setText(null);
            txtDessertPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }   
        }
        
    }//GEN-LAST:event_btnDeleteDessertActionPerformed

    private void btnAddDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDrinkActionPerformed
        try{
        
        Double.parseDouble(txtDrinkPrice.getText());
        Drinkmodel.insertRow(Drinkmodel.getRowCount(), new Object[]{txtDrink.getText(), txtDrinkPrice.getText()});
        dr.setDrink(txtDrink.getText());
        dr.setDrinkPrice(txtDrinkPrice.getText());
        
        txtDrink.setText(null);
        txtDrinkPrice.setText(null);
        
        insertDrink(dr);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "Inserte un valor numerico");
            txtDrink.setText(null);
            txtDrinkPrice.setText(null);
            btnAddDrink.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnAddDrinkActionPerformed

    private void btnDeleteDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDrinkActionPerformed
        
        int row = tblDrinks.getSelectedRow();
        String selected = tblDrinks.getValueAt(row, 0).toString();

        if (row >= 0) {

                Drinkmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Drink_Table where Drink='"+selected+"' ");
            ps.executeUpdate();          
            txtDrink.setText(null);
            txtDrinkPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Eliminado");
            
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteDrinkActionPerformed

    private void tblMainsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainsMouseClicked

        int row = tblMains.getSelectedRow();
        
        String selected = tblMains.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblMains.getModel();
        try{
        if(selected !=null ){
            txtMain.setText(String.valueOf(model.getValueAt(tblMains.getSelectedRow(), 0)));
            txtMainPrice.setText(String.valueOf(model.getValueAt(tblMains.getSelectedRow(), 1)));
            
            btnDeleteMain.setEnabled(true);
            btnAddMain.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }

    }//GEN-LAST:event_tblMainsMouseClicked
 
    private void tblDessertsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDessertsMouseClicked
        int row = tblDesserts.getSelectedRow();
        
        String selected = tblDesserts.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblDesserts.getModel();
        try{
        if(selected !=null ){
            txtDessert.setText(String.valueOf(model.getValueAt(tblDesserts.getSelectedRow(), 0)));
            txtDessertPrice.setText(String.valueOf(model.getValueAt(tblDesserts.getSelectedRow(), 1)));
            
            btnDeleteDessert.setEnabled(true);
            btnAddDessert.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
    }//GEN-LAST:event_tblDessertsMouseClicked

    private void tblDrinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDrinksMouseClicked
        
        int row = tblDrinks.getSelectedRow();
        
        String selected = tblDrinks.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblDrinks.getModel();
        try{
        if(selected !=null ){
            txtDrink.setText(String.valueOf(model.getValueAt(tblDrinks.getSelectedRow(), 0)));
            txtDrinkPrice.setText(String.valueOf(model.getValueAt(tblDrinks.getSelectedRow(), 1)));
            
            btnDeleteDrink.setEnabled(true);
            btnAddDrink.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
        
    }//GEN-LAST:event_tblDrinksMouseClicked

    private void txtDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDrinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDrinkActionPerformed
// deselecciona la fila seleccionada de la tabla
    private void btnDeselectSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectSActionPerformed
        
        tblStarters.getSelectionModel().clearSelection();
        txtStarter.setText(null);
        txtStarterPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectSActionPerformed
    // deselecciona la fila seleccionada de la tabla
    private void btnDeselectMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectMActionPerformed
        
        tblMains.getSelectionModel().clearSelection();
        txtMain.setText(null);
        txtMainPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectMActionPerformed
    // deselecciona la fila seleccionada de la tabla
    private void btnDeselectDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectDesActionPerformed
        
        tblDesserts.getSelectionModel().clearSelection();
        txtDessert.setText(null);
        txtDessertPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectDesActionPerformed
    // deselecciona la fila seleccionada de la tabla
    private void btnDeselectDrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectDrActionPerformed
        
        tblDrinks.getSelectionModel().clearSelection();
        txtDrink.setText(null);
        txtDrinkPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectDrActionPerformed
    //Vuelve al formulario anterior
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        Frame h = new Frame();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddDessert;
    private javax.swing.JButton btnAddDrink;
    private javax.swing.JButton btnAddMain;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteDessert;
    private javax.swing.JButton btnDeleteDrink;
    private javax.swing.JButton btnDeleteMain;
    private javax.swing.JButton btnDeselectDes;
    private javax.swing.JButton btnDeselectDr;
    private javax.swing.JButton btnDeselectM;
    private javax.swing.JButton btnDeselectS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDesserts;
    private javax.swing.JTable tblDrinks;
    private javax.swing.JTable tblMains;
    private javax.swing.JTable tblStarters;
    private javax.swing.JTextField txtDessert;
    private javax.swing.JTextField txtDessertPrice;
    private javax.swing.JTextField txtDrink;
    private javax.swing.JTextField txtDrinkPrice;
    private javax.swing.JTextField txtMain;
    private javax.swing.JTextField txtMainPrice;
    private javax.swing.JTextField txtStarter;
    private javax.swing.JTextField txtStarterPrice;
    // End of variables declaration//GEN-END:variables
}

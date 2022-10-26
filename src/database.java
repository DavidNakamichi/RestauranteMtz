//importaciones necesarias para la clase
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//constructor
public class database {
    protected static String dbURL = "jdbc:derby:Employee;user=APP;password=test";
    protected static String tableName = "Employee_Table";
    protected static String tableName1 = "ORDER_TABLE";
    protected static String tableName2 = "Price_TABLE";
    protected static String StarterTable = "Starter_TABLE";
    protected static String MainTable = "Mains_TABLE";
    protected static String DessertTable = "Dessert_TABLE";
    protected static String DrinkTable = "Drink_TABLE";
    protected static Connection conn = null;
    protected static Statement stmt = null;

    protected static void createConnection()
    {
        //crea la conexion a la base de datos
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Obtener una conexión
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
     protected static void shutdown()
    {
        try
        {
           //cierra cualquier declaración y cierra cualquier conexión
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
     
    
     //crea una nueva tabla Employee_ mediante el uso de una instrucción SQL
     protected static void createTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table Employee_Table (EmployeeID int, First_Name varchar(50),Last_Name varchar(50), PPSN varchar(10), Wages varchar(10), Position varchar(30) )");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
      //crea una nueva ORDER_TABLE mediante el uso de una instrucción SQL 
    protected static void createTable1(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table ORDER_TABLE (OrderID varchar(100), Starter varchar(1000), main varchar(1000), Dessert varchar(1000), Drink varchar(1000), Price varchar(100))");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
    //crea una nueva PRICE_TABLE mediante el uso de una instrucción SQL 
    protected static void createTable2(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table Price_TABLE (OrderID varchar(100), TableNum varchar(1000), EmpName varchar(1000), TotalPrice varchar(100))");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
    
    //crea una nueva Starter_TABLE mediante el uso de una instrucción SQL
    protected static void createStarterTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table Starter_TABLE (Starter varchar(100), StarterPrice varchar(100))");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
    
    //crea una nueva Main_TABLE mediante el uso de una instrucción SQL
    protected static void createMainTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table Mains_TABLE (Main varchar(100), MainPrice varchar(100))");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
    
   //crea una nueva Dessert_TABLE mediante el uso de una instrucción SQL
    protected static void createDessertTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table Dessert_TABLE (Dessert varchar(100), DessertPrice varchar(100))");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
    
    //crea una nueva Drink_TABLE mediante el uso de una declaración SQL
    protected static void createDrinkTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("create table Drink_TABLE (Drink varchar(100), DrinkPrice varchar(100))");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    } 
    
    //elimina una tabla
     protected static void dropTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table Employee_Table");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
     
     //elimina una tabla
     protected static void dropTable1(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table ORDER_TABLE");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
     
     //elimina una tabla
      protected static void dropTable2(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table Price_TABLE");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
      
      //elimina una tabla
    protected static void dropStarterTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table Starter_TABLE");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
    
    //elimina una tabla
    protected static void dropMainTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table Mains_TABLE");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
    
    //elimina una tabla
    protected static void dropDessertTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table Starter_TABLE");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
    
    //elimina una tabla
    protected static void dropDrinkTable(){
        try{
            createConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table Starter_TABLE");
            stmt.close();
            
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }
}


class Dessert {
    public Dessert()
    {
        
    }
    
    private String Dessert, DessertPrice;
    // declaración de variables
    
    //getters y setters
    public String getDessert()
      {
         return Dessert;
      }
     
    public String getDessertPrice()
      {
         return DessertPrice;
      }
    
      protected void setDessert(String iDessert)
      {
         this.Dessert = iDessert;
      }
     
     protected void setDessertPrice(String iDessertPrice)
      {
         this.DessertPrice = iDessertPrice;
      }
     
    
}


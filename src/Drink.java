class Drink {
    public Drink()//constructor
        {
         
        }
     private String Drink, DrinkPrice;// declaración de variables
    
    //getters y setters
     public String getDrink()
      {
         return Drink;
      }
     
     public String getDrinkPrice()
      {
         return DrinkPrice;
      }
    
     protected void setDrink(String iDrink)
      {
         this.Drink = iDrink;
      }
     
     protected void setDrinkPrice(String iDrinkPrice)
      {
         this.DrinkPrice = iDrinkPrice;
      }
}

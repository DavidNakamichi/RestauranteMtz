
public class Starter {
    
    public Starter(){
        
    }
 
    private String Starter, StarterPrice;
    
 // declaración de variables
    
    //getters y setters
    public String getStarter()
      {
         return Starter;
      }
     
     public String getStarterPrice()
      {
         return StarterPrice;
      }
     
     protected void setStarter(String iStarter)
      {
         this.Starter = iStarter;
      }
     
     protected void setStarterPrice(String iStarterPrice)
      {
         this.StarterPrice = iStarterPrice;
      }
}

public abstract class Item{
     
     private String name;
     private double damageFactor;
     
     
     public Item(String name, double damage){
          
          this.damageFactor = damage;
          this.name = name;
          
     }
     
     public String getName(){
          
          return name;
          
     }
     
     public double getDamage(){
          
          return damageFactor;
          
     }
     
     public void setName(String name){
          
          this.name = name;
          
     }
     
     public void setDamage(double damage){
          
          this.damageFactor = damage;
          
     }
     
     
     
}
     

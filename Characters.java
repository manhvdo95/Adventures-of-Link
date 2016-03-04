public abstract class Characters {
     
     private String name;
     private int health;
     private int attackPower;
     
     
     
     public Characters(String name, int health, int attackPower){
          this.health = health;
          this.name = name;
          this.attackPower = attackPower;
          
          
     }
     
     public int getHealth(){
          return health;
     }
     
     public String getName(){
          return name;
     }
     
     public int getAttackPower(){
          
          return attackPower;
     }
     
     public void setHealth(int health){
          
          this.health = health;
          
     }
     
     public void setName(String name){
          
          this.name = name;
          
     }
     
     public void setAttackPower(int attackPower){
          
          this.attackPower = attackPower;
          
     }
          
     public void damageDealt(Characters opponent){
          
          int newHealth = opponent.getHealth() - this.attackPower;
          opponent.setHealth(newHealth);
          
     }
     
     public boolean isAlive(){
          
          if (this.health > 0){
               
               return true;
               
          }
          
          else{
               
               return false;
               
          }
          
     }
          
     public String toString(){
          
          return String.format("Name: %s \n Health: %d \n AttackPower: %d \n", name, health, attackPower );
          
     }
     
     public abstract void takeTurn(Characters opponent);
     
}
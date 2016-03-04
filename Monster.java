public class Monster extends Characters{
     
     private int experience;
     
     public Monster(String name, int health, int attackPower, int experience){
          
          super(name, health, attackPower);
          this.experience = experience;
          
     }
     
     public int getExperience(){
          
          return experience;
          
     }
     
     public void setExperience(int experience){
          
          this.experience = experience;
          
     }
     
     public void takeTurn(Characters opponent){
          
          damageDealt(opponent);
          
     }
     
     public String toString(){
          
          String str = super.toString();
          
          str += "Experience: " + this.experience + "\n";
          
          return str;
          
     }
     
     
     
}
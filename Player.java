public class Player extends Characters{
     
     private int level;
     private int mana;
     private int weapon;
     private int potion = 5;
     
     public Player(String name, int health, int attackpower, int mana, int level){
          
          super(name, health, attackpower);
          this.level = level;
          this.mana = mana;
          
     }
     
     public int getPotion(){
          
          return potion;
          
     }
     
     public void setPotion(int potion){
          
          this.potion = potion;
          
     }
     
          
     public int getLevel(){
          
          return level;
          
     }
     
     public int getMana(){
          
          return mana;
          
     }
     
     public void setLevel(int level){
          
          this.level = level;
          
     }
     
     public void setMana(int mana){
          
          this.mana = mana;
          
     }
     
     public void usePotion(){
         
         if(this.potion != 0) {
              
          setHealth(getHealth() + 50);
          setMana(getMana() + 6);
          
          potion--;
         }
     }
   
          
     
     
     public void castSpell(Characters opponent){
          
          if(getMana() >= 2 ){
               
        opponent.setHealth(opponent.getHealth() / 2 );
        
        setMana(getMana() - 2); //equivalent of this.Mana -= 3
        
          }
          
          
          
     }
     
     public void takeTurn(Characters opponent){
          
          damageDealt(opponent);
          
     }
     
     public String toString(){
          
          String str = super.toString();
          
          str += "Mana: " + this.mana + "\n" + "Level: " + this.level + "\n";
          
          return str;
          
     }
     
}
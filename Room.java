/*Leonardo Pena
*Homework 4: Refactoring Adventure Game
*/
import java.util.Random;
public class Room{
     
     private String description;
     private Room north;
     private Room south;
     private Room east;
     private Room west;
     public Monster monster;
     
     private boolean hasMonster = false;
     private boolean isOrk = false;
     
     
     public Room(String description){
          
          this.description = description;
          
          assignMonster();
          
     }
     
     public boolean wasOrk(){
          
          return isOrk;
          
     }
     
     public String getDescription(){
          
          return description;
          
     }
     
     public Room getNorth(){
          
          return north;
     }
     
     public void setNorth(Room north){
          
          this.north = north;
     }
     
     public Room getSouth(){
          
          return south;
          
     }
     
     public void setSouth(Room south){

          this.south = south;
          
     }
      public Room getEast(){
           
          return east;
     }
     
      public void setEast(Room east){
           
           this.east = east;
           
     }
      public Room getWest(){
           
          return west;
          
     }
      public void setWest(Room west){
           
           this.west = west;
           
     }
     //getExits method not working with toString
     public String toString(){
             
             //return getExits(); 
               return getDescription();     
     }
     
     public String getExits(){
          String exitOfRooms = "The exits of this room are " + getNorth() + ", " + getSouth() + ", " + getEast() + ", " + getWest();
          //String exitOfRooms = "exitTesting";
          
          return exitOfRooms;
          
     }
     
     public void setExits(Room n, Room s, Room e, Room w){
          
          setNorth(n);
          setEast(e);
          setSouth(s);
          setWest(w);
          
     }
     
     public void assignMonster(){
          
          Random random = new Random();
          
          int generator = random.nextInt(2);
          
          if (generator == 0){
               
               monster= new Monster("Goblin", 120, 15, 1);
               hasMonster = true;
               
          }
          else if (generator == 1){
               
               monster = new Monster("Orc", 200, 25, 1);
               hasMonster = true;
               
          }
          
     }
     
     public boolean hasMonster(){
          
          return hasMonster;
          
     }
     
     
     
}
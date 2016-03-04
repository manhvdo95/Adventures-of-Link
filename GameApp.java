import java.util.Scanner;
import java.util.Random;
public class GameApp{
     
     private enum Status {CONTINUE, BATTLE, LOSE, QUIT, WIN};
     
      static Scanner input = new Scanner(System.in);
      static Status gameStatus;
     
     private static Room currentRoom;
     private static Room currentRoomPlayerIsIn;
     private static Player player;
     private static Dungeon dungeon;
     
     
     public static void main(String[]args){
          
          dungeon = new Dungeon();
          player = new Player("Link", 200, 20, 10, 0);
                    
          currentRoom = dungeon.getRoom0();
          
          gameStatus = Status.CONTINUE;
          
          String directionChoice;
          int combatChoice;
          
          while(gameStatus != Status.QUIT || gameStatus != Status.LOSE){
               if(player.getLevel() == 7){
                          
                          gameStatus = Status.WIN;
                          
                          break;
                    }
               
                              //this if statement is ran twice
                     if(gameStatus == Status.CONTINUE){
                         
                         mainMenuPrompt();
                         directionChoice = input.nextLine();
                         executeChoice(directionChoice);
                         
                     }
          
                     else if(gameStatus == Status.BATTLE){
                          
                          battlePrompt();
                          combatChoice = input.nextInt();
                          executeBattleChoice(combatChoice);
                          
                     }
                    
                     else{
                          
                          break;
                          
                     }
                     
          }
          
          if(gameStatus == Status.LOSE){
               
               loseMessage();
               System.exit(0);
               
          }
           if(gameStatus == Status.QUIT) {
                              
                              quitMessage();
                              System.exit(0);
                         }
          if(gameStatus == Status.WIN){
               
               winMessage();
               
          }               
          
     }
     
     public static void battlePrompt(){
          
         System.out.println("Name: " + currentRoom.monster.getName());
         System.out.println("Monster Health: " + currentRoom.monster.getHealth());
         System.out.println("Monster Attack: " + currentRoom.monster.getAttackPower());
         System.out.println("Monster Exp: " + currentRoom.monster.getExperience());
         System.out.println();
         
         System.out.println("Hero Name: " + player.getName());
         System.out.println("Hero Health: " + player.getHealth());
         System.out.println("Hero Attack: " + player.getAttackPower());
         System.out.println("Hero Mana: " + player.getMana());
         System.out.println("Hero Level: " + player.getLevel());
         System.out.println("Potions: " + player.getPotion());
         System.out.println();
         
         System.out.println("What option will you choose?");
         System.out.println("Combat Options:");
         System.out.println(" 1.) Sword Attack");
         System.out.println(" 2.) Cast Spell");
         System.out.println(" 3.) Drink Potion");
          
     }
     
     public static void executeBattleChoice(int choice){
          
          if(choice == 1){
               
               player.takeTurn(currentRoom.monster);
               
               if(currentRoom.monster.isAlive()) {
                    
               currentRoom.monster.takeTurn(player);
               
                    if(!player.isAlive()){
                         
                         gameStatus = Status.LOSE;
                         
                    }
               
               }
               
               
               
               else{
                    player.setPotion(player.getPotion() + 1);
                    
                    player.setLevel(player.getLevel() + currentRoom.monster.getExperience());
                    
                    if(currentRoom.monster.getName().equals("Orc")){
                         System.out.println("I killed an Orc and took its sword! With this new sword I deal 40 damage!");
                         player.setAttackPower(40);
                         
                    }
                    
                    gameStatus = Status.CONTINUE;
               }
          }
          
          else if(choice == 2){
               
               player.castSpell(currentRoom.monster);
               
               if(currentRoom.monster.isAlive()) {
                    
               currentRoom.monster.takeTurn(player);
               
               }
               
          }
          
          else if(choice == 3){
             
          player.usePotion();
          
                if(currentRoom.monster.isAlive()) {
                     
               currentRoom.monster.takeTurn(player);
               
               }
               
          }
          else{
               System.out.println("Invalid option, only 1-3");
          }
          
     }
     
     public static void mainMenuPrompt(){
          
          System.out.println("You are currently in " + currentRoom);
          System.out.println("Your choices are: n, s, e, w");
          System.out.println("To quit: q");     
          
     }
      public static void executeChoice(String choice){
      
          
          if(choice.equals("n") || choice.equals("N") ){
               
               Room originalRoom = currentRoom;
               currentRoom = currentRoom.getNorth();
               
               if(currentRoom == null){
                    
                    currentRoom = originalRoom;
                    System.out.println("You ran into a wall choose another direction!");
                    
               }
               
               if(currentRoom.hasMonster() && currentRoom.monster.isAlive()){
                    
                    gameStatus = Status.BATTLE;
                    
               }
               
          }
          else if(choice.equals("s") || choice.equals("S") ){
               
               Room originalRoom = currentRoom;
               currentRoom = currentRoom.getSouth();
               
               if(currentRoom == null){
                    currentRoom = originalRoom;
                    System.out.println("You ran into a wall choose another direction!");
               }
               
              if(currentRoom.hasMonster() && currentRoom.monster.isAlive()){
                    
                    gameStatus = Status.BATTLE;
                    
               }
               
          }
          else if(choice.equals("e") || choice.equals("E") ){
               
                Room originalRoom = currentRoom;
               currentRoom = currentRoom.getEast();
               if(currentRoom == null){
                    currentRoom = originalRoom;
                    System.out.println("You ran into a wall choose another direction!");
               }
               
               if(currentRoom.hasMonster() && currentRoom.monster.isAlive()){
                    
                    gameStatus = Status.BATTLE;
                    
               }
               
          }
          else if(choice.equals("w") || choice.equals("W") ){
               
                Room originalRoom = currentRoom;
               currentRoom = currentRoom.getWest();
               if(currentRoom == null){
                    currentRoom = originalRoom;
                    System.out.println("You ran into a wall choose another direction!");
               }
               
               if(currentRoom.hasMonster() && currentRoom.monster.isAlive()){
                    
                    gameStatus = Status.BATTLE;
                    
               }
               
          }
          else if(choice.equals("q") || choice.equals("Q") ){
               gameStatus = Status.QUIT;
          }
          else{
               
               System.out.println("Not a valid direction!");
          
          }
          
     }
      public static void quitMessage(){
          
          System.out.println("Thanks for playing!");
          
     }
     
     public static void winMessage(){
          
          System.out.println("Congratulations, you have slain all the monsters!");
          
     }
     
     public static void loseMessage(){
          
          System.out.println("YOUR SOUL HAS BEEN CLAIMED!");
          
     }
     
}
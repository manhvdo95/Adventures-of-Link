public class Dungeon{
     
     private Room balcony;
     private Room bedroom1;
     private Room bedroom2;
     private Room dining;
     private Room kitchen;
     private Room northHall;
     private Room southHall;
     
     public Dungeon(){
          
          balcony = new Room("A balcony.");
          bedroom1 = new Room("The master bed room.");
          bedroom2 = new Room("The guest bed room.");
          dining = new Room("The dining room.");
          kitchen = new Room("The kitchen.");
          northHall = new Room("A long hallway.");
          southHall = new Room("A dark hallway.");
          
          balcony.setSouth(northHall);
          bedroom1.setNorth(bedroom2);
          bedroom1.setEast(southHall);
          bedroom2.setSouth(bedroom1);
          bedroom2.setEast(northHall);
          dining.setWest(northHall);
          dining.setSouth(kitchen);
          kitchen.setNorth(dining);
          kitchen.setWest(southHall);
          northHall.setEast(dining);
          northHall.setNorth(balcony);
          northHall.setSouth(southHall);
          northHall.setWest(bedroom2);
          southHall.setEast(kitchen);
          southHall.setNorth(northHall);
          southHall.setWest(bedroom1);
          
          balcony.setExits(balcony.getNorth(), balcony.getSouth(), balcony.getEast(), balcony.getWest());
          bedroom1.setExits(bedroom1.getNorth(), bedroom1.getSouth(), bedroom1.getEast(), bedroom1.getWest());
          bedroom2.setExits(bedroom2.getNorth(), bedroom2.getSouth(), bedroom2.getEast(), bedroom2.getWest());
          dining.setExits(dining.getNorth(), dining.getSouth(), dining.getEast(), dining.getWest());
          kitchen.setExits(kitchen.getNorth(), kitchen.getSouth(), kitchen.getEast(), kitchen.getWest());
          northHall.setExits(northHall.getNorth(), northHall.getSouth(), northHall.getEast(), northHall.getWest());
          southHall.setExits(southHall.getNorth(), southHall.getSouth(), southHall.getEast(), southHall.getWest());
          
     }
     //starting room
     public Room getRoom0(){
          
          return balcony;
          
     }
}
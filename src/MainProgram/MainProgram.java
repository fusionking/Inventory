package MainProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Item.Item;
import MainInventory.Inventory;

public class MainProgram {
	
	static HashMap<String,Integer> items_list;
	static HashMap<String,Integer> u_inventory;
	static Integer num_of_items;
	static Inventory my_inventory;
	
	String item_name;
	Integer item_price;
	
	 public static void main(String args[]) {
		 
		my_inventory = new Inventory(); 
		 
     	System.out.println(my_inventory.getItems());
		System.out.println("Welcome to your inventory! Here are your options: \n ");
		
		while(true)
		{	
			splash();
			System.out.println("Select an option : \n ");
			Scanner scan = new Scanner(System.in);
			int option = scan.nextInt();
			
			switch(option) {
		         case 1 :
		        	 	
			            items_list = my_inventory.getItems();
			            num_of_items = my_inventory.getNumItems();
			            int i= 1;
			            
			            for (Map.Entry<String, Integer> entry : items_list.entrySet()) {
			            	
			            	String key = entry.getKey();
			                String value = entry.getValue().toString();
			                System.out.println(Integer.toString(i) + ". " + key + "  " + value + "$");
			                i++; 
			            }
			            System.out.println("\n ");
			            
			            break;
		            
		         case 2 :
		        	 
			            System.out.println("To add an item, type in the enumeration for the item of your choice: ");
			            
			            Scanner scanner_for_add = new Scanner(System.in);
			   		    Integer add_enum_item = scanner_for_add.nextInt();
			   		    
			   		    my_inventory.addToInventory(add_enum_item);
			   		    
			   		    System.out.println("Your inventory: \n ");
		                
			        	u_inventory = my_inventory.getUserInventory();
			        	
			        	Integer index = 1;
			        	
			        	for (Map.Entry<String, Integer> entry : u_inventory.entrySet()) {
			            	String key = entry.getKey();
			                String value = entry.getValue().toString();
			                System.out.println(Integer.toString(index) + ". " + key + "  " + value + "$");
			                index ++;
			            }
			        	
			        	System.out.println("\n ");
			            
			        	break;
			           
		         case 3 :
		        	 
		        	    System.out.println("To remove an item, type in the enumeration for the item of your choice: \n");
			            
		        	    Scanner scanner_for_removal = new Scanner(System.in);
			   		    Integer del_enum_item = scanner_for_removal.nextInt();
			   		    
			   		    my_inventory.removeFromInventory(del_enum_item);
			   		    
			   		    break;
			   		    
		         case 4 :
		        	 
			        	System.out.println("Your inventory: \n ");
		               
			        	u_inventory = my_inventory.getUserInventory();
			        	num_of_items = my_inventory.getNumItems();
			        	
			        	if(num_of_items > 1){
			        		System.out.println("You have " + Integer.toString(num_of_items) + " items in your inventory. \n ");
			        	}
			        	else if(num_of_items == 1){
			        		System.out.println("You have " + Integer.toString(num_of_items) + " item in your inventory. \n ");
			        	}
			        	else{
			        		System.out.println("You have no items in your inventory. \n ");
			        	}
		                System.out.println(u_inventory.entrySet());
			        	System.out.println("\n ");
			        	
			        	break;
			        	
		         case 5 :
		        	 
		        	 	System.out.println("Your basket value is: " + my_inventory.calcTotalPrice() + " $ \n");
		        	 	break;
		        	 	
		         default :
			            System.out.println("No option is selected!");
			            System.out.println("\n ");
			            
			            break;
	      }
		}      
	   }
	 
	 public static void splash(){
		 System.out.println("1. View all items: \n ");
		 System.out.println("2. Add an item to your inventory: \n ");
		 System.out.println("3. Remove an item from your inventory: \n ");
		 System.out.println("4. View your inventory: \n ");
		 System.out.println("5. View your basket value: \n ");
	 }
}

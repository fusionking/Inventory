package MainInventory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {

	private int num_items;
	private int total_price;
	
	private static HashMap<String,Integer> items;
	private static HashMap<Integer,String> enum_of_item;
	private static HashMap<String,Integer> user_inventory;
	
	
	private static String[] keys = {
			"1,Samsung Galaxy S4-40", 
			"2,Pepperoni Pizza-5", 
			"3,Lakers TShirt-15",
			"4,Motorola G6-80",
			"5,Macaroni-4",
			"6,Lenovo Y50-1000",
			"7,MacBook Pro-3000",
			"8,Gibson Standard Guitar-5000",
			"9,Pasabahce Ceramic-90"};
	
	public Inventory()
	{
		num_items = 0;
		items = new HashMap<String,Integer>();
		enum_of_item = new HashMap<Integer,String>();
		user_inventory = new HashMap<String,Integer>();
		total_price = 0;
		fillItemsList();
		setTotalPrice();
	}
	
	public Inventory(int num,HashMap<String,Integer> it,int total)
	{
		num_items = num;
		items = it;
		enum_of_item = new HashMap<Integer,String>();
		user_inventory = new HashMap<String,Integer>();
		total_price = total;
		fillItemsList();
		setTotalPrice();
	}
	public Integer getNumItems()
	{
		return num_items;
	}
	public HashMap<String,Integer> getItems()
	{
		return items;
	}
	public HashMap<String,Integer> getUserInventory()
	{
		return user_inventory;
	}
	public Integer getTotalPrice()
	{
		return total_price;
	}
	public Integer getIndividualPrice(String itemName)
	{
		return items.get(itemName);
	}
	public static String getNameFromEnum(Integer e_num)
	{
		return enum_of_item.get(e_num);
	}
	
	//Setters
	public void setItems(HashMap<String,Integer> it)
	{
		items = it;
	}
	public void setTotalPrice()
	{
		total_price = calcTotalPrice();
	}
	public void setUserInventory(HashMap<String,Integer> u)
	{
		user_inventory = u;
	}
	
	//Calculate total basket value
	public int calcTotalPrice()
	{
		int total = 0;
		for (Integer value : user_inventory.values()) {
		    total += value;
		}
		return total;
	}
	
	//Fill initial instance attributes
	private static void fillItemsList()
	{
		for( int i = 0; i < keys.length - 1; i++)
		{
		    String[] parts = keys[i].split("-");
		    String name = parts[0];
		    Integer price = Integer.parseInt(parts[1]); 
		    
		    String[] enums = parts[0].split(",");
		    enum_of_item.put(Integer.parseInt(enums[0]),name);
		    items.put(name, price);
		}
		
	}
	
	//Add to user inventory
	public void addToInventory(Integer enum_item) {
		String name = getNameFromEnum(enum_item);
		if(name == null){
			System.out.println("The product you request to add does not exist in the inventory \n");
		}
		else{
			Integer price = items.get(name);
			
			user_inventory.put(name, price);
			num_items ++;
		}
		
	}
	
	//Remove from user inventory
	public void removeFromInventory(Integer enum_item) {
		String name = getNameFromEnum(enum_item);
		if(name == null || user_inventory.get(name) == null){
			System.out.println("The product you request to remove does not exist in the inventory or in items \n");
		}
		else{
			user_inventory.remove(name);
			num_items--;
		}
		
	}
	
}

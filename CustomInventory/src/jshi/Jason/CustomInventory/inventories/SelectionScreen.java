package jshi.Jason.CustomInventory.inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class SelectionScreen implements InventoryHolder{
	
	private Inventory inv;
	
	public SelectionScreen()
	{
		inv = Bukkit.createInventory(this, 9, "SelectionScreen"); //increments of 9
	}
	
	@Override
	public Inventory getInventory() {
		return inv;
	}
	
}

package jshi.Jason.ChangeTeam;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public Inventory inv;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		createInv();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ChangeTeam]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ChangeTeam]: Plugin is Disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(label.equals("changeteam"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You are not the player");
				return true;
			}
			Player player = (Player) sender;
			// Open GUI
			player.openInventory(inv);
			return true;
		}
		return false;
	}
	
	public void createInv()
	{
		inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Select Team"); //can only go by 9, 18, 27
		
		ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
		ItemMeta meta = item.getItemMeta();
		
		//Blue Team
		meta.setDisplayName(ChatColor.DARK_BLUE + "BLUE TEAM");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Click to join team");
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inv.setItem(0, item);


		//Red Team
		item.setType(Material.RED_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_RED + "RED TEAM");
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		//Green Team
		item.setType(Material.LIME_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_GREEN + "LIME TEAM");
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		//Orange Team
		item.setType(Material.ORANGE_CONCRETE);
		meta.setDisplayName(ChatColor.GOLD + "ORANGE TEAM");
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		//Purple Team
		item.setType(Material.PURPLE_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_PURPLE + "PURPLE TEAM");
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		//Cyan Team
		item.setType(Material.CYAN_CONCRETE);
		meta.setDisplayName(ChatColor.BLUE + "CYAN TEAM");
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		//Black Team
		item.setType(Material.BLACK_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_GRAY + "BLACK TEAM");
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		
		//Close button
		item.setType(Material.RED_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(8, item);
	}
	
	
	@EventHandler
	public void onClick(InventoryClickEvent event) //click on any item in the chest, shulker box, crafting table, and etc.
	{
		if(!event.getInventory().equals(inv))
		{
			return;
		}
		if(event.getCurrentItem() == null)
		{
			return;
		}
		if(event.getCurrentItem().getItemMeta() == null)
		{
			return;
		}
		if(event.getCurrentItem().getItemMeta().getDisplayName() == null)
		{
			return;
		}
		
		
		//Conditions are met
		event.setCancelled(true); //don't pick up the item from the inventory, it's clicked only
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getSlot() == 0)
		{
			//blue team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.BLUE, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		if(event.getSlot() == 1)
		{
			//red team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.RED, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		if(event.getSlot() == 2)
		{
			//green team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.LIME, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		if(event.getSlot() == 3)
		{
			//orange team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.ORANGE, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		if(event.getSlot() == 4)
		{
			//purple team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.PURPLE, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		if(event.getSlot() == 5)
		{
			//cyan team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.AQUA, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		if(event.getSlot() == 6)
		{
			//black team
			ItemStack[] armor = player.getEquipment().getArmorContents(); //good to know putting on armor is an IteamStack array
			armor = changeColor(armor, Color.BLACK, player);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team");
		}
		
		if(event.getSlot() == 8)
		{
			player.closeInventory();
		}
		return;
	}
	
	public ItemStack[] changeColor(ItemStack[] a, Color color, Player p)
	{
		for(ItemStack item: a)
		{
			try
			{
				if(item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_LEGGINGS|| item.getType() == Material.LEATHER_CHESTPLATE || item.getType() == Material.LEATHER_HELMET)
				{
					LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
					meta.setColor(color);
					item.setItemMeta(meta);
				}
			}
			catch(Exception e)
			{
				// do nothing
				p.sendMessage(ChatColor.RED + "You are not wearing lether armor :/");
			}
		}
		return a;
	}
}

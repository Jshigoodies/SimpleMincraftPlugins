package jshi.Jason.PrivateVault;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public static Map<String, ItemStack[]> menus = new HashMap<String, ItemStack[]>();
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.saveDefaultConfig(); // <-- create config.yml
		
		if(this.getConfig().contains("data"))
		{
			this.restoreInvs();
		}
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[PrivateVault]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		if(!menus.isEmpty())
		{
			this.saveInvs();
		}
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[PrivateVault]: Plugin is Disabled");
	}
	
	public void saveInvs()
	{
		for(Map.Entry<String, ItemStack[]> entry : menus.entrySet())
		{
			this.getConfig().set("data." + entry.getKey(), entry.getValue());
		}
		this.saveConfig();
	}
	
	public void restoreInvs()
	{
		this.getConfig().getConfigurationSection("data").getKeys(false).forEach(key ->{
			@SuppressWarnings("unchecked")
			ItemStack[] content = ((List<ItemStack>) this.getConfig().get("data." + key)).toArray(new ItemStack[0]); //all the items
			menus.put(key,  content);
		});
	}
	
	// /pv
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("pv"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "No");
				return true;
			}
			
			Player player = (Player) sender;
			Inventory inv = Bukkit.createInventory(player, 54, player.getName() + "'s Private Vault");
			if(menus.containsKey(player.getUniqueId().toString()))
			{
				// have info in the hashmap
				inv.setContents(menus.get(player.getUniqueId().toString()));
			}
			player.openInventory(inv);
			return true;
			
		}
		return false;
	}
	
	@EventHandler
	public void onGUIClose(InventoryCloseEvent event)
	{
		if(event.getView().getTitle().contains(event.getPlayer().getName() + "'s Private Vault"))
		{
			menus.put(event.getPlayer().getUniqueId().toString(), event.getInventory().getContents());
		}
	}
}

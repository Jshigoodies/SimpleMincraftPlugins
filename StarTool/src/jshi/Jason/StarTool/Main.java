package jshi.Jason.StarTool;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.StarTool.events.EventStarTool;

public class Main extends JavaPlugin{
	//ctrl + space for templates
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new EventStarTool(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[StarTool]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[StarTool]: Plugin is Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("startool"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.DARK_RED + "You cannot run this command");
				return true;
			}
			
			Player player = (Player) sender;
			
			if(player.getInventory().firstEmpty() == -1) //inventory not empty
			{
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "Here ya go!");
				return true;
			}
			//inventory empty
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "Here ya go!");
			return true;
		}
		return false;
	}
	
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.TRIDENT);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Ancient Trident");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click) &a&oSpawn minions"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click) &a&oShoot fireballs"));
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.LOYALTY, 10, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		item.setItemMeta(meta);
		
		return item;
	}
		
}

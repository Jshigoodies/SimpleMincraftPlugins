package jshi.Jason.GodBoots;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	@Override
	public void onEnable() 
	{
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GodBoots]: Plugin is Enabled");
	}
	@Override
	public void onDisable() 
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GodBoots]: Plugin is Disabled");
	}
}

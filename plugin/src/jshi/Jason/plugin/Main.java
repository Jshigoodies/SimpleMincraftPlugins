package jshi.Jason.plugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "Plugin is Enabled");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin is Disabled");
	}
}

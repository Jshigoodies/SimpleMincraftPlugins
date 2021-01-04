package jshi.Jason.CustomSword;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	@Override
	public void onEnable()
	{
		this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CustomSword]: Plugin is Enabled");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CustomSword]: Plugin is Disabled");
	}
}

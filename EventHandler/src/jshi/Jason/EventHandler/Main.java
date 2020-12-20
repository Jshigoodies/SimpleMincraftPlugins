package jshi.Jason.EventHandler;

import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.EventHandler.events.Events;

import org.bukkit.ChatColor;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new Events(), this); //pass in the event class and itself
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[EventHandler]: Plugin is Enabled");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[EventHandler]: Plugin is Disabled");
	}

}

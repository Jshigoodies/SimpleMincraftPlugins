package jshi.Jason.CommandsHandler;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.CommandsHandler.commands.SimpleCommands;

public class Main extends JavaPlugin{
	@Override
	public void onEnable()
	{
		SimpleCommands commands = new SimpleCommands();
		getCommand("heal").setExecutor(commands);
		getCommand("feed").setExecutor(commands);
		getCommand("farmtime").setExecutor(commands);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CommandsHandler]: Plugin is Enabled");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CommandsHandler]: Plugin is Disabled");
	}
}

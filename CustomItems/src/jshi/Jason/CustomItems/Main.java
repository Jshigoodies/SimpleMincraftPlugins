package jshi.Jason.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.CustomItems.Commands.ItemCommands;
import jshi.Jason.CustomItems.Items.ItemManager;
import jshi.Jason.CustomItems.events.EventManager;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable()
	{
		ItemManager.init();
		getCommand("givewand").setExecutor(new ItemCommands());
		getServer().getPluginManager().registerEvents(new EventManager(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CustomItems]: Plugin is Enabled");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CustomItems]: Plugin is Disabled");
	}
	
}

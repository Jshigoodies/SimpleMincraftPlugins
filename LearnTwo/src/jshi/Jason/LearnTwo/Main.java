package jshi.Jason.LearnTwo;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable()
	{
		this.getCommand("Doctor").setExecutor(new Heal());
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[LearnTwo]: Plugin is Enabled");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[LearnTwo]: Plugin is Disabled");
	}
}

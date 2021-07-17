package jshi.Jason.Stats;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		this.getCommand("mystats").setExecutor(new StatCommand());
		this.getCommand("mystats").setTabCompleter(new StatTab());
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Stats]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Stats]: Plugin is Disabled");
	}
}

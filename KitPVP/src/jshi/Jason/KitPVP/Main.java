package jshi.Jason.KitPVP;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.KitPVP.commands.Commands;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		Commands cmds = new Commands();
		getCommand("kit").setExecutor(cmds);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[KitPVP]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[KitPVP]: Plugin is Disabled");
	}
}

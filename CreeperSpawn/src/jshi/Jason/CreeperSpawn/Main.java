package jshi.Jason.CreeperSpawn;

import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.CreeperSpawn.commands.CreeperCommand;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() 
	{
		new CreeperCommand(this);
	}
}

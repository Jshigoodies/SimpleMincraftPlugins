package jshi.Jason.StarTool.events;

import org.bukkit.event.Listener;

import jshi.Jason.StarTool.Main;

public class StarEvents implements Listener{
	static Main plugin;
	public StarEvents(Main instance) //constructor
	{
		plugin = instance;
	}
	//don't really need this, it's just a way to access stuff from the main class. So I should make the outline like this from now on.
}

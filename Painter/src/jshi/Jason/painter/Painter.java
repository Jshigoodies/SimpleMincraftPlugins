package jshi.Jason.painter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Painter extends JavaPlugin{
	
	private List<Player> painters = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		this.getCommand("painter").setExecutor(new PaintCommand(this));
		this.getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Painter]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Painter]: Plugin is Disabled");
	}
	
	
	public void addPainter(Player player)
	{
		painters.add(player);
	}
	public void removePainter(Player player)
	{
		painters.remove(player);
	}
	
	public List<Player> getPainters()
	{
		return painters;
	}
	
	public boolean hasPainters()
	{
		if(painters.isEmpty()) {
			return false;
		}
		return true;
	}
}

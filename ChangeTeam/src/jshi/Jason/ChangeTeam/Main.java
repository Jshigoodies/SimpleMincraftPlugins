package jshi.Jason.ChangeTeam;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public Inventory inv;
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ChangeTeam]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ChangeTeam]: Plugin is Disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(label.equals("changeteam"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You are not the player");
				return true;
			}
			Player player = (Player) sender;
			// Open GUI
			
		}
		return false;
	}
}

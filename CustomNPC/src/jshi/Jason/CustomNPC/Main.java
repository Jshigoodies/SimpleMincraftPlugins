package jshi.Jason.CustomNPC;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CustomNPC]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CustomNPC]: Plugin is Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("createnpc"))
		{
			if(!(sender instanceof Player)) {
				return true;
			}
			
			Player player = (Player) sender;
			NPC.createNPC(player);
			player.sendMessage("NPC Created");
		}
		return false;
	}
}

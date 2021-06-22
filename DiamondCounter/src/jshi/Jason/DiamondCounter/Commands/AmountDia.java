package jshi.Jason.DiamondCounter.Commands;


import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jshi.Jason.DiamondCounter.Files.DataManager;
import net.md_5.bungee.api.ChatColor;

public class AmountDia implements CommandExecutor{
	
	private DataManager data;
	
	public AmountDia(DataManager data)
	{
		this.data = data;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int index = -1;
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			//set up
			
			if(cmd.getName().equalsIgnoreCase("diamonds"))
			{
				if(args.length == 1)
				{
					List<Player> list = player.getWorld().getPlayers();
					for(int i = 0; i < list.size(); i++)
					{
						if(list.get(i).getName().equalsIgnoreCase(args[0]))
						{
							index = i;
							break;
						}
					}
					if(index == -1)
					{
						player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "player not found");
					}
					else
					{
						int num = data.getConfig().getInt("player." + list.get(index).getUniqueId().toString() + ".total");
						player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have collected " + num + " diamonds!");
						return true;
					}
					
				}
				else
				{
					int num = data.getConfig().getInt("player." + player.getUniqueId().toString() + ".total");
					player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have collected " + num + " diamonds!");
					return true;
				}
			}
		}
		
		return false;
	}
}

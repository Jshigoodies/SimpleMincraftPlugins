package jshi.Jason.Stats;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class StatCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("mystats"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "you are not the player");
				return true;
			}
			
			Player player = (Player) sender;
			if(args.length == 0)
			{
				player.sendMessage(ChatColor.RED + "Usage: /mystats {deaths/logins/mobKills/playerKills}");
			}
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("deaths"))
				{
					player.sendMessage(ChatColor.AQUA + "You have " + player.getStatistic(Statistic.DEATHS) + " deaths");
					return true;
				}
				if(args[0].equalsIgnoreCase("logins"))
				{
					player.sendMessage(ChatColor.AQUA + "You have " + (player.getStatistic(Statistic.LEAVE_GAME) + 1) + " total logins");
					return true;
				}
				if(args[0].equalsIgnoreCase("mobKills"))
				{
					player.sendMessage(ChatColor.AQUA + "You have " + player.getStatistic(Statistic.MOB_KILLS) + " mob kills");
					return true;
				}
				if(args[0].equalsIgnoreCase("playerKills"))
				{
					player.sendMessage(ChatColor.AQUA + "You have " + player.getStatistic(Statistic.PLAYER_KILLS) + " player kills");
					return true;
				}
			}
		}
		return false;
	}

}

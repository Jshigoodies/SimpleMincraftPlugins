package jshi.Jason.LearnOne;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(label.equalsIgnoreCase("launch"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("*console goes flying*");
				return true;
			}
			Player p = (Player) sender;
			// /launch     
			if(args.length == 0)
			{
				p.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Zoooom!");
				p.setVelocity(p.getLocation().getDirection().multiply(2).setY(2)); 
				return true;
			}
			
			//  /launch <number>
			if(isNum(args[0]))
			{
				p.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Zoooom!");
				p.setVelocity(p.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2)); // /launch does not count as the first argument
			}
			else
			{
				p.sendMessage(ChatColor.RED + "Usage: /launch <nubmer-value>");
			}
			
		}
		return false;
	}
	
	public boolean isNum(String num)
	{
		try
		{
			Integer.parseInt(num);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

}

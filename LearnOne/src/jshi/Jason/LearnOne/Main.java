package jshi.Jason.LearnOne;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[LearnOne]: Plugin is Enabled");
		//I do not need the getCommand() method because the commands are in the same class
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[LearnOne]: Plugin is Disabled");
	}
	
	//commands - I know it's in the same class = lazy
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
			// /launch     /launch <number>
			if(args.length == 0)
			{
				p.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Zoooom!");
				p.setVelocity(p.getLocation().getDirection().multiply(2).setY(2)); 
				return true;
			}
			p.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Zoooom!");
			p.setVelocity(p.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2)); // /launch does not count as the first argument
		}
		return true;
	}
}
//https://www.youtube.com/watch?v=6Fl2KFsSVsU&list=PL65-DKRLvp3Yn7iglPfxKoc7bl0N80XgG&index=3

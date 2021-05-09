package jshi.Jason.painter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class PaintCommand implements CommandExecutor{
	
	private Painter plugin;
	public PaintCommand(Painter _plugin)
	{
		this.plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player))
		{
			// console
			sender.sendMessage(ChatColor.RED + "Only players can run this command");
			return true;
		}
		Player player = (Player) sender;
		if(plugin.hasPainters()) //can be multiple painters
		{
			if(plugin.getPainters().contains(player)) //if he was an artist, then he can stop being it
			{
				// remove player
				plugin.removePainter(player);
				player.sendMessage(ChatColor.RED + "You are no longer painting");
				return true;
			}
		}
		// add painter
		plugin.addPainter(player); // become an artist
		player.sendMessage(ChatColor.GREEN + "You are a painter");
		if(args.length == 1 && args[0].equals("brush"))
		{
			plugin.setBrushType(true);
			player.sendMessage(ChatColor.GREEN + "You are using a brush");
		}
		else
		{
			plugin.setBrushType(false);
			player.sendMessage(ChatColor.RED + "You are not using a brush");
		}
		return true;
		
	}
	
}

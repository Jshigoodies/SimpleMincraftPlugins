package jshi.Jason.CustomItems.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jshi.Jason.CustomItems.Items.ItemManager;

public class ItemCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player))
		{
			sender.sendMessage("§6only players can send this command!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("givewand"))
		{
			player.getInventory().addItem(ItemManager.wand);
		}
		return true;
	}
	
}

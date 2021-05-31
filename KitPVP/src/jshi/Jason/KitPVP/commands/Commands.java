package jshi.Jason.KitPVP.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import jshi.Jason.KitPVP.TheKit;

public class Commands implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("kit"))
			{
				player.getInventory().clear(); // fk you. I'm doing it
				TheKit kitpvp = new TheKit();
				
				ItemStack[] armor = kitpvp.getArmor();
				ItemStack[] items = kitpvp.getItems();
				
				player.getEquipment().setArmorContents(armor);
				
				for(int i = 0; i < items.length; i++)
				{
					player.getInventory().addItem(items[i]);
				}
				return true;
			}
		}
		
		return false;
	}
}

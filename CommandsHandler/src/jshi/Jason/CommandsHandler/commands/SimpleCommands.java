package jshi.Jason.CommandsHandler.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SimpleCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You are not a player");
			return true;
		}
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("heal"))
		{
			double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
			//Attribute means qualities associated with the player
			
			player.setHealth(maxHealth);
			player.sendMessage("§e§l(!)You have been healed!");
		}
		
		else if(cmd.getName().equalsIgnoreCase("feed"))
		{
			player.setFoodLevel(20);
			player.sendMessage("§e§l(!)You have been fed!");
			//ascii # is 0167 = §
		}
		
		else if(cmd.getName().equalsIgnoreCase("farmtime"))
		{
			// /farmtime CHICKEN 5
			if(args.length >= 2)
			{
				try 
				{
					EntityType entity = EntityType.valueOf(args[0].toUpperCase());
					int amount = Integer.parseInt(args[1]);
					
					for(int i = 0; i<amount; i++)
					{
						player.getWorld().spawnEntity(player.getLocation(), entity);
					}
				}
				catch(IllegalArgumentException e)
				{
					player.sendMessage("§c§l(!) That is not a valid entity!");
				}
					
			}
			else
			{
				player.sendMessage("§c§l(!) §c/farmtime <mob> <amount>");
			}
		}
		
		return true;
	}
	
}

package jshi.Jason.Skull;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Skull]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Skull]: Plugin is Disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(label.equalsIgnoreCase("skull"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("You are not player");
				return true;
			}
			
			Player player = (Player) sender;
			World w = player.getWorld();
			Location loc = player.getLocation();
			
			if(args.length == 0) // /skull <-- give player their head
			{

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You have been given the skull of &c" + player.getName()));
				if(player.getInventory().isEmpty() == false)
				{
					w.dropItem(loc, getPlayerHead(player.getName()));
				}
				else
				{
					player.getInventory().addItem(getPlayerHead(player.getName()));
				}
			}
			
			if(args.length == 1) // /skull <player>
			{
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You have been given the skull of &c" + args[0]));
				if(player.getInventory().isEmpty() == false)
				{
					w.dropItem(loc, getPlayerHead(args[0]));
				}
				else
				{
					player.getInventory().addItem(getPlayerHead(args[0]));
				}
			}
			
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	private ItemStack getPlayerHead(String playerName) {
		// TODO Auto-generated method stub
		boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD"); // are they running 1.8 and below or 1.9 and above
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL ITEM");
		ItemStack item = new ItemStack(type, 1);
		
		if(!isNewVersion)
		{
			item.setDurability((short) 3);
		}
		
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(playerName);
		
		item.setItemMeta(meta);
		
		return item;
	}
}

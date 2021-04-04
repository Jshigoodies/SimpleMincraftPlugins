package jshi.Jason.GodBoots;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() 
	{
		this.getServer().getPluginManager().registerEvents(this, this); //it's literally all in one java file, so...
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GodBoots]: Plugin is Enabled");
	}
	@Override
	public void onDisable() 
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GodBoots]: Plugin is Disabled");
	}
	
	//command to get boots
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("godboots"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("you are not the player");
				return true;
			}
			Player player = (Player) sender;
			
			if(player.getInventory().firstEmpty() == -1)
			{
				//inventory is full
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItem(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "Here you go :D");
				return true;
				
			}
			
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "Here you go :D");
			return true;
		}
		return false;
	}
	
	//boots item
	public ItemStack getItem()
	{
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta(); //item information, you can add lore, a enchantment, etc. to the boots
		
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of leaping");
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Boots for Gods");
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		meta.setUnbreakable(true);
		
		boots.setItemMeta(meta);
		
		return boots;
	}
	
	//event
	@EventHandler
	public void onJump(PlayerMoveEvent event)
	{
		Player player = (Player) event.getPlayer();
		if(player.getInventory().getBoots() != null) //do they have boots
		{
			if(player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of leaping")) //does the boots have a name called Boots of Leaping
			{
				if(player.getInventory().getBoots().getItemMeta().hasLore()) //does the boots have lore
				{
					if(event.getFrom().getY() < event.getTo().getY() &&
							player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) //is the player jumping? and is the jumping from a block
					{
						player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
					}
				}
			}
		}
	}
	@EventHandler
	public void onFall(EntityDamageEvent event)
	{
		if(event.getEntity() instanceof Player) //is it the player that is taking damage
		{
			Player player = (Player) event.getEntity();
			
			if(event.getCause() == DamageCause.FALL) //damage by falling
			{
				if(player.getInventory().getBoots() != null) //do they have boots
				{
					if(player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of leaping")) //does the boots have a name called Boots of Leaping
					{
						if(player.getInventory().getBoots().getItemMeta().hasLore()) //does the boots have lore
						{
							event.setCancelled(true);
						}
					}
			
				}
			}
		}
	}
}

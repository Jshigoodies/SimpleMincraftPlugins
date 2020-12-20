package jshi.Jason.EventHandler.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener{
	
	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.AQUA + "Welcome " + player.getName() + "!");
	}
	
	@EventHandler
	public static void onPlayerWalk(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		Material block = player.getWorld().getBlockAt(x, y-1, z).getType();
		
		if(block == Material.DIAMOND_ORE)
		{
			player.sendMessage(ChatColor.GOLD + player.getName() + " Found Diamonds!!!");
		}
	}
	
	@EventHandler
	public static void onPlayerThrowEgg(PlayerEggThrowEvent event)
	{
		event.setHatching(true);
		
		event.setHatchingType(EntityType.BEE); //This is an instance variable that is a static final variable from the EntityType class
		
		byte num = 20;
		event.setNumHatches(num);
	}
	
	@EventHandler
	public static void onPlayerBowShot(EntityShootBowEvent event)
	{
		/*
		 * Nothing Here
		 */
	}
	
	@EventHandler
	public static void onPlayerEnterBed(PlayerBedEnterEvent event)
	{
		Player player = event.getPlayer();
		player.kickPlayer("No sleeping in this Server");
	}

}

package jshi.Jason.StarTool.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventStarTool implements Listener{
	
	public static List<String> list = new ArrayList<String>(); //what this does: tridents charge up. So we add the player's name to the list and after the trident lands. remove them after zombies spawn.
	
	@EventHandler
	public static void onClick(PlayerInteractEvent event)
	{
		//I thought it would be better up here, since i throw a trident once = adds me to list 2nd throw = removes me from list. I honestly don't see the point of this.
		if(list.contains(event.getPlayer().getName()))
		{
			list.remove(event.getPlayer().getName());
		}
		if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.TRIDENT))
		{
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				
				//Right Click
				if(event.getAction() == Action.RIGHT_CLICK_AIR)
				{
					if(!(list.contains(player.getName())))
					{
						list.add(player.getName());
						return;
					}
				}
				
				//Left Click
				if(event.getAction() == Action.LEFT_CLICK_AIR)
				{
					player.launchProjectile(Fireball.class);
				}
			
			}
			
			//separate Tridents from other Tridents. Making sure you don't just throw a normal Trident
//			if(list.contains(event.getPlayer().getName()))
//			{
//				list.remove(event.getPlayer().getName());
//			}
		}
	}
	
	@EventHandler
	public static void onLand(ProjectileHitEvent event) //when the trident is thrown
	{
		if(event.getEntityType() == EntityType.TRIDENT)
		{
			if(event.getEntity().getShooter() instanceof Player) //make sure it's not the drowned mobs throwing tridents
			{
				Player player = (Player) event.getEntity().getShooter();
				if(list.contains(player.getName())) //if it's the 'chosen one' spawn the zombies
				{
					Location loc = event.getEntity().getLocation();
					loc.setY(loc.getY() + 1);
					
					//spawn zombies
					for(int i = 0; i<3; i++)
					{
						loc.getWorld().spawnEntity(loc, EntityType.DROWNED);
						
						//spread out
						loc.setX(loc.getX() + i);
					}
				}
			}
		}
	}
}

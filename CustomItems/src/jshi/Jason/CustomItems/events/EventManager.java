package jshi.Jason.CustomItems.events;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import jshi.Jason.CustomItems.Items.ItemManager;

public class EventManager implements Listener{
	
	@EventHandler
	public static void onRightClick(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if(event.getItem() != null)
			{
				if(event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta()))
				{
					Player player = event.getPlayer();
					player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 100);
					player.getWorld().createExplosion(player.getLocation(), 3.0f);
					player.sendMessage("§8EXPLOSION");
				}
			}
		}
	}
	
}

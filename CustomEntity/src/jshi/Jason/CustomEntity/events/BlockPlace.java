package jshi.Jason.CustomEntity.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import jshi.Jason.CustomEntity.Main;
import jshi.Jason.CustomEntity.mobs.Theif;
import net.minecraft.server.v1_16_R3.WorldServer;

public class BlockPlace implements Listener{
	
	private Main plugin;
	
	public BlockPlace(Main _plugin)
	{
		this.plugin = _plugin;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event)
	{
		if(!event.getBlock().getType().equals(Material.GOLD_BLOCK))
		{
			return;
		}
		
		Random r = new Random();
		if((r.nextInt(1000 + 0) - 0) > 100) //10% chance
		{
			return; 
		}
		
		Theif dirtyjoe = new Theif(event.getPlayer().getLocation());
		
		WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
		
		world.addEntity(dirtyjoe);
		
		event.setCancelled(true);
		
		for(ItemStack item : event.getPlayer().getInventory().getContents())
		{
			plugin.stolen.add(item);
		}
		
		event.getPlayer().getInventory().clear();
	}
}

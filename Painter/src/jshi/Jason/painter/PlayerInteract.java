package jshi.Jason.painter;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener{
	private Painter plugin;
	
	public PlayerInteract(Painter _plugin)
	{
		this.plugin = _plugin;
	}
	
	@EventHandler
	public void onPaint(PlayerInteractEvent event)
	{
		if(!(event.hasItem()))
		{
			return;
		}
		if(!event.getItem().getType().isBlock())
		{
			return;
		}
		if(!plugin.hasPainters())
		{
			return;
		}
		if(!plugin.getPainters().contains(event.getPlayer()))
		{
			return;
		}
		
		if(event.getPlayer().rayTraceBlocks(50) == null) //50 block radius | null is for air blocks, you can't paint the air, you have to make sure you are painting over an actual block
		{
			return;
		}
		
		//They are a painter with a legal amount of distance
		event.setCancelled(true);
		
		Block block = event.getPlayer().rayTraceBlocks(50).getHitBlock(); //block the player is looking at
		block.setType(event.getItem().getType()); //set the block that the player is looking at to the block in the player's hand
		return;
	}
}

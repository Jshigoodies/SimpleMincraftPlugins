package jshi.Jason.painter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener{
	private Painter plugin;
	
	private List<Block> list = new ArrayList<Block>();
	
	public PlayerInteract(Painter _plugin)
	{
		this.plugin = _plugin;
	}
	
	@EventHandler
	public void onPaint(PlayerInteractEvent event) //if the player does anything like place a block on another block or even hit a block
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
		
		World w = event.getPlayer().getWorld();
		
		if(plugin.getBrushType() == true)
		{
			Block block = event.getPlayer().rayTraceBlocks(50).getHitBlock(); //block the player is looking at | basically the center
			Location up = block.getLocation();
			up.setY(up.getY() + 1);
			Location right = block.getLocation();
			right.setX(right.getX() + 1);
			Location down = block.getLocation();
			down.setY(down.getY() - 1);
			Location left = block.getLocation();
			left.setX(left.getX() - 1);
			Location zAxisRight = block.getLocation();
			zAxisRight.setZ(zAxisRight.getZ() + 1);
			Location zAxisLeft = block.getLocation();
			zAxisLeft.setZ(zAxisLeft.getZ() - 1);
			
			
			
			Block blockOne = w.getBlockAt(up);
			Block blockTwo = w.getBlockAt(right);
			Block blockThree = w.getBlockAt(down);
			Block blockFour = w.getBlockAt(left);
			Block blockFive = w.getBlockAt(zAxisRight);
			Block blockSix = w.getBlockAt(zAxisLeft);
			
			list.add(block); //center
			//every block around it
			list.add(blockOne);
			list.add(blockTwo);
			list.add(blockThree);
			list.add(blockFour);
			list.add(blockFive);
			list.add(blockSix);
			
			if(!plugin.lazyConditionVariable) //lol
			{
				for(int i = 0; i<list.size(); i ++)
				{
					if(!list.get(i).isEmpty()) //make sure it's not fking air
					{
						list.get(i).setType(event.getItem().getType());
					}
				}
			}
			else //so i can build in minecraft
			{
				for(int i = 0; i<list.size(); i ++)
				{
					list.get(i).setType(event.getItem().getType());
				}
			}
			list.clear(); //i can't have the same blocks changing. I can add every block to the list and they will never be removed, so i have to do clear() method.
		}
		else
		{
			Block block = event.getPlayer().rayTraceBlocks(50).getHitBlock(); //block the player is looking at
			block.setType(event.getItem().getType()); //set the block that the player is looking at to the block in the player's hand
		}
		return;
	}
}

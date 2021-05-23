package jshi.Jason.MachFiveMobs;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.MachFiveMobs.mobs.CustomEntitySkeleton;
import net.minecraft.server.v1_16_R3.WorldServer;

public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MachFiveMobs]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MachFiveMobs]: Plugin is Disabled");
	}
	
	@EventHandler
	public void mobSpawn(CreatureSpawnEvent e)
	{
		if(e.getEntity() instanceof Skeleton)
		{
			CustomEntitySkeleton fastSkele = new CustomEntitySkeleton(e.getLocation());
			WorldServer world = ((CraftWorld) e.getEntity().getWorld()).getHandle();
			world.addEntity(fastSkele);
			
		}
	}
}

package jshi.Jason.MachFiveMobs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.MachFiveMobs.mobs.CustomEntitySkeleton;
import jshi.Jason.MachFiveMobs.mobs.CustomEntityZombie;
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
	public void mobSpawn(EntitySpawnEvent e)
	{
		if(!(e.getEntity() instanceof Zombie))
		{
			return;
		}
//		CustomEntitySkeleton fastSkele = new CustomEntitySkeleton(e.getLocation());
//		WorldServer world = ((CraftWorld) e.getEntity().getWorld()).getHandle();
//		world.addEntity(fastSkele);
		
//		CustomEntityZombie fastZom = new CustomEntityZombie(e.getLocation());
//		WorldServer world = ((CraftWorld) e.getEntity().getWorld()).getHandle();
//		world.addEntity(fastZom);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player))
		{
			return true;
		}
		if(label.equalsIgnoreCase("zombie"))
		{
			Player player = (Player) sender;
			CustomEntityZombie fastZom = new CustomEntityZombie(player.getLocation());
			WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
			world.addEntity(fastZom);
			return true;
		}
		return false;
	}
}

package jshi.Jason.MachFiveMobs.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityZombie;

public class CustomEntityZombie extends EntityZombie{
	public CustomEntityZombie(Location loc)
	{
		super(EntityTypes.ZOMBIE,  ((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		this.setCustomName(new ChatComponentText(ChatColor.DARK_RED + "Zombie :D:D:D:D:D"));
		this.setCustomNameVisible(true);
		this.glowing = false;
		
		this.canPickUpLoot = true;
		this.setSprinting(true);
		this.D = 100.0;
	}
}

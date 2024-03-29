package jshi.Jason.MachFiveMobs.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntitySkeleton;
import net.minecraft.server.v1_16_R3.EntityTypes;

public class CustomEntitySkeleton extends EntitySkeleton{

	public CustomEntitySkeleton(Location loc) {
		super(EntityTypes.SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		this.setCustomName(new ChatComponentText(ChatColor.RED + "" + ChatColor.BOLD + "CUSTOM_MOB"));
		this.setCustomNameVisible(true);
	}

}

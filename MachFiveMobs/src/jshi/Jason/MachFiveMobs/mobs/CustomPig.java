package jshi.Jason.MachFiveMobs.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.EntityPig;
import net.minecraft.server.v1_16_R3.EntityTypes;

public class CustomPig extends EntityPig{

	public CustomPig(Location loc) {
		super(EntityTypes.PIG, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setSprinting(true);
	}

}

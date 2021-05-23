package jshi.Jason.CustomEntity;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.CustomEntity.events.BlockPlace;
import jshi.Jason.CustomEntity.events.EntityDamage;
import jshi.Jason.CustomEntity.events.EntityDeath;

public class Main extends JavaPlugin{
	
	public List<ItemStack> stolen = new ArrayList<>();
	
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new BlockPlace(this), this);
		pm.registerEvents(new EntityDeath(this), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CustomEntity]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CustomEntity]: Plugin is Disabled");
	}
}

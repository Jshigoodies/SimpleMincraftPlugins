package jshi.Jason.DiamondCounter;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.DiamondCounter.Commands.AmountDia;
import jshi.Jason.DiamondCounter.Files.DataManager;

public class Main extends JavaPlugin implements Listener{
	
	public DataManager data;
	
	@Override
	public void onEnable() {
		this.data = new DataManager(this);
		getCommand("diamonds").setExecutor(new AmountDia(this, data));
		this.getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[DiamondCounter]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[DiamondCounter]: Plugin is Disabled");
	}
	
	@EventHandler
	public void onBlocBreak(BlockBreakEvent event)
	{
		if(event.getBlock().getType().equals(Material.DIAMOND_ORE)) {
			Player player = event.getPlayer();
			if(player.getGameMode().equals(GameMode.CREATIVE))
			{
				return;
			}
			if(player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) 
			{
				return;
			}
			int amount = 0;
			
			if(this.data.getConfig().contains("players." + player.getName()))
			{
				amount = this.data.getConfig().getInt("players." + player.getName());
			}
			
			//data.getConfig().set("players." + player.getUniqueId().toString() + ".total", (amount + 1)); //it will write this
			data.getConfig().set("players." + player.getName(), (amount + 1));
			data.saveConfig();
		}
	}
}

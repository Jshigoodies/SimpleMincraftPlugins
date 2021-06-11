package jshi.Jason.RandomBlock;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[RandomBlock]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[RandomBlock]: Plugin is Disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("randomblock"))
		{
			if(!sender.hasPermission("randomblock.reload"))
			{
				sender.sendMessage(ChatColor.RED + "You cannot run this command");
				return true;
			}
			if(args.length == 0)
			{
				// /randomblock
				sender.sendMessage(ChatColor.RED + "Usage: /randomblock reload");
				return true;
			}
			if(args.length > 0)
			{
				if(args[0].equalsIgnoreCase("reload"))
				{
					// /randomblock reload
					
					//sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("reload.message")));
					for(String msg : this.getConfig().getStringList("reload.message"))
					{
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
					}
					this.reloadConfig();
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		// So it's going to find the word "blocks in the config file. If getKeys were true, that will loop through everything, even the item that type of block drops. If it was false. It would skip the item the block drops and only get the types of blocks.
		this.getConfig().getConfigurationSection("blocks").getKeys(false).forEach(key -> {
			//dirt
			if(key.equalsIgnoreCase(event.getBlock().getType().toString())) //if dirt block equals "DIRT" in configuration file
			{
				ItemStack[] items = new ItemStack[this.getConfig().getStringList("blocks." + key).size()];
				ItemStack item = null;
				int position = 0;
				Random r = new Random();
				for(String i : this.getConfig().getStringList("blocks." + key))
				{
					try {
						item = new ItemStack(Material.matchMaterial(i), r.nextInt(16));
					}
					catch(Exception e)
					{
						item = new ItemStack(Material.matchMaterial(key));
					}
					items[position] = item;
					position++;
				}
				int num = r.nextInt(items.length);
				event.setDropItems(false);
				World world = event.getPlayer().getWorld();
				world.dropItemNaturally(event.getBlock().getLocation(), items[num]);
			}
		});
	}

}

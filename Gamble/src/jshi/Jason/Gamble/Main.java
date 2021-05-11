package jshi.Jason.Gamble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import io.netty.util.internal.ThreadLocalRandom;

public class Main extends JavaPlugin{
	
	List<Inventory> invs = new ArrayList<Inventory>();
	public static ItemStack[] contents;
	private int itemIndex = 0;
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Gamble]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Gamble]: Plugin is Disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(label.equalsIgnoreCase("gamble"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "Console cannot gamble");
				return true;
			}
			
			Player player = (Player) sender;
			
			ItemStack fee = new ItemStack(Material.DIAMOND); //you pay with diamonds
			fee.setAmount(3); //3 diamonds
			
			if(player.getInventory().getItemInMainHand().isSimilar(fee))
			{
				player.getInventory().remove(fee);
				//Spin GUI after fee is payed
				
				return true;
			}
			player.sendMessage(ChatColor.RED + "You don't have enough money. You need 3 diamonds to gamble");
		}
		return false;
	}
	
	public void shuffle(Inventory inv)
	{
		if(contents == null)
		{
			//why can't we just make an arraylist and shuffle it with Collection.shuffle(ArrayList);....
			ItemStack[] item = new ItemStack[10];
			item[0] = new ItemStack(Material.DIRT, 32);
			item[1] = new ItemStack(Material.ACACIA_BOAT, 69);
			item[2] = new ItemStack(Material.DIAMOND, 10);
			item[3] = new ItemStack(Material.BARRIER, 1);
			item[4] = new ItemStack(Material.BEDROCK, 1);
			item[5] = new ItemStack(Material.BEEF, 100);
			item[6] = new ItemStack(Material.DIAMOND, 3);
			item[7] = new ItemStack(Material.CAKE, 100);
			item[8] = new ItemStack(Material.CHAIN_COMMAND_BLOCK, 1);
			item[9] = new ItemStack(Material.END_GATEWAY, 20);
			
			contents = item;
		}
		
		int startingindex = ThreadLocalRandom.current().nextInt(contents.length);
		
		for(int i = 0; i< startingindex; i++)
		{
			for(int itemstacks = 9; itemstacks<18; itemstacks++)
			{
				inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
			}
			itemIndex++;
		}
		
		//custom arrow
		ItemStack pointer = new ItemStack(Material.HOPPER);
		ItemMeta meta = pointer.getItemMeta();
		meta.setDisplayName(ChatColor.MAGIC + "|");
		pointer.setItemMeta(meta);
		inv.setItem(4, pointer);
	}
	
	public void spin(final Player player)
	{
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Gamble GUI");
		shuffle(inv);
		invs.add(inv);
		
		player.openInventory(inv);
		
		Random r = new Random();
		
		double seconds = 7.0 + (12.0 - 7.0) * r.nextDouble(); //honestly i could just put 5.0 and r.nextDouble() is like a percentage. If it's 0%, that means 0.0 * (12.0 - 7.0) + 7 = 0 seconds + 7 seconds
		//if r = 0.5, then half of 5.0 seconds is 2.5 seconds. 7 + 2.5 = 9 seconds.
		//It makes sense
		
		new BukkitRunnable() { //when the player opens up the inventroy, this will permantely run
			
			double delay = 0;
			int ticks = 0;
			boolean done = false;
			
			@Override
			public void run() { //this will run multiple times
				// TODO Auto-generated method stub
				if(done)
				{
					return;
				}
				ticks++;
				delay = delay + 1/(20 * seconds); //the long the time is, the shorter the delays | the timer is decreasing, so the shorter time is, the longer the delays. Once it becomes just a few seconds, the spinning GUI goes slower
				
				if(ticks > delay * 10) //the game has a constant tick, if the spinning GUI has a bigger delay (so more slower) than the speed the game is going at, then it will not do this
				{
					ticks = 0;
					
					for(int itemstacks = 9; itemstacks < 18; itemstacks++)
					{
						inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
					}
					
					itemIndex++;
					if(delay >= 0.5)
					{
						done = true;
						new BukkitRunnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								ItemStack item = inv.getItem(13);
								player.getInventory().addItem(item);
								player.updateInventory();
								player.closeInventory();
								cancel();
							}
							
						}.runTaskLater(Main.getPlugin(Main.class), 50);
						cancel();
					}
				}
			}
			
		}.runTaskTimer(this, 0 , 1); //plugin, delay, period. The plugin is in "this" class | don't wait, start a 0 seconds | runs everything over again every 1 tick
	}
}

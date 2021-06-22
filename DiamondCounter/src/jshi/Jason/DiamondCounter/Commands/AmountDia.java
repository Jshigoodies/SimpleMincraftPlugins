package jshi.Jason.DiamondCounter.Commands;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jshi.Jason.DiamondCounter.Main;
import jshi.Jason.DiamondCounter.Files.DataManager;
import net.md_5.bungee.api.ChatColor;

public class AmountDia implements CommandExecutor{
	
	private Main plugin;
	private DataManager data;
	private Set<String> list;
	private List<Player> masterList;
	
	public AmountDia(Main _plugin, DataManager _data)
	{
		this.plugin = _plugin;
		this.data = _data;
	}
	
	public void setList()
	{
		//set up
		File f = new File(plugin.getDataFolder(), "data.yml");
		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//skip the first line because it's just "players:"
		input.nextLine();
		
		list = new HashSet<String>();
		while(input.hasNext())
		{
			list.add(input.nextLine().trim());
		}
	}
	
	public String findElement(String name)
	{
		String w = ChatColor.RED + "" + ChatColor.RED + "player not found";
		ArrayList<String> betterList = new ArrayList<String>(list);
		for(int i = 0; i<betterList.size(); i++)
		{
			if(betterList.get(i).contains(name))
			{
				w = betterList.get(i);
				break;
			}
		}
		return w + " diamonds!";
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int index = -1;
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("diamonds"))
			{
				setList();
				if(args.length == 1)
				{
//					//so i can check for online people too
//					//masterList = player.getWorld().getPlayers();
//					
//					
//					//search for the player's name
//					for(int i = 0; i < masterList.size(); i++)
//					{
//						if(masterList.get(i).getName().equalsIgnoreCase(args[0]))
//						{
//							index = i;
//							break;
//						}
//					}
//					//cannot find player
//					if(index == -1)
//					{
//						player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "player not found");
//					}
					
					
					//get the specific player amount of diamonds
					String w = findElement(args[0]);
					player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + w);
					return true;
					
				}
				else
				{
					//int amount = this.data.getConfig().getInt("player." + player.getName()); // why this not fking work idk
					
					//get yourself amount of diamonds
					String w = findElement(player.getName());
					player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + w);
					return true;
				}
			}
		}
		
		return false;
	}
}

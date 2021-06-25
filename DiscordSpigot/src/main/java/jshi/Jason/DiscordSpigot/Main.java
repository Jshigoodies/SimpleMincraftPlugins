package jshi.Jason.DiscordSpigot;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import jshi.Jason.DiscordSpigot.Commands.AmountDia;
import jshi.Jason.DiscordSpigot.Files.DataManager;
import jshi.Jason.DiscordSpigot.Files.DataManagerTwo;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

public class Main extends JavaPlugin implements Listener{
	
	public DataManager data;
	public DataManagerTwo data_two;
	
	public static JDA jda;
	public static String prefix = "~";
	private Guild guild;
	private List<TextChannel> listCh;
	
	
	@Override
	public void onEnable() {
		this.data = new DataManager(this); //diamonds
		this.data_two = new DataManagerTwo(this); //death
		
		setUp();
		
		getCommand("diamonds").setExecutor(new AmountDia(this, data));
		this.getServer().getPluginManager().registerEvents(this, this);
		listCh.get(0).sendMessage("plz work").queue();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[DiamondCounter]: Plugin is Enabled");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[DiamondCounter]: Plugin is Disabled");
	}
	
	public void setUp()
	{
		File f = new File("C:\\Users\\Jshi\\Desktop\\WorkSpace\\DiscordSpigot\\token.dat");
		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String token = input.nextLine();
		JDABuilder building = JDABuilder.createDefault(token);
		//building.addEventListeners(this);
		try {
			jda = building.build();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//done building
		
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		
		input.close();
		
		//organizing is good
		additionalSetUp();
	}
	
	private void additionalSetUp() //this adds the channels that the bot can send to
	{
		guild = jda.getGuildById("772158782758715403");
		listCh = guild.getTextChannels();
	}
	
	// Events
//	@Override
//	public void onReady(ReadyEvent event)
//	{
//		this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[DiamondCounter] Bot setup success!");
//		
//		//server is up
//		int index = -1;
//		for(int i = 0; i<listCh.size(); i++)
//		{
//			if(listCh.get(i).getName().equalsIgnoreCase("general"))
//			{
//				index = i;
//				break;
//			}
//		}
//		
//		if(index != -1)
//		{
//			listCh.get(index).sendMessage(":green_apple: Sever is up").queue();
//		}
//	}
	
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
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event)
	{
		if(!(event.getEntity() instanceof Player))
		{
			return;
		}
		
		Player player = (Player) event.getEntity();
		player.sendMessage("you died");
		int death = 0;
		
		if(this.data_two.getConfig().contains("death." + player.getName()));
		{
			death = this.data_two.getConfig().getInt("death." + player.getName());
		}
		data_two.getConfig().set("death." + player.getName(), (death + 1));
		data_two.saveConfig();
	}
}

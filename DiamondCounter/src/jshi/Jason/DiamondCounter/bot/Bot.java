package jshi.Jason.DiamondCounter.bot;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import org.bukkit.ChatColor;

import jshi.Jason.DiamondCounter.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter{
	
	private static JDA jda;
	public static String prefix = "~";
	private Main plugin;
	private Guild guild;
	private List<TextChannel> listCh;
	
	//i know this looks stupid, but I'm literally open to suggestions on how to make discord and minecraft work together
	
	public Bot(Main main)
	{
		plugin = main;
		setUp(); 
	}
	
	public void setUp()
	{
		File f = new File("token.dat");
		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String token = input.nextLine();
		JDABuilder building = JDABuilder.createDefault(token);
		building.addEventListeners(this);
		try {
			jda = building.build();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//done building
		
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.playing(":c"));
		
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
	@Override
	public void onReady(ReadyEvent event)
	{
		plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[DiamondCounter] Bot setup success!");
		
		//server is up
		int index = -1;
		for(int i = 0; i<listCh.size(); i++)
		{
			if(listCh.get(i).getName().equalsIgnoreCase("general"))
			{
				index = i;
				break;
			}
		}
		
		if(index != -1)
		{
			listCh.get(index).sendMessage(":green_apple: Sever is up").queue();
		}
	}
}

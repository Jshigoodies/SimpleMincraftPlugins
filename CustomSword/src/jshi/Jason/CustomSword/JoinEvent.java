package jshi.Jason.CustomSword;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent event)
	{
		event.getPlayer().setResourcePack("https://drive.google.com/drive/folders/1XDbXXy9tdFkvnLSjGU2fgQbkg_HMPyIp?usp=sharing");
	}
}

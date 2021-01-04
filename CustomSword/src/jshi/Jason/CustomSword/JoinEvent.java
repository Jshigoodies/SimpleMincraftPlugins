package jshi.Jason.CustomSword;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent event)
	{
		event.getPlayer().setResourcePack("https://www.dropbox.com/sh/f3ie51vsn6pi1wj/AAAsq6jQvAp3e-yF6DHmFF5Ja?dl=1");
	}
}

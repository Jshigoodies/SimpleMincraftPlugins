package jshi.Jason.Stats;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class StatTab implements TabCompleter{
	
	List<String> arguments = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender send, Command cmd, String label, String[] args) {
		if(arguments.isEmpty()) {
			arguments.add("logins");
			arguments.add("playerKills");
			arguments.add("deaths");
			arguments.add("mobKills");
		}
		
		List<String> result = new ArrayList<String>();
		if(args.length == 1) {
			for(String a : arguments)
			{
				if(a.toLowerCase().startsWith(args[0].toLowerCase())) //if it starts with this first letter
				{
					result.add(a); //if someone types a arugments that starts with a 'm' go through the whole list and see if any of them start with a 'm'
				}
			}
			return result;
		}
		
		return null;
	}
}

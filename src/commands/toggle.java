package commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import startup.prim.Main;
import utils.methods;
import utils.prefixes;

public class toggle {
	
	public static class toggleCommand implements CommandExecutor {
		
		private final Main plugin;
		
		public toggleCommand(Main plugin) {
			this.plugin = plugin;
		}
		
		@Override
		public boolean onCommand(CommandSender senderPlayer, Command arg1, String arg2, String[] arg3) {
			
			if(senderPlayer instanceof Player == false) {
				if(arg3[0] == null) {
					System.out.println("Use: tab [update/toggle] [deaths/ping]");
					return true;
				}
				
				switch(arg3[0]) {
				case "update": {
					if(arg3[1] != "deaths" || arg3[1] != "ping") {
						System.out.println("You must select argument between deaths or ping.");
						return true;
					}
					
					Boolean currentValue = plugin.getConfig().getBoolean(arg3[1]);
					plugin.getConfig().set(arg3[1], !currentValue);
					
					System.out.println("You set "+arg3[1]+" to "+!currentValue);
				}
				case "toggle": {
					Boolean currentValue = plugin.getConfig().getBoolean("enabled");
					
					plugin.getConfig().set("enabled", !currentValue);
					
					System.out.println("You have set plugin on status to "+ !currentValue);
				
				}
				default: {
					return false;
				}
				}
				
			} else if (senderPlayer.isOp()) {
				if(arg3[0] == null) {
					senderPlayer.sendMessage("Use: tab [update/toggle] [deaths/ping]");
					return true;
				}
				
				switch(arg3[0]) {
				case "update": {
					if(arg3[1] != "deaths" || arg3[1] != "ping") {
						senderPlayer.sendMessage("You must select argument between deaths or ping.");
						return true;
					}
					
					Boolean currentValue = plugin.getConfig().getBoolean(arg3[1]);
					plugin.getConfig().set(arg3[1], !currentValue);
					
					senderPlayer.sendMessage("You set "+arg3[1]+" to "+!currentValue);
				}
				case "toggle": {
					Boolean currentValue = plugin.getConfig().getBoolean("enabled");
					
					plugin.getConfig().set("enabled", !currentValue);
					
					senderPlayer.sendMessage("You have set plugin on status to "+ !currentValue);
				
				}
				default: {
					return false;
				}
				}
			}
			
			return true;
		}
	}
}

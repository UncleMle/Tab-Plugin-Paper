package utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import startup.prim.Main;

public class methods {
	
	private static BukkitRunnable listThread;
	
	public static String formattedPos(Location pos) {
        String formattedPos = ChatColor.BOLD+"X: "+Math.round(pos.getX())+" Y: "+ Math.round(pos.getY())+" Z: "+Math.round(pos.getZ());
        return formattedPos;
    }
	
	public static void startListRender(Player player) {
		
		final Main plugin = new Main();

	    BukkitRunnable runnable = new BukkitRunnable() {
	        public void run() {
	        	
	        	Boolean isEnabled = plugin.getConfig().getBoolean("enabled");
	        	Boolean showDeaths = plugin.getConfig().getBoolean("deaths");
	        	Boolean showPing = plugin.getConfig().getBoolean("ping");
	        	
	        	if(isEnabled == false) return;
	        	
	        	String playerPing = ""+((CraftPlayer) player).getHandle().ping;
	        	String playerDeaths = ""+player.getStatistic(Statistic.DEATHS);
	        	
	        	if(!showDeaths) {
	        		playerDeaths = "";
	        	}
	        	if(!showPing) {
	        		playerPing = "";
	        	}
	        	
	        	
	        	player.setPlayerListName(ChatColor.WHITE+player.getDisplayName()+ChatColor.GRAY+" Ping: "+playerPing+ " Total Deaths: "+playerDeaths);		          
	        }
	      };
      	listThread = runnable;
	    runnable.runTaskTimer(Main.getPlugin(Main.class), 2L, 2L);
	  }
	
	public static Boolean cancelListThread(Player p) {
		if(listThread != null) {
			listThread.cancel();
			return true;
		} else return false;
	}
}

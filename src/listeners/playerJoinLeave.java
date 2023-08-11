package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import utils.prefixes;
import utils.methods;


public class playerJoinLeave implements Listener {
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        initPlayer(player);
    }

    public void initPlayer(Player player) {
    	methods.startListRender(player);
    }

}
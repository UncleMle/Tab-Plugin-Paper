package startup.prim;

import java.io.BufferedReader;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.reflect.ClassPath;
import commands.toggle;
import listeners.playerJoinLeave;
import utils.methods;

import org.bukkit.Server;
import org.bukkit.event.Listener;

public class Main extends JavaPlugin{
	

	@Override
	public void onEnable() {
		System.out.println("Tablist plugin started.");	
        getServer().getPluginManager().registerEvents(new playerJoinLeave(), this);
        
        this.getCommand("tab").setExecutor(new toggle.toggleCommand(this));
	}
}

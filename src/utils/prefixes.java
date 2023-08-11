package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import net.md_5.bungee.api.ChatColor;

public class prefixes {
    public static final String sysPrefix  = ChatColor.LIGHT_PURPLE +"[System] "+ChatColor.WHITE;
    public static final String error = ChatColor.RED+"[Error] "+ChatColor.WHITE;
    public static final String admin = ChatColor.RED+"[Admin System] "+ChatColor.WHITE;
    public static final  String death = ChatColor.DARK_AQUA+"[Death] "+ChatColor.WHITE;
    public static final  String chat = ChatColor.GREEN+"[Chat] "+ChatColor.WHITE;
    public static final  String sleep = ChatColor.DARK_AQUA+"[Sleep] "+ChatColor.WHITE;
    public static final  String ccmd = "Command is incompatiable with console.";
    public static final String noauth = ChatColor.RED+"[Auth]"+ ChatColor.WHITE+" You do not have authorization to use this command.";
    public static final String cred = "\\u001b[31m";

    public static String time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = ChatColor.GRAY+"["+dtf.format(now)+"] ";
        return time;
    }
}

package speedcraftclient;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public final class Speedcraftclient extends JavaPlugin implements Listener  {
	@Override
    public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }
 
    @Override
    public void onDisable() {
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("scquit")) { // If the player typed /basic then do the following...
    		getLogger().info("Run has ended!");
    		sender.sendMessage("&2[SpeedCraft] &8Run has ended!&r");
    		Player p = (Player)sender;
    		ByteArrayDataOutput out = ByteStreams.newDataOutput();
    		out.writeUTF("Connect");
    		out.writeUTF("hub");
			p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
			getLogger().info(startTime);
    		
    		return true;
    	} //If this has happened the function will return true. 
            // If this hasn't happened the value of false will be returned.
    	return false; 
    }
    
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
    	Player p = event.getPlayer();
    	long startTime = System.currentTimeMillis();
    	getLogger().info("&2[SpeedCraft] StartTimer");
    	p.sendMessage("&2[SpeedCraft] &8Good Luck! Your time has started&r");
    	
    }
}

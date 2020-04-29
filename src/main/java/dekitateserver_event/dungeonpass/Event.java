package dekitateserver_event.dungeonpass;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Event implements Listener {
    private final Plugin plugin;
    public Event(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void PlayerLogin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        StatusRecord statusRecord = new StatusRecord(plugin);
        statusRecord.savePlayer(player);
    }
}

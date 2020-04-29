package dekitateserver_event.dungeonpass;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class DungeonPass extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("プラグインが有効になった!");
        startUp(this);
        new Event(this);
        getCommand("dp").setExecutor(new DPCommands(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になった!");
        PlayerJoinEvent.getHandlerList().unregister(this);
    }

    public void startUp(Plugin plugin) {
        plugin.saveDefaultConfig();
        /*File configYml = new File(plugin.getDataFolder(), "Config.yml");
        if (!configYml.exists()) {
            plugin.saveResource(configYml.getName(), false);
        }//*/
    }
}

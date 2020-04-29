package dekitateserver_event.dungeonpass;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getLogger;

public class Config {

    private final Plugin plugin;
    private FileConfiguration config = null;

    public String host,database,username,password;
    public int port;

    public Config(Plugin plugin) {
        this.plugin = plugin;
        load();
    }

    public void load() {
        config = plugin.getConfig();

        host = config.getString("host");
        port = config.getInt("port");
        database = config.getString("database");
        username = config.getString("username");
        password = config.getString("password");

        if (!config.contains("password")) {
            getLogger().info("config.ymlの設定が正しくありません");
        }
    }
}

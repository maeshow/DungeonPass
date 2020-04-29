package dekitateserver_event.dungeonpass;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class StatusRecord {

    private final Plugin plugin;
    private Connection connection;
    private final String host,database,username,password;
    private final int port;

    public StatusRecord(Plugin plugin) {
        this.plugin = plugin;
        Config config = new Config(plugin);
        this.host = config.host;
        this.port = config.port;
        this.database = config.database;
        this.username = config.username;
        this.password = config.password;
    }

    public void savePlayer(Player player) {
        try {
            openConnection();
            String name = player.getName();
            UUID uuid = player.getUniqueId();

            String sql = "INSERT INTO players (name, uuid) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, uuid.toString());

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true&useSSL=false", this.username, this.password);
        }
    }
}

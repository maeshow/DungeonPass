package dekitateserver_event.dungeonpass;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DPCommands implements CommandExecutor {

    private DungeonPass instance;
    public DPCommands(DungeonPass instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String subCmd = args.length == 0 ? "" : args[0];
        if (sender.hasPermission("dp.op")) {
            if (subCmd.equalsIgnoreCase("set")) {
                //aaa
            } else if (subCmd.equalsIgnoreCase("add")) {
                //bbb
            } else if (subCmd.equalsIgnoreCase("remove")) {
                //ccc
            } else {
                DpHelp(sender);
            }
        } else {
            if (subCmd.equalsIgnoreCase("p")) {
                //ddd
            } else {
                DpPlayerHelp(sender);
            }
        }
        return false;
    }

    public void DpHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN +"-------------DungeonPass help-------------");
        sender.sendMessage(ChatColor.GREEN +"/dp set");
        sender.sendMessage(ChatColor.GREEN +"/dp add");
        sender.sendMessage(ChatColor.GREEN +"/dp remove");
        sender.sendMessage(ChatColor.GREEN +"/dp ophelp");
        sender.sendMessage(ChatColor.GREEN +"------------------------------------------");
    }

    public void DpPlayerHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN +"-------------DungeonPass help-------------");
        sender.sendMessage(ChatColor.GREEN +"/dp p");
        sender.sendMessage(ChatColor.GREEN +"/dp help");
        sender.sendMessage(ChatColor.GREEN +"------------------------------------------");
    }
}

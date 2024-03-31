package me.lsam.easycommand;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.ArrayList;

public class Test2Command extends BukkitCommand {
    public Test2Command() {
        super("test");
        this.description = "";
        this.usageMessage = "";
        this.setPermission("easycommand.commands.test");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        sender.sendMessage("test2 command");
        return true;
    }
}

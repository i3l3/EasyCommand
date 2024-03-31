package me.lsam.easycommand;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestCommand extends BukkitCommand {
    public TestCommand() {
        super("test");
        this.description = "";
        this.usageMessage = "";
        this.setPermission("easycommand.commands.test");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        sender.sendMessage("test command");
        try {
            Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register("test2", new Test2Command());

            ((CraftServer) Bukkit.getServer()).syncCommand();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        }
        return true;
    }
}

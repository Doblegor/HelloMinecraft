package me.doblegor.helloworld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HelloWorld extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getConsoleSender().sendMessage("hola consola");
        if (label.equalsIgnoreCase("hola")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("hola.use")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes(
                            '&', getConfig().getString("message.activation")));
                    return true;
                }
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messgae.error")) );
                return true;
            }
            sender.sendMessage("Buenas tardes consola");
            return true;
        }
        return false;
    }
}

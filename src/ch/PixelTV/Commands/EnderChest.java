package ch.PixelTV.Commands;

import ch.PixelTV.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Coded by PixelTeleV
 * 20.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class EnderChest implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("ec") || cmd.getName().equalsIgnoreCase("eenderchest")) {
            if(p.hasPermission("System.EnderChest")) {
                p.openInventory(p.getEnderChest());
                p.sendMessage(Main.pr + "Dir wurde deine persönliche §eEnderChest §ageöffnet§7!");
            } else {
                p.sendMessage(Main.noperm);
            }
        }

        return false;
    }

}

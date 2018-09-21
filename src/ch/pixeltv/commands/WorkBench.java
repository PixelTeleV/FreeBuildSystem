package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
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
public class WorkBench implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("wb") ||cmd.getName().equalsIgnoreCase("workbench")) {
            if(p.hasPermission("System.WorkBench")) {
                p.openWorkbench(p.getLocation(), true);
                p.sendMessage(Main.pr + "Du hast eine §eWerkbank §ageöffnet§7!");
            } else {
                p.sendMessage(Main.noperm);
            }
        }

        return false;
    }

}

package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Coded by PixelTeleV
 * 21.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Suicide implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("suicide")) {
            if(p.hasPermission("System.Suicide")) {
                p.setHealth(0.0);
                p.setFoodLevel(0);
                p.sendMessage(Main.pr + "Du hast dir das §eLeben §cgenommen§7! §4R.I.P");
            }
        }

        return false;
    }

}

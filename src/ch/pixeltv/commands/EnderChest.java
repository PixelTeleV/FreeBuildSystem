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
public class EnderChest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("enderchest") || cmd.getName().equalsIgnoreCase("ec")) {
            if(p.hasPermission("System.Enderchest")) {
                if(args.length == 0) {
                    p.sendMessage(Main.pr + "Deine §eEnderchest §7wurde erfolgreich §ageöffnet!");
                    p.openInventory(p.getEnderChest());
                } else {
                    p.sendMessage(Main.syntax + "/enderchest");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return false;
    }

}

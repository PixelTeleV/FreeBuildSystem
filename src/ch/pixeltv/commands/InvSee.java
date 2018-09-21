package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import org.bukkit.Bukkit;
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
public class InvSee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("invsee")) {
            if(p.hasPermission("System.Invsee")) {
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if(target != null) {
                        if(target != p) {
                            p.openInventory(target.getInventory());
                            p.sendMessage(Main.pr + "Du hast erfolgreich das §eInventar von §e" + target.getName() + " §ageöffnet!");
                        } else {
                            p.sendMessage(Main.pr + "§7Du kannst dein eigenes §eInventar §cnicht öffnen§7!");
                        }
                    } else {
                        p.sendMessage(Main.pr + "Der Spieler §e" + target.getName() + " §7ist §cnicht Online§7!");
                    }
                } else {
                    p.sendMessage(Main.syntax + "/invsee <Spieler>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return false;
    }

}

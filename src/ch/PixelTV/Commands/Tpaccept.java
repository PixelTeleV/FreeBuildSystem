package ch.PixelTV.Commands;

import ch.PixelTV.Main.Main;
import org.bukkit.Bukkit;
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
public class Tpaccept implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(args.length == 1) {
            if(target == null) {
                p.sendMessage(Main.pr + "Der Spieler §e" + target.getName() + " §7ist §cOffline §7oder §cexistiert nicht§7!");
            } else {
                if(target == p) {
                    p.sendMessage(Main.pr + "Du §ckannst nicht §7deine eigene §eTPA-Anfrage §aakzeptieren§7!");
                } else {
                    if(Tpa.requests.containsKey(p)) {
                        if(Tpa.requests.get(target).contains(p)) {
                            Tpa.requests.get(target).remove(p);
                            p.teleport(target);
                            p.sendMessage(Main.pr + "Du wurdest zu dem Spieler §e" + target.getName() + " §ateleportiert§7!");
                            target.sendMessage(Main.pr + "Der Spieler §e" + p.getName() + " §7wurde zu dir §ateleportiert§7!");
                            }
                        } else {
                            target.sendMessage(Main.pr + "Der Spieler §e" + p.getName() + " §7hat dir §ckeine §eTPA-Anfrage §agesendet§7!");
                        }
                    }
                }
            } else {
            p.sendMessage(Main.syntax + "/tpaccept <Spieler>");
        }
        return false;
    }

}

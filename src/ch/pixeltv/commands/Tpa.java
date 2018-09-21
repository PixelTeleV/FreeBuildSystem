package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Coded by PixelTeleV
 * 21.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Tpa implements CommandExecutor {

    public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("System.Tpa")) {
            if(args.length == 1) {
                Player a = Bukkit.getPlayer(args[0]);

                if(a == null) {
                    p.sendMessage(Main.pr + "§7Der Spieler §e" + a + " §7ist §cnicht Online§7!");
                    tpa.remove(a);
                }

                if(tpa.containsKey(a) && tpa.get(a) == p) {
                    p.sendMessage("§7Du hast dem Spieler §e" + a.getName() + " §cbereits eine Anfrage gesendet§7!");
                }

                if(!(a == p)) {
                    a.sendMessage(Main.pr + "§7Du hast eine §eTeleportierungsanfrage §7von dem Spieler §e" + p.getName() + " §aerhalten!");
                    a.sendMessage(Main.pr + "§aAnnehmen §7mit §e/tpaccept " + p.getName());
                    a.sendMessage(Main.pr + "§cAblehnen §7mit §e/tpdeny " + p.getName());

                    p.sendMessage(Main.pr + "§7Du hast dem Spieler §e" + a.getName() + " §7erfolgreich eine §eTeleportierungsanfrage §agesendet§7!");
                } else {
                    p.sendMessage(Main.pr + "§7Du kannst dir selber §ckeine §eTeleportierungsanfrage §asenden§7!");
                    tpa.remove(a);
                }

                if(tpa.containsKey(a)) {
                    tpa.remove(a);
                }

                tpa.put(a, p);

            } else {
                p.sendMessage(Main.syntax + "/tpa <Spieler>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }
        return false;
    }

}

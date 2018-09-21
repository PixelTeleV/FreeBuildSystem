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
public class Msg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("msg")) {
            Player p = (Player) sender;
            String msg = "";

            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {

                    for (int i = 1; i < args.length; i++) {
                        msg = msg + args[i] + " ";
                    }
                    if(!(p == target)) {
                        p.sendMessage(Main.pr + "§aIch §7-> §a" + target.getName() + "§8» §a" + msg);
                        target.sendMessage(Main.pr + "§a" + p.getName() + " §7-> §aMir§8» §a" + msg);
                    } else {
                        p.sendMessage(Main.pr + "§cDu kannst dir nicht selber eine Private Nachricht senden!");
                    }

                } else {
                    p.sendMessage(Main.pr + "§cDieser Spieler ist nicht Online!");
                }
            } else if(args.length <= 1) {
                p.sendMessage(Main.syntax + "/msg <Spieler> <Nachricht>");
            }
        }
        return false;
    }

}

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
public class Tpaccept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player a = (Player) sender;

        if(Tpa.tpa.containsKey(a)) {
            Player p = Tpa.tpa.get(a);

            p.teleport(a);
            Tpa.tpa.remove(a);

            a.sendMessage(Main.pr + "§aDu hast erfolgreich die Teleportierungsanfrage von §e" + p.getName() + " §aangenommen!");
            p.sendMessage(Main.pr + "§e" + a.getName() + " §ahat deine Teleportierungsanfrage angenommen!");
        } else {
            a.sendMessage(Main.pr + "§cDu hast keine offene Teleportierungsanfrage!");
        }
        return false;
    }

}

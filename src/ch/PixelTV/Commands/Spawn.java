package ch.PixelTV.Commands;

import ch.PixelTV.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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
public class Spawn implements CommandExecutor {

    Location spawnloc = new Location(Bukkit.getWorld("world"), 0.0, 100, 0.0);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("spawn")) {
            if(args.length == 0) {
                p.teleport(spawnloc);
                p.sendMessage(Main.pr + "Du hast dich zum §eSpawn §ateleportiert§7!");
            } else {
                p.sendMessage(Main.syntax + "/spawn <Spieler>");
            }
        }

        return false;
    }

}

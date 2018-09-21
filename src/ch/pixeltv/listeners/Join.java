package ch.pixeltv.listeners;

import ch.pixeltv.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Coded by PixelTeleV
 * 23.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(Main.pr + "Der Spieler §e" + p.getName() + " §7hat das Spiel §abetreten§7!");

        p.sendMessage("§a§lWillkommen auf dem Server!");
    }

}

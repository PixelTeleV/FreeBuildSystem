package ch.pixeltv.listeners;

import ch.pixeltv.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Coded by PixelTeleV
 * 23.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage(Main.pr + "Der Spieler §e" + p.getName() + " §7hat das Spiel §cverlassen§7!");
    }

}

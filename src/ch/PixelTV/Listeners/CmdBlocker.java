package ch.PixelTV.Listeners;

import ch.PixelTV.Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Coded by PixelTeleV
 * 20.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class CmdBlocker implements Listener {

    @EventHandler
    public void onBlockedCMD(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();

        if(e.getMessage().toLowerCase().startsWith("/plugins") || e.getMessage().toLowerCase().startsWith("/ver") || e.getMessage().toLowerCase().startsWith("/version") || e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/pls") || e.getMessage().toLowerCase().startsWith("/bukkit:?") || e.getMessage().toLowerCase().startsWith("/bukkit:pl") || e.getMessage().toLowerCase().startsWith("/bukkit:pls") || e.getMessage().toLowerCase().startsWith("/bukkit:plugins") || e.getMessage().toLowerCase().startsWith("/bukkit:ver") || e.getMessage().toLowerCase().startsWith("/bukkit:version") || e.getMessage().toLowerCase().startsWith("/icanhasbukkit") || e.getMessage().toLowerCase().startsWith("/help") || e.getMessage().toLowerCase().startsWith("/bukkit:help")) {
            if(p.hasPermission("System.CMDBlocker.Bypass")) {
                p.sendMessage(Main.pr + "§4Information: §cDieser Befehl ist für normale Spieler nicht verfügbar!");
            } else {
                p.sendMessage(Main.noperm);
                e.setCancelled(true);
            }
        }
    }

}

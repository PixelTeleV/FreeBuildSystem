package ch.PixelTV.Commands;

import ch.PixelTV.Main.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Coded by PixelTeleV
 * 20.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Tpa implements CommandExecutor {

    public static HashMap<Player, ArrayList<Player>> requests = new HashMap<Player, ArrayList<Player>>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);

            if(target == null) {
                p.sendMessage(Main.pr + "Der angegebene Spieler §cexistiert nicht§7!");
            } else {
                if(target == p) {
                    p.sendMessage(Main.pr + "§cDu kannst dir nicht selber eine TPA-Anfrage senden!");
                } else {
                    if(requests.containsKey(p)) {
                        requests.get(target).add(p);
                    } else {
                        ArrayList<Player> req = new ArrayList<Player>();
                        req.add(p);
                        requests.put(target, req);
                    }

                    TextComponent accept = new TextComponent("/tpaccept " + p.getName());
                    accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept" + p.getName()));
                    accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aAkzeptiere die TPA-Anfrage").create()));

                    TextComponent deny = new TextComponent("/tpdeny " + p.getName());
                    deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny" + p.getName()));
                    deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aLehne die TPA-Anfrage ab").create()));

                    p.sendMessage(Main.pr + "Du hast eine §eTPA-Anfrage §7an §e" + target.getName() + " §agesendet§7!");
                    target.sendMessage(Main.pr + "Der Spieler §e" + p.getName() + " §7hat dir eine §eTPA-Anfrage §agesendet§7!");
                    target.sendMessage(Main.pr + "§aAkzeptiere §7die §eTPA-Anfrage§7: §a" + accept);
                    target.sendMessage(Main.pr + "§cLehne §7die §eTPA-Anfrage §cab§7: §c" + deny);
                }
            }
        } else {
            p.sendMessage(Main.syntax + "/tpa <Spieler>");
        }

        return false;
    }

}

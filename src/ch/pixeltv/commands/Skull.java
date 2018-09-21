package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Coded by PixelTeleV
 * 21.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Skull implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("skull")) {
            if(p.hasPermission("System.Skull")) {
                if(args.length == 1) {
                    ItemStack item = new ItemStack(Material.getMaterial(397), 1, (short)3);
                    SkullMeta mitem = (SkullMeta) item.getItemMeta();
                    mitem.setDisplayName("§aKopf von §e" + args[0]);

                    mitem.setOwner(args[0]);
                    item.setItemMeta(mitem);

                    p.getInventory().addItem(item);
                } else {
                    p.sendMessage(Main.syntax + "/skull <Spieler>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return false;
    }

}

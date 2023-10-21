package fr.piarre.myPlugin.Commands;

import fr.piarre.myPlugin.Main;
import fr.piarre.myPlugin.Utils.GUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SS implements CommandExecutor {

    public Inventory invSS;
    Main plugin;

    public SS(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length == 1) {
            String target = args[0];
            if (Bukkit.getPlayer(target) == null) {
                player.sendMessage(ChatColor.RED + "Player not found !");
                return false;
            } else {
                assert target != null;
                player.openInventory(new GUI().SS());
                return true;
            }
        } else {
            player.sendMessage(ChatColor.GOLD + "Usage :" + ChatColor.RED + " /ss <player>");
            return false;
        }
    }
}


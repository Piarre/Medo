package fr.piarre.myPlugin.Commands;

import fr.piarre.myPlugin.Main;
import fr.piarre.myPlugin.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SS implements CommandExecutor {

    Main plugin;

    public Inventory invSS;

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
                plugin.getLogger().info(target);
                assert target != null;
                this.invSS = Bukkit.createInventory(null, 9, "§1Staff mod");

                ItemBuilder kill = new ItemBuilder(Material.TNT).setName(ChatColor.DARK_GRAY + "Kill").setLore(ChatColor.GRAY + "Kill the player");
                ItemBuilder ban = new ItemBuilder(Material.NETHERITE_SWORD).setName(ChatColor.RED + "Ban").setLore(ChatColor.GRAY + "Ban the player");
                ItemBuilder close = new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "Close").setLore(ChatColor.GRAY + "Close the menu");

                this.invSS.setItem(4, kill.toItemStack());
                this.invSS.setItem(6, ban.toItemStack());
                this.invSS.setItem(8, close.toItemStack());

                player.openInventory(this.invSS);

                return true;
            }
        } else {
            player.sendMessage(ChatColor.GOLD + "Usage :" + ChatColor.RED + " /ss <player>");
            return false;
        }
    }
}


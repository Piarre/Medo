package fr.piarre.myPlugin.Listeners;

import fr.piarre.myPlugin.Commands.SS;
import fr.piarre.myPlugin.Main;
import fr.piarre.myPlugin.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SSItems implements Listener {

    SS command;

    Main plugin;

    public SSItems(Main plugin, SS command) {
        this.plugin = plugin;
        this.command = command;
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        if (event.getInventory() == null) return;
        Player player = (Player) event.getWhoClicked();

        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equalsIgnoreCase("§1Staff mod")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case TNT:
                    break;
                case NETHERITE_SWORD:
                    Inventory banInv = Bukkit.createInventory(null, 3 * 9, "Ban");

                    ItemBuilder back = new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "Back").setLore(ChatColor.GRAY + "Back to the menu");

                    banInv.setItem(0, back.toItemStack());

                    event.getWhoClicked().openInventory(banInv);
                    break;
                case BARRIER:
                    break;
                default:
                    break;
            }
        } else {
            return;
        }

    }
}

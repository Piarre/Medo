package fr.piarre.myPlugin.Listeners;

import fr.piarre.myPlugin.Commands.SS;
import fr.piarre.myPlugin.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class BanListener implements Listener {

    SS ss;

    public BanListener(SS ss) {
        this.ss = ss;
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null || event.getClickedInventory() == null || !(event.getWhoClicked() instanceof Player)) return;

        if (event.getView().getTitle().equalsIgnoreCase("§4Ban")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {

                case ARROW:


                    break;
                default:
                    break;
            }
        } else {
            return;
        }

    }

}

package fr.piarre.myPlugin.Listeners;

import fr.piarre.myPlugin.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SSListener implements Listener {

    Inventory banInv;

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null) return;
        if (event.getClickedInventory() == null) return;
        if (!(event.getWhoClicked() instanceof Player)) return;

        if (event.getView().getTitle().equalsIgnoreCase("§1Staff mod")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case TNT:
                    break;
                case NETHERITE_SWORD:
                    this.banInv = Bukkit.createInventory(null, 3 * 9, "§4Ban");

                    ItemBuilder back = new ItemBuilder(Material.ARROW).setName(ChatColor.RED + "Back").setLore(ChatColor.GRAY + "Back to the menu");

                    this.banInv.setItem(26, back.toItemStack());

                    event.getWhoClicked().openInventory(this.banInv);
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

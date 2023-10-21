package fr.piarre.myPlugin.Listeners;

import fr.piarre.myPlugin.Utils.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SSListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null || event.getClickedInventory() == null || !(event.getWhoClicked() instanceof Player))
            return;

        if (event.getView().getTitle().equalsIgnoreCase("§1Staff mod")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case TNT:
                    player.setHealth(0);
                    break;
                case NETHERITE_SWORD:
                    player.openInventory(new GUI().Ban());
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                default:
                    break;
            }
        } else {
            return;
        }

    }
}

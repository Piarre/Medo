package fr.piarre.myPlugin.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class GUI {

    public Inventory SS() {
        Inventory SSINV = Bukkit.createInventory(null, 9, "§1Staff mod");

        ItemBuilder kill = new ItemBuilder(Material.TNT).setName(ChatColor.DARK_GRAY + "Kill").setLore(ChatColor.GRAY + "Kill the player");
        ItemBuilder ban = new ItemBuilder(Material.NETHERITE_SWORD).setName(ChatColor.DARK_RED + "Ban").setLore(ChatColor.GRAY + "Ban the player");
        ItemBuilder close = new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "Close").setLore(ChatColor.GRAY + "Close the menu");

        SSINV.setItem(4, kill.toItemStack());
        SSINV.setItem(6, ban.toItemStack());
        SSINV.setItem(8, close.toItemStack());

        return SSINV;
    }

    public Inventory Ban() {
        Inventory BANINV = Bukkit.createInventory(null, 3 * 9, "§4Ban");

        ItemBuilder killAura = new ItemBuilder(Material.REDSTONE_TORCH).setName(ChatColor.DARK_RED + "Ban for Kill Aura").setLore(ChatColor.DARK_GRAY + "Description :" ,ChatColor.GRAY + "Auto attack when players are near.");
        ItemBuilder autoClicker = new ItemBuilder(Material.DIAMOND_AXE).setName(ChatColor.DARK_RED + "Ban for Auto Clicker").setLore(ChatColor.DARK_GRAY + "Description :" ,ChatColor.GRAY + "Auto click instead of the player.");

        ItemBuilder close = new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "Close").setLore(ChatColor.GRAY + "Close the menu");
        ItemBuilder back = new ItemBuilder(Material.ARROW).setName(ChatColor.RED + "Back").setLore(ChatColor.GRAY + "Back to the menu");

        BANINV.setItem(0, killAura.toItemStack());
        BANINV.setItem(1, autoClicker.toItemStack());
        BANINV.setItem(22, close.toItemStack());
        BANINV.setItem(26, back.toItemStack());

        return BANINV;
    }

}

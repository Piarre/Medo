package fr.piarre.myPlugin.Commands;

import fr.piarre.myPlugin.Main;
import fr.piarre.myPlugin.Utils.Modes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ModeController implements CommandExecutor {

    Main plugin;

    public ModeController(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;


            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Player not found");
                    return true;
                }
                assert target != null;
                if (plugin.playersMode.containsKey(target)) {
                    setPlayerMode(target);
                    player.sendMessage(ChatColor.GOLD + target.getPlayer().getDisplayName() + " is now in " + ChatColor.GREEN + ChatColor.BOLD + "player" + ChatColor.GOLD + " mode.");

                } else {
                    setStaffMode(target);
                    player.sendMessage(ChatColor.GOLD + target.getPlayer().getDisplayName() + " is now in " + ChatColor.RED + ChatColor.BOLD + "staff" + ChatColor.GOLD + " mode.");

                }
            } else {
                if (plugin.playersMode.containsKey(player)) {
                    setPlayerMode(player);
                    player.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.GREEN + ChatColor.BOLD + "player" + ChatColor.GOLD + " mode.");

                } else {
                    setStaffMode(player);
                    player.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + ChatColor.BOLD + "staff" + ChatColor.GOLD + " mode.");

                }
            }

        return false;
    }

    private void setStaffMode(Player player) {
        System.out.println(plugin.playersMode);
        plugin.playersMode.put(player, Modes.STAFF);
        player.setGameMode(GameMode.CREATIVE);
        player.setCanPickupItems(false);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 99999));
    }

    private void setPlayerMode(Player player) {
        plugin.playersMode.remove(player);
        System.out.println(plugin.playersMode);
        player.setGameMode(GameMode.SURVIVAL);
        player.setCanPickupItems(true);
        player.removePotionEffect(PotionEffectType.INVISIBILITY);
    }
}

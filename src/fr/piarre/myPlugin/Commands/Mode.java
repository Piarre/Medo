package fr.piarre.myPlugin.Commands;

import fr.piarre.myPlugin.Main;
import fr.piarre.myPlugin.Utils.Enums;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Mode implements CommandExecutor {

    Main plugin;
    private GameMode changedGM;

    public Mode(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;


        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(plugin.getConfig().getString("player.notfound").replace("{DISPLAYNAME}", player.getPlayer().getDisplayName())
                        .replace("{NAME}", player.getPlayer().getName()));
                return true;
            }
            assert target != null;
            if (plugin.playersMode.containsKey(target)) {
                setPlayerMode(target);
                player.sendMessage(plugin.getConfig().getString("player.mode.player.set-player").replace("{DISPLAYNAME}", player.getPlayer().getDisplayName())
                        .replace("{NAME}", player.getPlayer().getName()));

            } else {
                setStaffMode(target);
                player.sendMessage(plugin.getConfig().getString("player.mode.player.set-staff").replace("{DISPLAYNAME}", player.getPlayer().getDisplayName())
                        .replace("{NAME}", player.getPlayer().getName()));

            }
        } else {
            if (plugin.playersMode.containsKey(player)) {
                setPlayerMode(player);
                player.sendMessage(plugin.getConfig().getString("player.mode.self.set-player").toLowerCase());

            } else {
                setStaffMode(player);
//                player.sendMessage(configManager.Message("player.mode.self.set-staff"));
                player.sendMessage(plugin.getConfig().getString("player.mode.self.set-staff"));
            }
        }

        return false;
    }

    private void setStaffMode(Player player) {
        changedGM = player.getGameMode();
        plugin.playersMode.put(player, Enums.Modes.STAFF);
        player.setGameMode(GameMode.CREATIVE);
        player.setCanPickupItems(false);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 99999));
    }

    private void setPlayerMode(Player player) {
        player.setGameMode(changedGM);
        plugin.playersMode.remove(player);
        player.setGameMode(GameMode.SURVIVAL);
        player.setCanPickupItems(true);
        player.removePotionEffect(PotionEffectType.INVISIBILITY);
    }
}

package de.main.endStop;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportBlockListener implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {

        if (event.getTo() == null || event.getTo().getWorld() == null) {
            return;
        }

        World.Environment environment = event.getTo().getWorld().getEnvironment();

        // Nether
        if (environment == World.Environment.NETHER) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cDer Nether ist derzeit deaktiviert!");
            return;
        }
        //end
        if (environment == World.Environment.THE_END) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cDas End ist derzeit deaktiviert!");
        }
    }
}
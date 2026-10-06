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

        switch (environment) {

            case NETHER:
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cDer Nether ist derzeit deaktiviert!");
                break;

            case THE_END:
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cDas End ist derzeit deaktiviert!");
                break;

            case NORMAL:
                event.setCancelled(false);
                event.getPlayer().sendMessage("§aNicht deaktivert :)");
                break;
        }
    }
}

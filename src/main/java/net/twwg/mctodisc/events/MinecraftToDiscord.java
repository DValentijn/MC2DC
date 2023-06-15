package net.twwg.mctodisc.events;

import net.twwg.mctodisc.bot.MinecraftDiscordBridge;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MinecraftToDiscord implements Listener {

    @EventHandler
    public void handleChat(AsyncPlayerChatEvent event){
        MinecraftDiscordBridge.toDiscord(event.getPlayer().getName(),event.getMessage());
    }

}

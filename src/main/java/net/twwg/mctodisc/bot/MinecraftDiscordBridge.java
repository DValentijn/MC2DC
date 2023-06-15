package net.twwg.mctodisc.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

public class MinecraftDiscordBridge extends ListenerAdapter {

    private static JDABuilder builder;
    private static JDA bot;
    private static final String DISCORD_BOT_TOKEN = "MTExODI4MzU5NDgzMDQ1MDc2MA.Gr7CRR.r_vLGttAQjc1SAGWTyosXomYs4Q1D6QgTm2vkg";
    private static final String DISCORD_CHANNEL_ID = "1118283957776154624"; // Replace with your Discord channel ID

    public MinecraftDiscordBridge(){
        builder = JDABuilder.createDefault(DISCORD_BOT_TOKEN);
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.setActivity(Activity.watching("School projects"));
        builder.addEventListeners(this);
        bot = builder.build();
    }

    public static void stop(){
        bot.shutdown();
    }

    public static void toDiscord(String username, String message) {
        TextChannel textChannel = bot.getTextChannelById("1118283957776154624");
        if (textChannel != null) {
            textChannel.sendMessage(username + " - " + message).queue();
        }
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String messageContent = event.getMessage().getContentDisplay();
        sendToMinecraftServer(event.getAuthor().getName(),  messageContent);
    }

    private void sendToMinecraftServer(String username, String message) {
        // Replace this method with your code to send the message to the Minecraft server
        Bukkit.broadcast(Component.text("[DISCORD] " + username + " - " + message));
    }

}

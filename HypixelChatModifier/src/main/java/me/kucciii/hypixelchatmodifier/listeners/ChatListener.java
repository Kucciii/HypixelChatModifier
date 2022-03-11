package me.kucciii.hypixelchatmodifier.listeners;

import me.kucciii.hypixelchatmodifier.HypixelChatModifier;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChatListener implements Listener {

    private final HypixelChatModifier plugin;

    public ChatListener(HypixelChatModifier plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onPlayerMessageSend(PlayerChatEvent event) {
        String message = event.getMessage();
        List<String> wordInMessageList = plugin.getConfig().getStringList("wordInMessage");
        List<String> specificMesageList = plugin.getConfig().getStringList("specificMessage");
        List<String> replacedText = plugin.getConfig().getStringList("replacedText");

        int randomInt = ThreadLocalRandom.current().nextInt(replacedText.size());

        for (CharSequence words : wordInMessageList) {
            if (message.toLowerCase().contains(words)) {
                event.setMessage(replacedText.get(randomInt));
            }
        }

        for (CharSequence words : specificMesageList) {
            if (message.contentEquals(words)) {
                event.setMessage(replacedText.get(randomInt));
            }
        }
    }

}











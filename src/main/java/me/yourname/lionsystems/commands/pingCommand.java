package me.yourname.lionsystems.commands;

import de.lioncraft.lionapi.messageHandling.defaultMessages;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pingCommand implements TabExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if(sender instanceof Player){
                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Your current Ping is " + ((Player) sender).getPing() + "ms.")));
            }else{
                sender.sendMessage(defaultMessages.notAPlayer);
            }
        }else{
            Player p = Bukkit.getPlayer(args[0]);
            if(p!=null){
                sender.sendMessage(defaultMessages.messagePrefix.append(p.displayName()).append(Component.text(" has a Ping of " + p.getPing() + "ms.")));
            }else{
                sender.sendMessage(defaultMessages.noPlayer);
            }
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 1){
            return null;
        }else{
            return new ArrayList<>(Collections.singleton(""));
        }

    }
}

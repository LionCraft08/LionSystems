package me.yourname.lionsystems.commands;

import de.lioncraft.lionapi.messageHandling.defaultMessages;
import me.yourname.lionsystems.LionSystems;
import me.yourname.lionsystems.utilities.seeInv;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class inv implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(args.length >= 1){
                OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
                if(p.getPlayer() != null){
                    seeInv.viewInv((Player) sender, p.getPlayer());
                    return false;
                }else{
                    sender.sendMessage(defaultMessages.noPlayer);
                }
            }else{
                sender.sendMessage(defaultMessages.wrongArgs);
            }
        }else{
            sender.sendMessage(defaultMessages.notAPlayer);
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }
}

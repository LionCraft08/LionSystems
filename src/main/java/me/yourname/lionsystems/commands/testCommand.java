package me.yourname.lionsystems.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class testCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        switch (strings[0]){
            case "1":
                Team team = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(strings[0]);
                team.addPlayer((OfflinePlayer) commandSender);
                commandSender.sendMessage(team.getName());
                break;
            case "2":
                commandSender.sendMessage(Bukkit.getScoreboardManager().getMainScoreboard().getEntityTeam((Player) commandSender).getName());
                break;
            case "3":

                break;
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}

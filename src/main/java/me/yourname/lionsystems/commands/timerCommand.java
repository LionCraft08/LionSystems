package me.yourname.lionsystems.commands;

import de.lioncraft.lionapi.messageHandling.defaultMessages;
import me.yourname.lionsystems.LionSystems;
import me.yourname.lionsystems.utilities.stopwatch;
import me.yourname.lionsystems.utilities.timer;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class timerCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(LionSystems.isStopwatch){
            switch (args.length){
                case 1:
                    if(args[0].equals("start")){
                        if(LionSystems.stopwatch != null){
                            LionSystems.stopwatch.start();
                        }else{
                            LionSystems.stopwatch = new stopwatch(0, 0, 0, 0);
                            LionSystems.stopwatch.start();
                        }
                    } else if (args[0].equals("pause")) {
                        LionSystems.stopwatch.pause();
                    } else if (args[0].equals("reset")) {
                        LionSystems.stopwatch.setDays(0);
                        LionSystems.stopwatch.setHours(0);
                        LionSystems.stopwatch.setMinutes(0);
                        LionSystems.stopwatch.setSeconds(0);
                    } else {
                        sender.sendMessage(defaultMessages.wrongArgs);
                    }
                    break;
                case 5:
                    if(args[0].equals("start")){
                        if(LionSystems.stopwatch != null){
                            try {
                                LionSystems.stopwatch.setDays(Integer.parseInt(args[1]));
                                LionSystems.stopwatch.setHours(Integer.parseInt(args[2]));
                                LionSystems.stopwatch.setMinutes(Integer.parseInt(args[3]));
                                LionSystems.stopwatch.setSeconds(Integer.parseInt(args[4]));
                            }catch (NumberFormatException e){
                                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Make sure you use numbers as parameters 2-5")));
                            }
                            LionSystems.stopwatch.start();

                        }else{
                            try {
                                LionSystems.stopwatch = new stopwatch(Integer.parseInt(args[1]),Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                            }
                            catch (NumberFormatException e){
                                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Make sure you use numbers as parameters 2-5")));
                            }
                            LionSystems.stopwatch.start();
                        }
                    } else if (args[0].equals("set")) {
                        try {
                            LionSystems.stopwatch.setDays(Integer.parseInt(args[1]));
                            LionSystems.stopwatch.setHours(Integer.parseInt(args[2]));
                            LionSystems.stopwatch.setMinutes(Integer.parseInt(args[3]));
                            LionSystems.stopwatch.setSeconds(Integer.parseInt(args[4]));
                        }catch (NumberFormatException e){
                            sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Make sure you use numbers as parameters 2-5")));
                        }
                    }else{
                        sender.sendMessage(defaultMessages.wrongArgs);
                    }
                    break;
                default:
                    sender.sendMessage(defaultMessages.wrongArgs);
            }
        }else{
            switch (args.length){
                case 1:
                    if(args[0].equals("start")){
                        if(LionSystems.timer != null){
                            LionSystems.timer.start();
                        }else{
                            LionSystems.timer = new timer(0, 1, 0, 0);
                            LionSystems.timer.start();
                        }
                    } else if (args[0].equals("pause")) {
                        if(LionSystems.timer != null){
                            if(LionSystems.timer.isActive()){
                                LionSystems.timer.pause();
                                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Successfully paused the Timer")));
                            }else{
                                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("The Timer is currently paused!")));
                            }
                        }else {
                            sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("The Timer is currently paused!")));
                        }
                    } else if (args[0].equals("reset")) {
                        if(LionSystems.timer != null){
                            int days = LionSystems.timer.getSecondsAtStart()/(3600*24);
                            int hours = (LionSystems.timer.getSecondsAtStart()/3600)- (days*24);
                            int minutes = LionSystems.timer.getSecondsAtStart()/(60)- (days*24 + hours) * 60;
                            int seconds = LionSystems.timer.getSecondsAtStart() - ((days*24 + hours) * 60 + minutes) * 60;
                            LionSystems.timer.setDays(days);
                            LionSystems.timer.setHours(hours);
                            LionSystems.timer.setMinutes(minutes);
                            LionSystems.timer.setSeconds(seconds);
                            sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Successfully restarted the Timer")));
                        }

                    } else {
                        sender.sendMessage(defaultMessages.wrongArgs);
                    }
                    break;
                case 5:
                    if(args[0].equals("start")){
                        if(LionSystems.stopwatch != null){
                            try {
                                LionSystems.stopwatch.setDays(Integer.parseInt(args[1]));
                                LionSystems.stopwatch.setHours(Integer.parseInt(args[2]));
                                LionSystems.stopwatch.setMinutes(Integer.parseInt(args[3]));
                                LionSystems.stopwatch.setSeconds(Integer.parseInt(args[4]));
                                LionSystems.stopwatch.start();
                            }catch (NumberFormatException e){
                                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Make sure you use numbers as parameters 2-5")));
                            }
                        }else{
                            try {
                                LionSystems.stopwatch = new stopwatch(Integer.parseInt(args[1]),Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                                LionSystems.stopwatch.start();
                            }
                            catch (NumberFormatException e){
                                sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Make sure you use numbers as parameters 2-5")));
                            }

                        }
                    } else if (args[0].equals("set")) {
                        try {
                            LionSystems.stopwatch.setDays(Integer.parseInt(args[1]));
                            LionSystems.stopwatch.setHours(Integer.parseInt(args[2]));
                            LionSystems.stopwatch.setMinutes(Integer.parseInt(args[3]));
                            LionSystems.stopwatch.setSeconds(Integer.parseInt(args[4]));
                        }catch (NumberFormatException e){
                            sender.sendMessage(defaultMessages.messagePrefix.append(Component.text("Make sure you use numbers as parameters 2-5")));
                        }
                    }else{
                        sender.sendMessage(defaultMessages.wrongArgs);
                    }
                    break;
                default:
                    sender.sendMessage(defaultMessages.wrongArgs);
            }
        }
        return true;

    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        List<String> strings = new ArrayList<>();
        switch (args.length){
            case 1:
                strings.add("start");
                strings.add("set");
                strings.add("pause");
                strings.add("reset");
                break;
            case 2:
                if(args[0].equals("set")||args[0].equals("start")){
                    strings.add("<days>");
                }
                break;
            case 3:
                if(args[0].equals("set")||args[0].equals("start")){
                    strings.add("<hours>");
                }
                break;
            case 4:
                if(args[0].equals("set")||args[0].equals("start")){
                    strings.add("<minutes>");
                }
                break;
            case 5:
                if(args[0].equals("set")||args[0].equals("start")){
                    strings.add("<seconds>");
                }
                break;
            default:
                break;

        }
        return strings;
    }
}

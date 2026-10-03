package me.iLatteSoft.inventorySnapshot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PluginCommand implements TabExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {

        if (command.getName().equalsIgnoreCase("inventorysnapshot") && args.length == 2) {
            if (args[1].equalsIgnoreCase("create")) {

            }

            if (args[1].equalsIgnoreCase("purge")) {

            }

            if (args[1].equalsIgnoreCase("view")) {

            }

            if (args[1].equalsIgnoreCase("reload")) {
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {

        if (command.getName().equalsIgnoreCase("inventorysnapshot") && args.length == 1) {
            return List.of("create", "purge", "view", "reload");
        }

        return List.of();
    }
}

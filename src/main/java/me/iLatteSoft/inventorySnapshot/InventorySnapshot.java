package me.iLatteSoft.inventorySnapshot;

import me.iLatteSoft.inventorySnapshot.commands.PluginCommand;
import me.iLatteSoft.inventorySnapshot.repositories.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class InventorySnapshot extends JavaPlugin {

    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        this.databaseManager = new DatabaseManager(this);
        if (!databaseManager.initialize()) {
            this.getLogger().warning("Database initialization failed!");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        // Command registers.
        Objects.requireNonNull(this.getCommand("inventorysnapshots")).setExecutor(new PluginCommand());

    }

    @Override
    public void onDisable() {
        this.databaseManager.close();
        this.getLogger().info("InventorySnapshot has been shut down successfully!");
    }
}

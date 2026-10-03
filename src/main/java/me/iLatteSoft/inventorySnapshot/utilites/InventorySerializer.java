package me.iLatteSoft.inventorySnapshot.utilites;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Base64;

public class InventorySerializer {

    public static String toBase64(final Player player) {
        final ItemStack[] contents = player.getInventory().getContents();
        final byte[] bytes = ItemStack.serializeItemsAsBytes(contents);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String toBase64(final ItemStack[] contents) {
        return Base64.getEncoder().encodeToString(ItemStack.serializeItemsAsBytes(contents));
    }

    public static ItemStack[] fromBase64(final String base64) {
        final byte[] bytes = Base64.getDecoder().decode(base64);
        return ItemStack.deserializeItemsFromBytes(bytes);
    }

    public static void restore(final Player player, final String base64) {
        player.getInventory().setContents(fromBase64(base64));
        player.updateInventory();
    }
}
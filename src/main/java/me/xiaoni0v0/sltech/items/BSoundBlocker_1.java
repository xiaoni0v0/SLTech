package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BSoundBlocker_1 extends SlimefunItem {
    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "B_SOUND_BLOCKER_1",
            Material.GOLDEN_HELMET,
            "&6隔音头盔 &7- &cI",

            "",
            "&7可以减弱85%的声音",
            "&7……仅限 &6B动静制造器 &7- &c全服版 &7制造出的声音",
            "&7（当然你也可以直接调小游戏音量）"
    );

    public BSoundBlocker_1(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.SPONGE), new ItemStack(Material.SPONGE), new ItemStack(Material.SPONGE),
                        new ItemStack(Material.SPONGE), null, new ItemStack(Material.SPONGE),
                        null, null, null
                }
        );
    }

    public static SlimefunItemStack getItemStack() {
        return itemStack;
    }
}

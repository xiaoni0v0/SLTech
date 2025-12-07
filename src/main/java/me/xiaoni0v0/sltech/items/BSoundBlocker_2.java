package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BSoundBlocker_2 extends SlimefunItem {
    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "B_SOUND_BLOCKER_2",
            Material.GOLDEN_HELMET,
            "&6隔音头盔 &7- &cII",

            "",
            "&7可以隔绝声音",
            "&7……仅限 &6B动静制造器 &7- &c全服版 &7制造出的声音",
            "&7（当然你也可以直接把声音关掉）"
    );

    public BSoundBlocker_2(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BSoundBlocker_1.getItemStack(), BSoundBlocker_1.getItemStack(), BSoundBlocker_1.getItemStack(),
                        BSoundBlocker_1.getItemStack(), null, BSoundBlocker_1.getItemStack(),
                        null, null, null
                }
        );
    }

    public static SlimefunItemStack getItemStack() {
        return itemStack;
    }
}

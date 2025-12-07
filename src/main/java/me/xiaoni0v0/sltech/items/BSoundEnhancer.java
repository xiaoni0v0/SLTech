package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BSoundEnhancer extends SlimefunItem {
    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "B_SOUND_ENHANCER",
            Material.GOLDEN_HELMET,
            "&6强音头盔",

            "",
            "&7好神经啊……",
            "&7可以……增强声音",
            "&7……仅限 &6B动静制造器 &7- &c全服版 &7制造出的声音"
    );

    public BSoundEnhancer(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.WET_SPONGE), new ItemStack(Material.WET_SPONGE), new ItemStack(Material.WET_SPONGE),
                        new ItemStack(Material.WET_SPONGE), null, new ItemStack(Material.WET_SPONGE),
                        null, null, null
                }
        );
    }

    public static SlimefunItemStack getItemStack() {
        return itemStack;
    }
}

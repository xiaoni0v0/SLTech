package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ShrinkingBoots extends SlimefunItem {
    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "SLTECH_SHRINKING_BOOTS",
            new ItemStack(Material.DIAMOND_BOOTS),
            "&a小人鞋",

            "",
            "&7小人国的鞋，穿上就小小的",
            "&7小小的也很可爱捏~(￣▽￣)~*"
    );

    static {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta != null) {
            meta.addAttributeModifier(
                    Attribute.MAX_HEALTH,
                    new AttributeModifier(
                            Objects.requireNonNull(NamespacedKey.fromString("sltech:shrinking_boots.max_health")),
                            -0.5,
                            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
                            EquipmentSlotGroup.FEET
                    )
            );
            meta.addAttributeModifier(
                    Attribute.SCALE,
                    new AttributeModifier(
                            Objects.requireNonNull(NamespacedKey.fromString("sltech:shrinking_boots.scale")),
                            -0.5,
                            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
                            EquipmentSlotGroup.FEET
                    )
            );
        }

        itemStack.setItemMeta(meta);
    }

    public ShrinkingBoots(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.ELECTRIC_PRESS_2, SlimefunItems.ELECTRIC_PRESS, SlimefunItems.ELECTRIC_PRESS_2,
                        SlimefunItems.REINFORCED_ALLOY_INGOT, null, SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.SYNTHETIC_DIAMOND, null, SlimefunItems.SYNTHETIC_DIAMOND
                }
        );
    }
}

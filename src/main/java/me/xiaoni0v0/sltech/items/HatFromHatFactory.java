package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HatFromHatFactory extends SlimefunArmorPiece {
    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "SLTECH_HAT_FROM_HAT_FACTORY",
            Material.LEATHER_HELMET, Color.BLACK,
            "&0帽子工厂里的帽子",

            "",
            "&7最近有家工厂的货卖不出去了……",
            "&7没人要哇……",
            "&7帽子！",
            "&7那帽子可大！",
            "&7分量重啊！",
            "&7你带上受不了！",
            "&4&n戴上可就摘不下来了……"
    );

    static {
        itemStack.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
    }

    public HatFromHatFactory(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ARMOR_FORGE,
                new ItemStack[]{
                        new ItemStack(Material.OMINOUS_BOTTLE), new ItemStack(Material.OMINOUS_BOTTLE), new ItemStack(Material.OMINOUS_BOTTLE),
                        new ItemStack(Material.OMINOUS_BOTTLE), null, new ItemStack(Material.OMINOUS_BOTTLE),
                        null, null, null
                },
                new PotionEffect[]{
                        new PotionEffect(PotionEffectType.BLINDNESS, 600, 20), // 失明
                        new PotionEffect(PotionEffectType.DARKNESS, 600, 20),  // 黑暗
                        new PotionEffect(PotionEffectType.SLOWNESS, 600, 20),  // 缓慢
                        new PotionEffect(PotionEffectType.WEAKNESS, 600, 20),  // 虚弱
                        new PotionEffect(PotionEffectType.POISON, 600, 20),    // 中毒
                        new PotionEffect(PotionEffectType.HUNGER, 600, 20),    // 饥饿
                }
        );
    }
}

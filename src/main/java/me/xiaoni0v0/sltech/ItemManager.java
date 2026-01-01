package me.xiaoni0v0.sltech;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.xiaoni0v0.sltech.items.*;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class ItemManager {
    private final SLTech plugin;
    private ItemGroup itemGroup;

    public ItemManager(SLTech plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        registerAllGroups();
        registerAllItems();
    }

    private void registerAllGroups() {
        itemGroup = new ItemGroup(
                // 给你的分类提供一个独一无二的ID
                new NamespacedKey(plugin, "sltech"),
                // 分类的显示物品将使用以下物品
                new CustomItemStack(Material.DIAMOND, "&b&l&nSL科技")
        );
    }

    private void registerAllItems() {
        new SuicideStone(plugin).register(plugin);
        new ArmorRemovalButton(plugin).register(plugin);
        new BSoundMakerAllPlayers(plugin).register(plugin);
        new BSoundBlocker_1(plugin).register(plugin);
        new BSoundBlocker_2(plugin).register(plugin);
        new BSoundEnhancer(plugin).register(plugin);
        // 从此往后的物品的粘液物品 ID 记得加 SLTECH_ 前缀，以前的因为已经有了所以改不了了
        new ShrinkingBoots(plugin).register(plugin);
        new HatFromHatFactory(plugin).register(plugin);
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}

package me.xiaoni0v0.sltech;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.xiaoni0v0.sltech.items.ArmorRemovalButton;
import me.xiaoni0v0.sltech.items.SuicideStone;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class ItemManager {
    public static final ItemManager instance = new ItemManager();

    private boolean isRegistered = false;
    ItemGroup itemGroup;

    public void registerAll(SLTech plugin) {
        if (isRegistered) return;
        isRegistered = true;
        registerAllGroups(plugin);
        registerAllItems(plugin);
    }

    private void registerAllGroups(SLTech plugin) {
        itemGroup = new ItemGroup(
                // 给你的分类提供一个独一无二的ID
                new NamespacedKey(plugin, "sltech"),
                // 分类的显示物品将使用以下物品
                new CustomItemStack(Material.DIAMOND, "&b&l&nSL科技")
        );
    }

    private void registerAllItems(SLTech plugin) {
        new SuicideStone(itemGroup).register(plugin);
        new ArmorRemovalButton(itemGroup).register(plugin);
    }
}

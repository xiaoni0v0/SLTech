package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ArmorRemovalButton extends SlimefunItem implements Rechargeable {
    private static final float CAPACITY = 100.0F;
    private static final float COST = 10.0F;

    public ArmorRemovalButton(ItemGroup itemGroup) {
        super(
                itemGroup,
                new SlimefunItemStack(
                        "ARMOR_REMOVAL_BUTTON",
                        Material.STONE_BUTTON,
                        "&c脱&e甲&b按&a钮",
                        "", "&7将所有护甲移到背包中", "&7没想到吧，这个小东西是耗电的……",
                        LoreBuilder.powerCharged(0, (int) CAPACITY),
                        "",
                        "&e右键&7 使用"
                ),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.STONE_BUTTON), SlimefunItems.CARBONADO_MULTI_TOOL, new ItemStack(Material.STONE_BUTTON),
                        new ItemStack(Material.STONE_BUTTON), SlimefunItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.STONE_BUTTON),
                        new ItemStack(Material.STONE_BUTTON), new ItemStack(Material.PISTON), new ItemStack(Material.STONE_BUTTON)
                }
        );
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onItemUseRightClick);
    }

    private void onItemUseRightClick(PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();

        if (!removeItemCharge(event.getItem(), COST)) {
            player.sendMessage(ChatColor.RED + "没电了……");
            return;
        }

        // 1. 统计需要几个空余的格子
        ArrayList<Integer> armorIndex = new ArrayList<>();
        for (int i = 36; i < 40; i++) {
            if (inventory.getItem(i) != null) armorIndex.add(i);
        }
        if (armorIndex.isEmpty()) {
            player.sendMessage(ChatColor.AQUA + "没有盔甲不需要使用脱甲按钮！");
            return;
        }
        final int n = armorIndex.size();

        // 2. 找到 {那么多} 个空余的格子
        ArrayList<Integer> emptyIndexes = new ArrayList<>();
        for (int i = 0; i < 36 && emptyIndexes.size() < n; i++) {
            if (inventory.getItem(i) == null) {
                emptyIndexes.add(i);
            }
        }
        if (emptyIndexes.size() < n) {
            player.sendMessage(ChatColor.RED + "您的背包没有足够的空间（需要 " + n + " 个）！");
            return;
        }

        // 3. 将 {那么多} 个盔甲移动到空余的格子里
        for (int i = 0; i < n; i++) {
            inventory.setItem(emptyIndexes.get(i), inventory.getItem(armorIndex.get(i)));
            inventory.setItem(armorIndex.get(i), null);
        }

        player.sendMessage(ChatColor.AQUA + "操作成功！");
    }

    @Override
    public float getMaxItemCharge(ItemStack item) {
        return CAPACITY;
    }
}

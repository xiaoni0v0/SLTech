package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SuicideStone extends SlimefunItem {
    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "SUICIDE_STONE",
            Material.AMETHYST_SHARD,
            "&d紫砂",

            "",
            "&7就是紫砂"
    );

    public SuicideStone(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null, new ItemStack(Material.FLINT), null,
                        null, new ItemStack(Material.FLINT), null,
                        new ItemStack(Material.FLINT), new ItemStack(Material.FLINT), new ItemStack(Material.FLINT)
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
        // 发送消息，紫色的字
        player.sendMessage(ChatColor.LIGHT_PURPLE + "诶你怎么似了！");
        player.setHealth(0);
    }
}

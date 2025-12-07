package me.xiaoni0v0.sltech.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.xiaoni0v0.sltech.SLTech;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;

public class BSoundMakerAllPlayers extends SlimefunItem implements Rechargeable {
    private final SLTech plugin;

    private static final float CAPACITY = 6000.0F;
    private final Sound[] allSounds = Sound.values();
    // B动静的种数
    private final int SOUND_COUNT = 500;
    // 播放的时间（毫秒）
    private final int SOUND_DURATION = 2500;

    private static final SlimefunItemStack itemStack = new SlimefunItemStack(
            "B_SOUND_MAKER_ALL_PLAYERS",
            Material.BELL,
            "&6B动静制造器 &7- &c全服版",

            "",
            "&7向全服播放好听的B动静",
            LoreBuilder.powerCharged(0, (int) CAPACITY),
            "",
            "&e右键&7 使用"
    );

    public BSoundMakerAllPlayers(SLTech plugin) {
        super(
                plugin.getItemManager().getItemGroup(),
                itemStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.BEE_SPAWN_EGG), SlimefunItems.FREEZER_3, SlimefunItems.EXP_COLLECTOR,
                        new ItemStack(Material.PAPER), new ItemStack(Material.SEAGRASS), new ItemStack(Material.WHITE_BANNER),
                        SlimefunItems.PROGRAMMABLE_ANDROID_3, SlimefunItems.NETHER_STAR_REACTOR, SlimefunItems.PROGRAMMABLE_ANDROID_3
                }
        );

        this.plugin = plugin;
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onItemUseRightClick);
    }

    private void onItemUseRightClick(PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();

        if (!removeItemCharge(event.getItem(), CAPACITY)) {
            player.sendMessage(ChatColor.RED + "没电了……");
            return;
        }

        // 通知全服谁使用了B动静制造器
        Bukkit.broadcastMessage(
                ChatColor.GREEN + player.getName()
                        + ChatColor.GOLD + " 使用了 "
                        + this.getItemName()
                        + ChatColor.GOLD + "！"
        );

        // “精挑细选”一些B动静
        ArrayList<Sound> result = new ArrayList<>();
        while (result.size() < SOUND_COUNT) {
            Sound chosen = allSounds[(int) (Math.random() * allSounds.length)];
            // 音乐不要
            if (chosen.toString().startsWith("MUSIC")) continue;
            result.add(chosen);
        }

        // 异步执行耗时任务
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            // 想要增强音效的 “VIP” 玩家们（好神经啊）
            HashSet<Player> vipPlayers = new HashSet<>();

            for (Sound sound : result) {
                // 每个玩家都播放B动静
                for (Player eachPlayer : Bukkit.getOnlinePlayers()) {
                    // 如果戴着头盔则相应改变音量
                    ItemStack helmet = eachPlayer.getInventory().getHelmet();
                    eachPlayer.playSound(
                            eachPlayer.getLocation(),
                            sound,
                            BSoundBlocker_1.getItemStack().isSimilar(helmet) ? 0.15F :
                                    BSoundBlocker_2.getItemStack().isSimilar(helmet) ? 0.0F : 1.0F,
                            1.0F
                    );

                    if (BSoundEnhancer.getItemStack().isSimilar(helmet)) {
                        vipPlayers.add(eachPlayer);
                    }
                }
                // 保证所有播放都在 SOUND_DURATION 毫秒内完成
                sleep(SOUND_DURATION / SOUND_COUNT);
            }

            // 给 “VIP” 玩家继续播放
            for (int ignored : new int[]{0, 1, 2}) {
                for (Sound sound : result) {
                    for (Player eachVipPlayer : vipPlayers) {
                        eachVipPlayer.playSound(eachVipPlayer.getLocation(), sound, 1.0F, 1.0F);
                    }
                    sleep(SOUND_DURATION / SOUND_COUNT);
                }
            }
        });
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            plugin.getLogger().warning("InterruptedException: " + e);
        }
    }

    @Override
    public float getMaxItemCharge(ItemStack item) {
        return CAPACITY;
    }
}

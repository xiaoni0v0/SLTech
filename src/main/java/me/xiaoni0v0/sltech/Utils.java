package me.xiaoni0v0.sltech;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Utils {
    /**
     * 获取当前日期字符串
     *
     * @return 如 "2007-12-03"
     */
    public static String getDateString() {
        return java.time.LocalDate.now().toString();
    }

    /**
     * 返回物品的粘液 ID 是否与指定的相等
     *
     * @param itemStack 物品
     * @param id        粘液 ID
     */
    public static boolean checkSfItemID(@Nullable ItemStack itemStack, @Nonnull String id) {
        // AIR
        if (itemStack == null) {
            return false;
        }
        // 不是粘液物品
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (slimefunItem == null) {
            return false;
        }
        // ID 是否匹配
        return slimefunItem.getId().equals(id);
    }
}

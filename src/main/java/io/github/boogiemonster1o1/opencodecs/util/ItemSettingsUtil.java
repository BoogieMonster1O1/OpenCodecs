package io.github.boogiemonster1o1.opencodecs.util;

import io.github.boogiemonster1o1.opencodecs.mixin.ItemSettingsAccess;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public final class ItemSettingsUtil {
    public static int getMaxCount(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).getMaxCount();
    }

    public static int getMaxDamage(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).getMaxDamage();
    }

    public static Item getRecipeRemainder(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).getRecipeRemainder();
    }

    public static ItemGroup getItemGroup(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).getGroup();
    }

    public static Rarity getRarity(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).getRarity();
    }

    public static FoodComponent getFoodComponent(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).getFoodComponent();
    }

    public static boolean isFireproof(Item.Settings settings) {
        return ((ItemSettingsAccess) settings).isFireproof();
    }
}

package io.github.boogiemonster1o1.opencodecs.builder;

import java.util.Objects;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ItemSettingsBuilder {
    public static Item.Settings createV0(int maxCount, int maxDamage, String recipeRemainderId, String itemGroupName, String rarity, FoodComponent food, boolean fireproof) {
        Item.Settings settings = new Item.Settings().maxCount(maxCount).maxDamage(maxDamage).rarity(Rarity.valueOf(rarity));
        if (fireproof) {
            settings.fireproof();
        } if (food != null) {
            settings.food(food);
        } if (recipeRemainderId != null) {
            Item item = Objects.requireNonNull(Registry.ITEM.get(Identifier.tryParse(recipeRemainderId)), "Unknown Recipe remainder Item with id " + recipeRemainderId);
            settings.recipeRemainder(item);
        } if (itemGroupName != null) {
            for (ItemGroup group : ItemGroup.GROUPS) {
                System.out.println(group.getName());
                if (group.getName().equals(itemGroupName)) {
                    settings.group(group);
                    break;
                }
                throw new RuntimeException("Unknown Item group with name: " + itemGroupName);
            }
        }
        return settings;
    }
}

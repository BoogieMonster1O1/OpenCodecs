package io.github.boogiemonster1o1.opencodecs.builder;

import net.minecraft.item.FoodComponent;

public class FoodComponentBuilder {
    public static FoodComponent createV0(int hunger, double saturationModifier, boolean meat, boolean alwaysEdible, boolean snack) {
        FoodComponent.Builder builder = new FoodComponent.Builder().saturationModifier((float) saturationModifier).hunger(hunger);
        if (meat) {
            builder.meat();
        } if (alwaysEdible) {
            builder.alwaysEdible();
        } if (snack) {
            builder.snack();
        }
        return builder.build();
    }
}

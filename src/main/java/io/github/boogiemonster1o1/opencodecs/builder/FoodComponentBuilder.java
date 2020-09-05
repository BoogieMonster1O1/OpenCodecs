package io.github.boogiemonster1o1.opencodecs.builder;

import java.util.List;

import com.mojang.datafixers.util.Pair;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

public class FoodComponentBuilder {
    public static FoodComponent createV0(int hunger, double saturationModifier, boolean meat, boolean alwaysEdible, boolean snack, List<Pair<StatusEffectInstance, Float>> pairList) {
        FoodComponent.Builder builder = new FoodComponent.Builder().saturationModifier((float) saturationModifier).hunger(hunger);
        if (meat) {
            builder.meat();
        } if (alwaysEdible) {
            builder.alwaysEdible();
        } if (snack) {
            builder.snack();
        } if (pairList != null) {
            for (Pair<StatusEffectInstance, Float> pair : pairList) {
                builder.statusEffect(pair.getFirst(), pair.getSecond());
            }
        }
        return builder.build();
    }
}

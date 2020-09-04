package io.github.boogiemonster1o1.opencodecs.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ItemBuilder {
    public static Item createV0(String name, Item.Settings settings, int enchantability, List<String> tooltips, boolean glint, boolean enchantable, String drinkSound, String eatSound) {
        return new Item(settings) {
            @Override
            public boolean isEnchantable(ItemStack stack) {
                return enchantable;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Environment(EnvType.CLIENT)
            @Override
            public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
                tooltip.addAll(tooltips.stream().map(TranslatableText::new).collect(Collectors.toList()));
            }

            @Override
            public boolean hasGlint(ItemStack stack) {
                return glint;
            }

            @Override
            public SoundEvent getDrinkSound() {
                return Objects.requireNonNull(Registry.SOUND_EVENT.get(new Identifier(drinkSound)), "Unknown Sound Event with id: " + drinkSound);
            }

            @Override
            public SoundEvent getEatSound() {
                return Objects.requireNonNull(Registry.SOUND_EVENT.get(new Identifier(eatSound)), "Unknown Sound Event with id: " + eatSound);
            }

            {
                Registry.register(Registry.ITEM, new Identifier("modid", name), this);
            }
        };
    }
}

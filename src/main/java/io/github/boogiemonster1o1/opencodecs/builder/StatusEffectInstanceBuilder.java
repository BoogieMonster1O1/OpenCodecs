package io.github.boogiemonster1o1.opencodecs.builder;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StatusEffectInstanceBuilder {
    public static StatusEffectInstance createV0(String id, int duration, int amplifier) {
        return new StatusEffectInstance(Registry.STATUS_EFFECT.get(new Identifier(id)), duration, amplifier);
    }
}

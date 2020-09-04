package io.github.boogiemonster1o1.opencodecs.mixin;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

@Mixin(Registry.class)
public interface RegistryAccess {
    @Invoker
    static <T> Registry<T> invokeCreate(RegistryKey<? extends Registry<T>> registryKey, Supplier<T> defaultEntry) {
        throw new AssertionError();
    }
}

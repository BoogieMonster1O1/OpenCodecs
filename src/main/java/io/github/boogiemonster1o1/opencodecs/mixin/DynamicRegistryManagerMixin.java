package io.github.boogiemonster1o1.opencodecs.mixin;

import io.github.boogiemonster1o1.opencodecs.codec.CursedItemCodecs;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

@Mixin(DynamicRegistryManager.class)
public class DynamicRegistryManagerMixin {
    @Unique
    private static boolean initialized = false;

    @Inject(at = @At("HEAD"), method = "register(Lcom/google/common/collect/ImmutableMap$Builder;Lnet/minecraft/util/registry/RegistryKey;Lcom/mojang/serialization/Codec;)V")
    private static <E> void intercept(ImmutableMap.Builder<RegistryKey<? extends Registry<?>>, DynamicRegistryManager.Info<?>> infosBuilder, RegistryKey<? extends Registry<E>> registryRef, Codec<E> entryCodec, CallbackInfo ci) {
        if (!initialized) {
            initialized = true;
            infosBuilder.put(Registry.ITEM_KEY, new DynamicRegistryManager.Info<>(Registry.ITEM_KEY, CursedItemCodecs.ITEM_CODEC_V0, null));
        }
    }
}

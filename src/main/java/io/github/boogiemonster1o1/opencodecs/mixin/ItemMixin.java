package io.github.boogiemonster1o1.opencodecs.mixin;

import io.github.boogiemonster1o1.opencodecs.codec.Shared;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.item.Item;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(at = @At("RETURN"), method = "<init>")
    public void captureSettings(Item.Settings settings, CallbackInfo ci) {
        Shared.ITEM_SETTINGS_MAP.putIfAbsent((Item) (Object) this, settings);
    }
}

package io.github.boogiemonster1o1.opencodecs;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import blue.endless.jankson.impl.SyntaxError;
import io.github.boogiemonster1o1.opencodecs.codec.CursedItemCodecs;
import io.github.boogiemonster1o1.opencodecs.util.JanksonOps;
import sun.misc.Unsafe;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Objects;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DataDrivenMinecraft implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Unsafe UNSAFE;

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            try(InputStream in = DataDrivenMinecraft.class.getResourceAsStream("/test.json")) {
                Jankson j = Jankson.builder().build();
                JsonObject json = j.load(in);
                DataResult<Pair<Item, JsonElement>> result = CursedItemCodecs.ITEM_CODEC_V0.decode(JanksonOps.INSTANCE, json);
                Pair<Item, JsonElement> pair = result.getOrThrow(false, System.err::println);
//                server.getRegistryManager().get(Registry.ITEM_KEY).add(RegistryKey.of(Registry.ITEM_KEY, new Identifier("modid:", ((JsonPrimitive) Objects.requireNonNull(json.get("name"))).asString())), pair.getFirst(), null);
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
                UNSAFE.throwException(e);
            }
        });
    }

    static {
        Unsafe theUnsafe = null;
        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            theUnsafe = (Unsafe) unsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        UNSAFE = theUnsafe;
    }
}

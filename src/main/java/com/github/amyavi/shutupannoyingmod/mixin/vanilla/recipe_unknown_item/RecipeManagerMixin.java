package com.github.amyavi.shutupannoyingmod.mixin.vanilla.recipe_unknown_item;

import com.google.gson.JsonSyntaxException;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.crafting.RecipeManager;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {
    @WrapWithCondition(
            method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", remap = false)
    )
    private boolean ignoreUnknownItem(final Logger instance, final String s, final Object o, final Object o2,
                                      final @Local(ordinal = 0) RuntimeException exception) {
        if (!(exception instanceof final JsonSyntaxException syntaxException)) return true;

        return !syntaxException.getMessage().startsWith("Unknown item '");
    }
}

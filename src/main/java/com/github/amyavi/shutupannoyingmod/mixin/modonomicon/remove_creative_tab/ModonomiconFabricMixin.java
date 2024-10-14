package com.github.amyavi.shutupannoyingmod.mixin.modonomicon.remove_creative_tab;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.klikli_dev.modonomicon.ModonomiconFabric;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("modonomicon")
@Mixin(ModonomiconFabric.class)
public abstract class ModonomiconFabricMixin {
    @WrapOperation(
            method = "onInitialize",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;register(Lnet/minecraft/core/Registry;Lnet/minecraft/resources/ResourceKey;Ljava/lang/Object;)Ljava/lang/Object;")
    )
    private <V, T extends V> T register(final Registry<V> registry, final ResourceKey<V> resourceKey, final T object,
                                        final Operation<T> original) {
        return null;
    }

    @WrapOperation(
            method = "onInitialize", remap = false,
            at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/api/event/Event;register(Ljava/lang/Object;)V", ordinal = 0, remap = false)
    )
    private<T> void eventRegister(final Event<T> instance, final T t, final Operation<Void> original) {
    }
}

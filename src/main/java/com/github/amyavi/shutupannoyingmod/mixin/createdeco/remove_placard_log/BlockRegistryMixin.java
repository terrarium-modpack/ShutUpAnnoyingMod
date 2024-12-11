package com.github.amyavi.shutupannoyingmod.mixin.createdeco.remove_placard_log;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.github.talrey.createdeco.BlockRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("createdeco")
@Mixin(BlockRegistry.class)
public abstract class BlockRegistryMixin {
    @WrapOperation(
            method = "lambda$registerPlacards$31", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;)V", ordinal = 0, remap = false)
    )
    private static void registerPlacards$info(final Logger instance, final String s, final Operation<Void> original) {
    }
}

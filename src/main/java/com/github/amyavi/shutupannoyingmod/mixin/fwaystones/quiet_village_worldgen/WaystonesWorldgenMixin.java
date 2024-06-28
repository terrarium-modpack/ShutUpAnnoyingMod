package com.github.amyavi.shutupannoyingmod.mixin.fwaystones.quiet_village_worldgen;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import wraith.fwaystones.util.WaystonesWorldgen;

@Mixin(value = WaystonesWorldgen.class, remap = false)
public abstract class WaystonesWorldgenMixin {
    @WrapOperation(
            method = "registerVillage", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;)V", remap = false),
            require = 0
    )
    private static void registerVillageInfo(final Logger instance, final String s, final Operation<Void> original) {
        // Do nothing
    }
}

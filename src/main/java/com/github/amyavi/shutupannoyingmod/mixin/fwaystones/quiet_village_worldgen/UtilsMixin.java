package com.github.amyavi.shutupannoyingmod.mixin.fwaystones.quiet_village_worldgen;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import wraith.fwaystones.util.Utils;

@Mixin(value = Utils.class, remap = false)
public abstract class UtilsMixin {
    @WrapOperation(
            method = "addToStructurePool", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;error(Ljava/lang/String;)V", remap = false),
            require = 0
    )
    private static void registerVillageInfo(final Logger instance, final String s, final Operation<Void> original) {
        // Do nothing
    }
}

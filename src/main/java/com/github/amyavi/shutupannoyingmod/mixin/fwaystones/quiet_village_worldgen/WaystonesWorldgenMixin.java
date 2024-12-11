package com.github.amyavi.shutupannoyingmod.mixin.fwaystones.quiet_village_worldgen;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import wraith.fwaystones.util.WaystonesWorldgen;

@RequiresMod("fwaystones")
@Mixin(value = WaystonesWorldgen.class)
public abstract class WaystonesWorldgenMixin {
    @WrapOperation(
            method = "registerVillage", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;)V", remap = false)
    )
    private static void registerVillage$info(final Logger instance, final String s, final Operation<Void> original) {
    }
}

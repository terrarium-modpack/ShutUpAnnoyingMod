package com.github.amyavi.shutupannoyingmod.mixin.building_wands.useless_logs;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.nicguzzo.wands.WandsMod;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("wands")
@Mixin(WandsMod.class)
public abstract class WandsModMixin {
    @WrapOperation(
            method = "lambda$init$25", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;)V", remap = false)
    )
    private static void lambda25Info(final Logger instance, final String s, final Operation<Void> original) {
    }

    @WrapOperation(
            method = "lambda$init$22", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;error(Ljava/lang/String;)V", remap = false)
    )
    private static void lambda22Error(final Logger instance, final String s, final Operation<Void> original) {
    }

    @WrapOperation(
            method = "lambda$init$22", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;)V", remap = false)
    )
    private static void lambda22Info(final Logger instance, final String s, final Operation<Void> original) {
    }
}

package com.github.amyavi.shutupannoyingmod.mixin.porting_lib.config_changes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.fabricators_of_create.porting_lib.config.ModConfigSpec;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@SuppressWarnings("UnstableApiUsage")
@Mixin(value = ModConfigSpec.class, remap = false)
public abstract class ModConfigSpecMixin {
    @WrapOperation(
            method = "setConfig", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V", remap = false),
            require = 0
    )
    private void setConfigWarn(final Logger instance, final String s, final Object o, final Operation<Void> original) {
        // Do nothing
    }

    @WrapOperation(
            method = "lambda$setConfig$0", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", remap = false),
            require = 0
    )
    private static void setConfig0Warn(final Logger instance, final String s, final Object o, final Object o2,
                                       final Object o3, final Object o4, final Operation<Void> original) {
        // Do nothing
    }
}

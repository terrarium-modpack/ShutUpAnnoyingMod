package com.github.amyavi.shutupannoyingmod.mixin.forgeconfigapiport.config_changes;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraftforge.common.ForgeConfigSpec;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("forgeconfigapiport")
@Mixin(ForgeConfigSpec.class)
public abstract class ForgeConfigSpecMixin {
    @WrapOperation(
            method = "setConfig", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V", remap = false)
    )
    private void setConfigWarn(final Logger instance, final String s, final Object o, final Operation<Void> original) {
    }

    @WrapOperation(
            method = "lambda$setConfig$0", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;[Ljava/lang/Object;)V", remap = false)
    )
    private static void setConfig0Warn(final Logger instance, final String s, final Object[] o,
                                       final Operation<Void> original) {
    }
}

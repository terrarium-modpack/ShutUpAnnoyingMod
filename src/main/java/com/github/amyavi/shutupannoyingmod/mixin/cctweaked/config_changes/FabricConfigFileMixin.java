package com.github.amyavi.shutupannoyingmod.mixin.cctweaked.config_changes;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dan200.computercraft.shared.platform.FabricConfigFile;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("computercraft")
@Mixin(FabricConfigFile.class)
public abstract class FabricConfigFileMixin {
    @WrapOperation(
            method = "lambda$loadConfig$1", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;[Ljava/lang/Object;)V", remap = false)
    )
    private static void loadConfigWarn(final Logger instance, final String s, final Object[] o,
                                       final Operation<Void> original) {
    }
}

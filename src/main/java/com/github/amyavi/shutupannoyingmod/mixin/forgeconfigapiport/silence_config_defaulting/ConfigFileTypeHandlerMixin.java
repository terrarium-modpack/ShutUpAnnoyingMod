package com.github.amyavi.shutupannoyingmod.mixin.forgeconfigapiport.silence_config_defaulting;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import net.minecraftforge.fml.config.ConfigFileTypeHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@RequiresMod("forgeconfigapiport")
@Mixin(ConfigFileTypeHandler.class)
public abstract class ConfigFileTypeHandlerMixin {
    @Inject(
            method = "backUpConfig(Lcom/electronwill/nightconfig/core/file/CommentedFileConfig;I)V", remap = false,
            at = @At("HEAD"), cancellable = true
    )
    private static void backUpConfig(final CallbackInfo ci) {
        ci.cancel();
    }
}

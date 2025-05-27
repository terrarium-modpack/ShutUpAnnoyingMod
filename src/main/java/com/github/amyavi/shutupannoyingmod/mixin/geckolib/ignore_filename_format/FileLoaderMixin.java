package com.github.amyavi.shutupannoyingmod.mixin.geckolib.ignore_filename_format;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import software.bernie.geckolib.loading.FileLoader;

@RequiresMod("geckolib")
@Mixin(value = FileLoader.class, remap = false)
public abstract class FileLoaderMixin {
    @WrapOperation(method = {"loadAnimationsFile", "loadModelFile"},
            at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;)V"))
    private static void loadFile$warn(final Logger instance, final String s, final Operation<Void> original) {
    }
}

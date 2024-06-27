package com.github.amyavi.shutupannoyingmod.mixin.vanilla.missing_textures_in_model;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.resources.model.ModelManager;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ModelManager.class)
public abstract class ModelManagerMixin {
    @WrapOperation(
            method = "method_45879",
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", remap = false)
    )
    private static void warn(final Logger instance, final String s, final Object o1, final Object o2, final Operation<Void> original) {
        // Do nothing
    }
}

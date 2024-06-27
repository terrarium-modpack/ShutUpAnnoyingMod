package com.github.amyavi.shutupannoyingmod.mixin.porting_lib.missing_model_loader;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.block.model.BlockModel;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = BlockModel.Deserializer.class, priority = 2000, remap = false)
public abstract class BlockModelDeserializerMixinMixin {
    @TargetHandler(
            mixin = "io.github.fabricators_of_create.porting_lib.models.geometry.mixin.client.BlockModelDeserializerMixin",
            name = "deserializeGeometry"
    )
    @WrapOperation(
            method = "@MixinSquared:Handler",
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;)V", remap = false),
            require = 0
    )
    private static void warn(final Logger instance, final String s, final Operation<Void> original) {
        // Do nothing
    }
}

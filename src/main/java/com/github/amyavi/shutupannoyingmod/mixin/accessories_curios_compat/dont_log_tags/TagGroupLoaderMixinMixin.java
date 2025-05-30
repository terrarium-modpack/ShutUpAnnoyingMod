package com.github.amyavi.shutupannoyingmod.mixin.accessories_curios_compat.dont_log_tags;

import com.bawnorton.mixinsquared.TargetHandler;
import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.TagLoader;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod({"accessories", "curios"})
@Mixin(value = TagLoader.class, priority = 2500)
public abstract class TagGroupLoaderMixinMixin {
    @TargetHandler(mixin = "top.theillusivec4.curios.mixin.core.accessories.TagGroupLoaderMixin",
            name = "lambda$injectValues$1")
    @WrapOperation(method = "@MixinSquared:Handler",
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;[Ljava/lang/Object;)V"))
    private static void injectValues$warn(final Logger instance, final String s, final Object[] objects,
                                          final Operation<Void> original) {
    }
}

package com.github.amyavi.shutupannoyingmod.mixin.estrogen.dont_replace_splashes;

import com.bawnorton.mixinsquared.TargetHandler;
import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.resources.SplashManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@RequiresMod("estrogen")
@Mixin(value = SplashManager.class, priority = 2000)
public abstract class SplashManagerMixinMixin {
    @TargetHandler(
            mixin = "dev.mayaqq.estrogen.mixin.client.SplashManagerMixin",
            name = "modifySplashList"
    )
    @WrapOperation(
            method = "@MixinSquared:Handler",
            at = @At(value = "INVOKE", target = "Ljava/util/List;clear()V", remap = false)
    )
    private static void splashManager$clear(final List<String> list, final Operation<Void> original) {
        // I really hope the clear call gets removed in the final release
    }
}

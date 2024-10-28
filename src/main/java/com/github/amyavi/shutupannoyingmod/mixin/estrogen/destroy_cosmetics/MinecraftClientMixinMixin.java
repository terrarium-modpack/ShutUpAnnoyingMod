package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.bawnorton.mixinsquared.TargetHandler;
import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("estrogen")
@Mixin(value = Minecraft.class, priority = 2000)
public abstract class MinecraftClientMixinMixin {
    @TargetHandler(
            mixin = "dev.mayaqq.estrogen.mixin.client.MinecraftClientMixin",
            name = "tick"
    )
    @WrapOperation(
            method = "@MixinSquared:Handler",
            at = @At(value = "INVOKE", target = "Ldev/mayaqq/estrogen/client/cosmetics/model/animation/Animations;tick()V", remap = false)
    )
    private static void animations$tick(final Operation<Void> original) {
    }
}

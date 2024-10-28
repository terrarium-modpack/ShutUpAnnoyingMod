package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.mayaqq.estrogen.client.EstrogenClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("estrogen")
@Mixin(EstrogenClient.class)
public abstract class EstrogenClientMixin {
    @WrapOperation(
            method = "init", remap = false,
            at = @At(value = "INVOKE", target = "Ldev/mayaqq/estrogen/client/cosmetics/EstrogenCosmetics;init()V", remap = false)
    )
    private static void init$estrogenCosmetics(final Operation<Void> original) {
        // Do nothing
    }
}

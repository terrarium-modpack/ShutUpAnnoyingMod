package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import dev.mayaqq.estrogen.client.registry.EstrogenRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;

@RequiresMod("estrogen")
@Mixin(EstrogenRenderer.class)
public abstract class EstrogenRendererMixin {
    @Inject(
            method = "registerEntityLayers", remap = false,
            at = @At("HEAD"), cancellable = true
    )
    private static void registerEntityLayers(final Function<String, EntityRenderer<? extends Player>> getter, final CallbackInfo ci) {
        ci.cancel();
    }
}

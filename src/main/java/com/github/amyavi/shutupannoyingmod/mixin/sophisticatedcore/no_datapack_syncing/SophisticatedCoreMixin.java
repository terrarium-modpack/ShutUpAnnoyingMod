package com.github.amyavi.shutupannoyingmod.mixin.sophisticatedcore.no_datapack_syncing;

import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.p3pp3rf1y.sophisticatedcore.SophisticatedCore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SophisticatedCore.class, remap = false)
public abstract class SophisticatedCoreMixin {
    // Only used for syncing
    @Inject(method = "onResourceReload", cancellable = true, at = @At(value = "HEAD"))
    private static void onResourceReload(final AddReloadListenerEvent event, final CallbackInfo ci) {
        ci.cancel();
    }
}

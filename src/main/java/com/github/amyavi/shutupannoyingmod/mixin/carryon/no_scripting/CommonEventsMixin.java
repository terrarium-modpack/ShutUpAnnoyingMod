package com.github.amyavi.shutupannoyingmod.mixin.carryon.no_scripting;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tschipp.carryon.events.CommonEvents;

@RequiresMod("carryon")
@Mixin(value = CommonEvents.class, remap = false)
public abstract class CommonEventsMixin {
    // Only used for scripting
    @Inject(method = {"onDatapackRegister", "onDatapackSync"}, cancellable = true,
            at = @At(value = "HEAD"))
    private static void onDatapackEvent(final @Coerce Object event, final CallbackInfo ci) {
        ci.cancel();
    }
}

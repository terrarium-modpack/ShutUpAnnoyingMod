package com.github.amyavi.shutupannoyingmod.mixin.estrogen.unfreeze_server_thread;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import dev.mayaqq.estrogen.utils.BoobHttp;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.UUID;

@RequiresMod("estrogen")
@Mixin(BoobHttp.class)
public abstract class BoobHttpMixin {
    // TODO: maybe throw a RuntimeException on <clinit>()?
    @Inject(
            method = "getBoobPeople", remap = false,
            at = @At("HEAD")
    )
    private static void getBoobPeople(final CallbackInfoReturnable<ArrayList<UUID>> ci) {
        ci.cancel();
    }
}

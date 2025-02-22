package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import dev.mayaqq.estrogen.utils.BoobHttp;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.UUID;

@Mixin(value = BoobHttp.class, remap = false)
public abstract class BoobHttpMixin {
    @Inject(method = "getBoobPeople", at = @At("HEAD"), cancellable = true)
    private static void getBoobPeople(final CallbackInfoReturnable<ArrayList<UUID>> cir) {
        // My name is MayaqqDev and I love freezing the server thread!
        cir.setReturnValue(new ArrayList<>());
    }
}

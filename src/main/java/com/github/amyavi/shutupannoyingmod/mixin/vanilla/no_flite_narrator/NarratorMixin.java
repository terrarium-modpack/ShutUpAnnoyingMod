package com.github.amyavi.shutupannoyingmod.mixin.vanilla.no_flite_narrator;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.text2speech.Narrator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Narrator.class)
public interface NarratorMixin {
    @Inject(method = "getNarrator", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V", remap = false),
            cancellable = true)
    private static void error(final CallbackInfoReturnable<Narrator> cir, @Local final Throwable e) {
        if (e.getCause() instanceof UnsatisfiedLinkError) { // No narrator for you :)
            cir.setReturnValue(Narrator.EMPTY);
        }
    }
}

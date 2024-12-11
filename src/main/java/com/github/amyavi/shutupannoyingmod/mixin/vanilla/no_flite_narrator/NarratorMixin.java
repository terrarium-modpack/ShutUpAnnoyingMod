package com.github.amyavi.shutupannoyingmod.mixin.vanilla.no_flite_narrator;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.text2speech.Narrator;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Narrator.class)
public interface NarratorMixin {
    @WrapOperation(
            method = "getNarrator", remap = false,
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V", remap = false)
    )
    private static void getNarrator$error(final Logger instance, final String s, final Throwable e,
                                          final Operation<Void> original) {
        if (e.getCause() instanceof UnsatisfiedLinkError) {
            return;
        }

        original.call(instance, s, e);
    }
}

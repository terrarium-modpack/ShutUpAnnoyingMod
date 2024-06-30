package com.github.amyavi.shutupannoyingmod.mixin.gliders.overlapping_control;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import net.minecraft.client.gui.screens.controls.ControlsScreen;
import net.venturecraft.gliders.util.ClientUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@RequiresMod("vc_gliders")
@Mixin(value = ClientUtil.class)
public abstract class ClientUtilMixin {
    @Inject(method = "povButton", at = @At("HEAD"), cancellable = true, remap = false)
    private static void povButton(final ControlsScreen controlsScreen, final CallbackInfo ci) {
        ci.cancel(); // Not my problem :P
    }
}

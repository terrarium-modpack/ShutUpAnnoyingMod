package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import dev.mayaqq.estrogen.client.config.EstrogenConfigScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@RequiresMod("estrogen")
@Mixin(EstrogenConfigScreen.class)
public abstract class EstrogenConfigScreenMixin {
    @Inject(
            method = "init",
            at = @At(shift = At.Shift.AFTER,
                    value = "INVOKE", target = "Lcom/simibubi/create/foundation/config/ui/BaseConfigScreen;init()V"), cancellable = true
    )
    private void init$postInit(final CallbackInfo ci) {
        ci.cancel();
    }
}

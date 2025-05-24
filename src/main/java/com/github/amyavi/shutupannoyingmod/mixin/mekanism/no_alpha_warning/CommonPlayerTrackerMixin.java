package com.github.amyavi.shutupannoyingmod.mixin.mekanism.no_alpha_warning;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import mekanism.common.CommonPlayerTracker;
import mekanism.common.config.GeneralConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.BooleanSupplier;

@RequiresMod("mekanism")
@Mixin(value = CommonPlayerTracker.class, remap = false)
public abstract class CommonPlayerTrackerMixin {
    @Redirect(method = "onPlayerLoginEvent",
            at = @At(value = "FIELD", target = "Lmekanism/common/config/GeneralConfig;enableAlphaWarning:" +
                    "Ljava/util/function/BooleanSupplier;"))
    private BooleanSupplier onPlayerLoginEvent$enableAlphaWarning(final GeneralConfig instance) {
        return () -> false;
    }
}

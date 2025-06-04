package com.github.amyavi.shutupannoyingmod.mixin.sophisticatedcore.no_config_saving;

import net.p3pp3rf1y.sophisticatedcore.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Config.Common.class, remap = false)
public abstract class ConfigCommonMixin {
    @Inject(method = "saveIfChanged", cancellable = true, at = @At("HEAD"))
    private void saveIfChanged(final CallbackInfo ci) {
        ci.cancel();
    }

    @Mixin(Config.Common.EnabledItems.class)
    private abstract static class EnabledItemsMixin {
        @Inject(method = "addEnabledItemToConfig", cancellable = true, at = @At("HEAD"))
        private void addEnabledItemToConfig(final CallbackInfo ci) {
            ci.cancel();
        }
    }
}

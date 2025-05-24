package com.github.amyavi.shutupannoyingmod.mixin.vanilla.no_experimental_warning;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FeatureFlags.class)
public abstract class FeatureFlagsMixin {
    // still need to complain if vanilla experiments are enabled, but it's fine if it's only modded ones
    @WrapOperation(method = "isExperimental",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/flag/FeatureFlagSet;" +
                    "isSubsetOf(Lnet/minecraft/world/flag/FeatureFlagSet;)Z"))
    private static boolean isExperimental(final FeatureFlagSet flags, final FeatureFlagSet vanillaMask,
                                          final Operation<Boolean> original) {
        return !(flags.contains(FeatureFlags.BUNDLE) || flags.contains(FeatureFlags.TRADE_REBALANCE));
    }
}

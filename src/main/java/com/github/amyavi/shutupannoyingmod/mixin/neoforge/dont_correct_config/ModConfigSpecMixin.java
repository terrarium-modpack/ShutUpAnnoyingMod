package com.github.amyavi.shutupannoyingmod.mixin.neoforge.dont_correct_config;

import com.electronwill.nightconfig.core.UnmodifiableCommentedConfig;
import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("neoforge")
@Mixin(ModConfigSpec.class)
public abstract class ModConfigSpecMixin {
    @WrapOperation(method = "acceptConfig",
            at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/common/ModConfigSpec;isCorrect(Lcom/electronwill/nightconfig/core/UnmodifiableCommentedConfig;)Z"))
    public boolean acceptConfig$isCorrect(final ModConfigSpec instance, final UnmodifiableCommentedConfig config,
                                          final Operation<Boolean> original) {
        return true;
    }
}

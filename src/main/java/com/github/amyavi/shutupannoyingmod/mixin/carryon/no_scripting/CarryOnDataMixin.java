package com.github.amyavi.shutupannoyingmod.mixin.carryon.no_scripting;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tschipp.carryon.common.carry.CarryOnData;
import tschipp.carryon.common.scripting.CarryOnScript;

import java.util.Optional;

@RequiresMod("carryon")
@Mixin(value = CarryOnData.class, remap = false)
public abstract class CarryOnDataMixin {
    @WrapOperation(method = "<init>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/CompoundTag;contains(Ljava/lang/String;)Z",
                    ordinal = 2))
    private boolean init$containsActiveScript(final CompoundTag instance, final String string,
                                              final Operation<Boolean> original) {
        return false;
    }

    @ModifyExpressionValue(method = "getNbt",
            at = @At(value = "FIELD", target = "Ltschipp/carryon/common/carry/CarryOnData;activeScript" +
                    ":Ltschipp/carryon/common/scripting/CarryOnScript;", remap = false))
    private CarryOnScript getNbt$activeScript(final CarryOnScript original) {
        return null;
    }

    @Inject(method = "getActiveScript", at = @At("HEAD"), cancellable = true)
    private void getActiveScript(final CallbackInfoReturnable<Optional<CarryOnScript>> cir) {
        cir.setReturnValue(Optional.empty());
    }
}

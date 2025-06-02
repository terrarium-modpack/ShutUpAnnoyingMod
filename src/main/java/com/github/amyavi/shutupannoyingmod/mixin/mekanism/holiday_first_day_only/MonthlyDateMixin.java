package com.github.amyavi.shutupannoyingmod.mixin.mekanism.holiday_first_day_only;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.time.LocalDate;

@RequiresMod("mekanism")
@Mixin(targets = "mekanism.common.base.holiday.MonthlyDate", remap = false)
public abstract class MonthlyDateMixin {
    @Inject(method = "isToday", at = @At("HEAD"), cancellable = true)
    private void isToday(final @Coerce Object today, final CallbackInfoReturnable<Boolean> cir) {
        if (LocalDate.now().getDayOfMonth() != 1) cir.setReturnValue(false);
    }
}

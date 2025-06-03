package com.github.amyavi.shutupannoyingmod.mixin.carryon.no_nbt_tostring;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tschipp.carryon.CarryOnCommon;
import tschipp.carryon.Constants;
import tschipp.carryon.common.carry.CarryOnData;

@RequiresMod("carryon")
@Mixin(value = CarryOnCommon.class, remap = false)
public abstract class CarryOnCommonMixin {
    // toString on NBT every tick, WTF were they thinking???????
    @Inject(method = "potionLevel", cancellable = true,
            at = @At(value = "INVOKE", target = "Ltschipp/carryon/common/carry/CarryOnData;" +
                    "isCarrying(Ltschipp/carryon/common/carry/CarryOnData$CarryType;)Z", ordinal = 2, remap = false))
    private static void potionLevel$isCarryingBlock(final CarryOnData carry, final Level level,
                                                    final CallbackInfoReturnable<Integer> cir) {
        if (carry.isCarrying(CarryOnData.CarryType.BLOCK)) {
            cir.setReturnValue((int) Constants.COMMON_CONFIG.settings.blockSlownessMultiplier);
            return;
        }

        cir.setReturnValue(0);
    }
}

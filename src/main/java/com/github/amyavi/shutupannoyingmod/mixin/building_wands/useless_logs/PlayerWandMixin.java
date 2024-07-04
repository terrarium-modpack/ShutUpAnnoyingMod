package com.github.amyavi.shutupannoyingmod.mixin.building_wands.useless_logs;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.nicguzzo.wands.wand.PlayerWand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("wands")
@Mixin(PlayerWand.class)
public abstract class PlayerWandMixin {
    @WrapOperation(
            method = "add_player", remap = false,
            at = @At(value = "INVOKE", target = "Lnet/nicguzzo/wands/WandsMod;log(Ljava/lang/String;Z)V", remap = false)
    )
    private static void add_playerLog(final String s, final boolean b, final Operation<Void> original) {
    }

    @WrapOperation(
            method = "remove_player", remap = false,
            at = @At(value = "INVOKE", target = "Lnet/nicguzzo/wands/WandsMod;log(Ljava/lang/String;Z)V", remap = false)
    )
    private static void remove_playerLog(final String s, final boolean b, final Operation<Void> original) {
    }
}

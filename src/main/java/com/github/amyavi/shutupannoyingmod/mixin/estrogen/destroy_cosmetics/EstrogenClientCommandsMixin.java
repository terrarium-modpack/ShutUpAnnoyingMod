package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.mayaqq.estrogen.client.command.EstrogenClientCommands;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("estrogen")
@Mixin(EstrogenClientCommands.class)
public abstract class EstrogenClientCommandsMixin {
    @WrapOperation(
            method = "lambda$register$3",
            at = @At(value = "INVOKE", target = "Ldev/mayaqq/estrogen/client/cosmetics/ui/CosmeticUI;open(Lnet/minecraft/client/gui/screens/Screen;)V")
    )
    private static void openCosmetics$open(final Screen parent, final Operation<Void> original) {
        // TODO: don't register the command
        // Do nothing
    }
}

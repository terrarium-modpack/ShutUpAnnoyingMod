package com.github.amyavi.shutupannoyingmod.mixin.vanilla.no_experimental_warning;

import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldOpenFlows.class)
public abstract class WorldOpenFlowsMixin {
    @ModifyVariable(method = "confirmWorldCreation", at = @At("HEAD"), argsOnly = true)
    private static boolean confirmWorldCreation$isStable(final boolean old) {
        return true;
    }
}

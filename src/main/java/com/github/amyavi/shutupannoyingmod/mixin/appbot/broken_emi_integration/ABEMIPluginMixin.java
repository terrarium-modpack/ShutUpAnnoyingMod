package com.github.amyavi.shutupannoyingmod.mixin.appbot.broken_emi_integration;

import appbot.integration.emi.ABEMIPlugin;
import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import vazkii.botania.client.integration.emi.BotaniaEmiPlugin;

@RequiresMod("appbot")
@Mixin(value = ABEMIPlugin.class, remap = false)
public abstract class ABEMIPluginMixin {
    @Redirect(
            method = "register",
            at = @At(value = "FIELD", target = "Lvazkii/botania/fabric/integration/emi/BotaniaEmiPlugin;MANA_INFUSION:Ldev/emi/emi/api/recipe/EmiRecipeCategory;")
    )
    public EmiRecipeCategory register$manaInfusion() {
        return BotaniaEmiPlugin.MANA_INFUSION;
    }
}

package com.github.amyavi.shutupannoyingmod.mixin.appbot.broken_emi_integration;

import appbot.AppliedBotanics;
import appbot.integration.emi.ABEMIPlugin;
import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import vazkii.botania.client.integration.emi.BotaniaEmiPlugin;

@RequiresMod("appbot")
@Mixin(ABEMIPlugin.class)
public abstract class ABEMIPluginMixin {
    /**
     * @author amyavi
     * @reason Fixes ClassNotFoundException
     */
    @Overwrite(remap = false)
    public void register(final EmiRegistry registry) {
        registry.addWorkstation(BotaniaEmiPlugin.MANA_INFUSION,
                EmiStack.of(AppliedBotanics.getInstance().fluixManaPool()));
    }
}

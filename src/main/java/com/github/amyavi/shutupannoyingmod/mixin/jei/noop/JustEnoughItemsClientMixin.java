package com.github.amyavi.shutupannoyingmod.mixin.jei.noop;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mezz.jei.gui.config.InternalKeyMappings;
import mezz.jei.neoforge.JustEnoughItemsClient;
import mezz.jei.neoforge.events.PermanentEventSubscriptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod({"emi", "jei"})
@Mixin(value = JustEnoughItemsClient.class, remap = false)
public abstract class JustEnoughItemsClientMixin {
    @WrapOperation(method = "<init>",
            at = @At(value = "INVOKE", target = "Lmezz/jei/neoforge/JustEnoughItemsClient;createKeyMappings" +
                    "(Lmezz/jei/neoforge/events/PermanentEventSubscriptions;)" +
                    "Lmezz/jei/gui/config/InternalKeyMappings;"))
    private InternalKeyMappings init$createKeyMappings(final PermanentEventSubscriptions subscriptions,
                                                       final Operation<InternalKeyMappings> original) {
        return new InternalKeyMappings(mapping -> {});
    }
}

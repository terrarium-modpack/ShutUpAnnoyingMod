package com.github.amyavi.shutupannoyingmod.mixin.jei.noop;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mezz.jei.gui.config.InternalKeyMappings;
import mezz.jei.neoforge.JustEnoughItemsClient;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Consumer;

@RequiresMod({"emi", "jei"})
@Mixin(value = JustEnoughItemsClient.class, remap = false)
public abstract class JustEnoughItemsClientMixin {
    @WrapOperation(method = "lambda$register$0",
            at = @At(value = "NEW", target = "(Ljava/util/function/Consumer;)Lmezz/jei/gui/config/InternalKeyMappings;"))
    private static InternalKeyMappings init$createKeyMappings(final Consumer<KeyMapping> registerMethod,
                                                              final Operation<InternalKeyMappings> original) {
        return original.call((Consumer<KeyMapping>) mapping -> {});
    }
}

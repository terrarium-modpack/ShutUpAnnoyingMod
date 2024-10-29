package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.mojang.brigadier.CommandDispatcher;
import dev.mayaqq.estrogen.client.command.EstrogenClientCommands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@RequiresMod("estrogen")
@Mixin(EstrogenClientCommands.class)
public abstract class EstrogenClientCommandsMixin {
    @Inject(
            method = "register", remap = false,
            at = @At("HEAD"), cancellable = true
    )
    private static<T> void register(final CommandDispatcher<T> dispatcher, final EstrogenClientCommands.ClientCommandManager<T> manager,
                                    final CallbackInfo ci) {
        ci.cancel();
    }
}

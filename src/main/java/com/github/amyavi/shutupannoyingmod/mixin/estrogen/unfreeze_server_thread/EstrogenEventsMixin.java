package com.github.amyavi.shutupannoyingmod.mixin.estrogen.unfreeze_server_thread;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.mayaqq.estrogen.registry.EstrogenEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;
import java.util.UUID;

@RequiresMod("estrogen")
@Mixin(EstrogenEvents.class)
public abstract class EstrogenEventsMixin {
    @Inject(
            method = "isBoobPerson", remap = false,
            at = @At("HEAD"), cancellable = true
    )
    private static void isBoobPerson(final UUID uuid, final CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(false);
    }

    @WrapOperation(
            method = "onPlayerJoin", remap = false,
            at = @At(value = "INVOKE", target = "Ljava/util/Set;contains(Ljava/lang/Object;)Z", remap = false)
    )
    private static<T> boolean onPlayerJoin$contains(final Set<T> instance, final Object o, final Operation<Boolean> original) {
        return true; // Not used anywhere
    }
}

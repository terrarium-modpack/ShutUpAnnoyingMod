package com.github.amyavi.shutupannoyingmod.mixin.estrogen.destroy_cosmetics;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.mayaqq.estrogen.registry.EstrogenEvents;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(value = EstrogenEvents.class, remap = false)
public abstract class EstrogenEventsMixin {
    @Inject(method = "isBoobPerson", at = @At("HEAD"), cancellable = true)
    private static void isBoobPerson(final Player player, final CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @WrapOperation(method = "onPlayerJoin",
            at = @At(value = "INVOKE", target = "Ljava/util/Set;contains(Ljava/lang/Object;)Z"))
    private static boolean onPlayerJoin$contains(final Set<String> instance, final Object o,
                                                 final Operation<Boolean> original) {
        return true; // This is fragile, but I don't really care
    }
}

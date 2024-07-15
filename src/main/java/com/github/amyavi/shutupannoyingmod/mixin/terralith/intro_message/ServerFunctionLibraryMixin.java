package com.github.amyavi.shutupannoyingmod.mixin.terralith.intro_message;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ServerFunctionLibrary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;
import java.util.Set;

@RequiresMod("terralith")
@Mixin(ServerFunctionLibrary.class)
public abstract class ServerFunctionLibraryMixin {
    @Unique
    private static final Set<ResourceLocation> BAD_FUNCTIONS = Set.of(
            new ResourceLocation("terralith", "rtp_testing"),
            new ResourceLocation("terralith", "setup"),
            new ResourceLocation("terralith", "toast")
    );

    @WrapOperation(method = "method_29449",
            at = @At(value = "INVOKE", target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false))
    private <K, V> V onAddFunction(final Map<K, V> instance, final Object k, final Object v, final Operation<V> original) {
        // Hello Moderators! :wavesmiley:
        //noinspection SuspiciousMethodCalls
        if (BAD_FUNCTIONS.contains(k)) return null;
        return original.call(instance, k, v);
    }
}

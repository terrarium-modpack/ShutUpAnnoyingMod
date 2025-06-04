package com.github.amyavi.shutupannoyingmod.mixin.sophisticatedcore.no_datapack_syncing;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.p3pp3rf1y.sophisticatedcore.init.ModPayloads;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ModPayloads.class, remap = false)
public abstract class ModPayloadsMixin {
    @WrapOperation(method = "registerPayloads",
            at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/network/registration/PayloadRegistrar;" +
                    "playToClient(Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;" +
                    "Lnet/minecraft/network/codec/StreamCodec;" +
                    "Lnet/neoforged/neoforge/network/handling/IPayloadHandler;)" +
                    "Lnet/neoforged/neoforge/network/registration/PayloadRegistrar;", ordinal = 9))
    private static PayloadRegistrar registerPayloads(final PayloadRegistrar instance,
                                                     final CustomPacketPayload.Type<?> type,
                                                     final StreamCodec<? super RegistryFriendlyByteBuf, ?> reader,
                                                     final IPayloadHandler<?> handler,
                                                     final Operation<PayloadRegistrar> original) {
        return instance;
    }
}

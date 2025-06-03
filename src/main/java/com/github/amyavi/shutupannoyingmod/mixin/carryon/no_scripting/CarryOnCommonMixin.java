package com.github.amyavi.shutupannoyingmod.mixin.carryon.no_scripting;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import tschipp.carryon.CarryOnCommon;
import tschipp.carryon.platform.services.IPlatformHelper;

import java.util.function.BiConsumer;

@RequiresMod("carryon")
@Mixin(value = CarryOnCommon.class, remap = false)
public abstract class CarryOnCommonMixin {
    @WrapOperation(method = "registerClientPackets",
            at = @At(value = "INVOKE", target = "Ltschipp/carryon/platform/services/IPlatformHelper;" +
                    "registerClientboundPacket(Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;" +
                    "Ljava/lang/Class;Lnet/minecraft/network/codec/StreamCodec;Ljava/util/function/BiConsumer;" +
                    "[Ljava/lang/Object;)V", ordinal = 1))
    private static void registerClientPackets$syncScripts(final IPlatformHelper instance,
                                                          final CustomPacketPayload.Type<?> tType,
                                                          final Class<?> tClass, final StreamCodec<?, ?> btStreamCodec,
                                                          final BiConsumer<?, Player> tPlayerBiConsumer,
                                                          final Object[] objects, final Operation<Void> original) {
    }
}

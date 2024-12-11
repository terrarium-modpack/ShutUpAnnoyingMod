package com.github.amyavi.shutupannoyingmod.mixin.cctweaked.global_server_config;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dan200.computercraft.shared.ComputerCraft;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelResource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.nio.file.Path;

@RequiresMod("computercraft")
@Mixin(ComputerCraft.class)
public abstract class ComputerCraftMixin {
    @WrapOperation(
            method = "lambda$init$15",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getWorldPath(Lnet/minecraft/world/level/storage/LevelResource;)Ljava/nio/file/Path;")
    )
    private static Path init$getWorldPath(final MinecraftServer instance, final LevelResource levelResource, final Operation<Path> original) {
        return FabricLoader.getInstance().getConfigDir();
    }
}

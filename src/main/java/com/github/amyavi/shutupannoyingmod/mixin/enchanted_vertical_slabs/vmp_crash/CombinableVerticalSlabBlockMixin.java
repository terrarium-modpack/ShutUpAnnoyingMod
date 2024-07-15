package com.github.amyavi.shutupannoyingmod.mixin.enchanted_vertical_slabs.vmp_crash;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import games.enchanted.registry.types.CombinableVerticalSlabBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("enchanted-vertical-slabs")
@Mixin(CombinableVerticalSlabBlock.class)
public abstract class CombinableVerticalSlabBlockMixin extends Block {
    public CombinableVerticalSlabBlockMixin(final Properties properties) {
        super(properties);
    }

    @WrapOperation(method = "getFluidState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getFluidState()Lnet/minecraft/world/level/material/FluidState;"))
    private FluidState getFluidState(final BlockState state, final Operation<FluidState> original) {
        //noinspection deprecation
        return super.getFluidState(state);
    }
}

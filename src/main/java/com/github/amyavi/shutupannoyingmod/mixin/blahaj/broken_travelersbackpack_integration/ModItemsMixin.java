package com.github.amyavi.shutupannoyingmod.mixin.blahaj.broken_travelersbackpack_integration;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.tiviacz.travelersbackpack.TravelersBackpack;
import com.tiviacz.travelersbackpack.init.ModItems;
import com.tiviacz.travelersbackpack.items.TravelersBackpackItem;
import mc.recraftors.blahaj.Blahaj;
import mc.recraftors.blahaj.compat.DataHolder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@RequiresMod({"blahaj", "travelersbackpack"})
@Mixin(value = ModItems.class, remap = false)
public abstract class ModItemsMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private static void init(final CallbackInfo ci) {
        final Block backpackBlock = (Block) DataHolder.modMap(TravelersBackpack.MODID).get("block");
        final Item backpackItem = new TravelersBackpackItem(backpackBlock,
                new ResourceLocation(Blahaj.MOD_ID, "textures/model/blahaj_backpack.png"));

        Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(Blahaj.MOD_ID, "blahaj_backpack"), backpackItem);
    }
}

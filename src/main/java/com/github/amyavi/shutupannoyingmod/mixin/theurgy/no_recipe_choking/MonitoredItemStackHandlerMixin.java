package com.github.amyavi.shutupannoyingmod.mixin.theurgy.no_recipe_choking;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.klikli_dev.theurgy.content.storage.MonitoredItemStackHandler;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("theurgy")
@Mixin(value = MonitoredItemStackHandler.class, remap = false)
public abstract class MonitoredItemStackHandlerMixin {
    @WrapWithCondition(method = "insertItem",
        at = @At(value = "INVOKE", target = "Lcom/klikli_dev/theurgy/content/storage/MonitoredItemStackHandler;" +
            "onContentTypeChanged(ILnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V"))
    private boolean insertItem$onContentTypeChanged(final MonitoredItemStackHandler instance, final int slot,
                                                    final ItemStack oldStack, final ItemStack newStack) {
        return !ItemStack.isSameItemSameComponents(oldStack, newStack);
    }
}

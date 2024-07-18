package com.github.amyavi.shutupannoyingmod.mixin.jadeaddons.lootr_fix;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.zestyblaze.lootr.block.*;
import net.zestyblaze.lootr.entity.LootrChestMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import snownee.jade.addon.lootr.LootrEntityInfoProvider;
import snownee.jade.addon.lootr.LootrInfoProvider;
import snownee.jade.addon.lootr.LootrInventoryProvider;
import snownee.jade.addon.lootr.LootrPlugin;
import snownee.jade.api.IWailaClientRegistration;

@RequiresMod("jadeaddons")
@Mixin(LootrPlugin.class)
public abstract class LootrPluginMixin {
    /**
     * @author amyavi
     * @reason Fixes ClassNotFoundException
     */
    @Overwrite(remap = false)
    @Environment(EnvType.CLIENT)
    public void registerClient(final IWailaClientRegistration registration) {
        registration.registerBlockComponent(LootrInfoProvider.INSTANCE, LootrBarrelBlock.class);
        registration.registerBlockComponent(LootrInfoProvider.INSTANCE, LootrChestBlock.class);
        registration.registerBlockComponent(LootrInfoProvider.INSTANCE, LootrInventoryBlock.class);
        registration.registerBlockComponent(LootrInfoProvider.INSTANCE, LootrShulkerBlock.class);
        registration.registerBlockComponent(LootrInfoProvider.INSTANCE, LootrTrappedChestBlock.class);
        registration.registerEntityComponent(LootrEntityInfoProvider.INSTANCE, LootrChestMinecartEntity.class);
        registration.registerItemStorageClient(LootrInventoryProvider.INSTANCE);
    }
}

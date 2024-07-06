package com.github.amyavi.shutupannoyingmod.mixin.simplyswords;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.google.gson.JsonElement;
import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ServerAdvancementManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@RequiresMod("simplyswords")
@Mixin(ServerAdvancementManager.class)
public abstract class ServerAdvancementManagerMixin {
    @Unique
    private static final ResourceLocation STUPID_BOOK_ADVANCEMENT =
            new ResourceLocation("simplyswords", "grant_book_on_first_join");

    @Inject(method = "method_20723", at = @At("HEAD"), cancellable = true)
    private void onAddAnnouncement(final Map<ResourceLocation, Advancement.Builder> map, final ResourceLocation resourceLocation,
                     final JsonElement jsonElement, final CallbackInfo ci) {
        // Hello Moderators! :wavesmiley:
        if (resourceLocation.equals(STUPID_BOOK_ADVANCEMENT)) ci.cancel();
    }
}

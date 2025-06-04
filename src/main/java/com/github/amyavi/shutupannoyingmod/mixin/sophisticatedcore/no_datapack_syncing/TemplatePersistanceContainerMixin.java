package com.github.amyavi.shutupannoyingmod.mixin.sophisticatedcore.no_datapack_syncing;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.nbt.CompoundTag;
import net.p3pp3rf1y.sophisticatedcore.common.gui.TemplatePersistanceContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.Map;

@Mixin(value = TemplatePersistanceContainer.class, remap = false)
public abstract class TemplatePersistanceContainerMixin {
    @Inject(method = "exportTemplate", cancellable = true, at = @At(value = "HEAD"))
    private void exportTemplate(final String fileName, final CallbackInfo ci) {
        ci.cancel();
    }

    @WrapOperation(method = "initSlots",
            at = @At(value = "INVOKE", target = "Lnet/p3pp3rf1y/sophisticatedcore/settings/DatapackSettingsTemplateManager;getTemplates()Ljava/util/Map;"))
    private Map<String, Map<String, CompoundTag>> initSlots(final Operation<Map<String, Map<String, CompoundTag>>> original) {
        return Collections.emptyMap();
    }
}

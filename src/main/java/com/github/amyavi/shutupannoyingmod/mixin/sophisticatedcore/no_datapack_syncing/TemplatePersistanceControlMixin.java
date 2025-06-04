package com.github.amyavi.shutupannoyingmod.mixin.sophisticatedcore.no_datapack_syncing;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.p3pp3rf1y.sophisticatedcore.client.gui.TemplatePersistanceControl;
import net.p3pp3rf1y.sophisticatedcore.client.gui.controls.WidgetBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(value = TemplatePersistanceControl.class, remap = false)
public abstract class TemplatePersistanceControlMixin {
    @WrapOperation(method = "<init>",
            slice = @Slice(
                    from = @At(value = "FIELD", target = "Lnet/p3pp3rf1y/sophisticatedcore/client/gui/TemplatePersistanceControl;" +
                            "exportInput:Lnet/p3pp3rf1y/sophisticatedcore/client/gui/controls/TextBox;")),
            at = @At(value = "INVOKE", target = "Lnet/p3pp3rf1y/sophisticatedcore/client/gui/TemplatePersistanceControl;" +
                    "addChild(Lnet/p3pp3rf1y/sophisticatedcore/client/gui/controls/WidgetBase;)" +
                    "Lnet/p3pp3rf1y/sophisticatedcore/client/gui/controls/WidgetBase;"))

    private WidgetBase addChild$afterLoadButton(final TemplatePersistanceControl instance, final WidgetBase widgetBase,
                                                final Operation<WidgetBase> original) {
        return widgetBase;
    }
}

package com.github.amyavi.shutupannoyingmod.mixin.jamlib.allow_jar_renaming;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.jamalam360.jamlib.JarRenamingChecker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;
import java.util.Collections;
import java.util.List;

// I know removing this is probably bad, but it doesn't work anyway, and also
// it creates a useless blank config folder & file.
@RequiresMod("jamlib")
@Mixin(value = JarRenamingChecker.class, remap = false)
public abstract class JarRenamingCheckerMixin {
    @WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Ljava/io/File;exists()Z"))
    private boolean init$exists(final File instance, final Operation<Boolean> original) {
        return true; // Never try creating parent folder / file
    }

    @Inject(method = "getSuspiciousJarsToNotifyAbout", at = @At("HEAD"), cancellable = true)
    private void getSuspiciousJarsToNotifyAbout(final CallbackInfoReturnable<List<String>> cir) {
        cir.setReturnValue(Collections.emptyList());
    }

    @Inject(method = "afterNotify", at = @At("HEAD"), cancellable = true)
    private void afterNotify(final CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "checkJar", at = @At("HEAD"), cancellable = true)
    private void checkJar(final Class<?> clazz, final CallbackInfo ci) {
        ci.cancel();
    }
}

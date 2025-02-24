package com.github.amyavi.shutupannoyingmod.mixin.resourcefulcosmetics.noop;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.teamresourceful.resourcefulcosmetics.CosmeticsHttp;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Map;

@SuppressWarnings("UnstableApiUsage")
@RequiresMod("com_teamresourceful_resourceful-cosmetics-4j")
@Mixin(CosmeticsHttp.class)
public abstract class CosmeticsHttpMixin {
    @Inject(
            method = "get*", remap = false,
            at = @At("HEAD")
    )
    private<T> void get(final String path, final Map<String, String> headers, final HttpResponse.BodyHandler<T> handler,
                        final CallbackInfoReturnable<HttpResponse<T>> cir) throws IOException {
        throw new IOException("noop");
    }

    @Inject(
            method = "post*", remap = false,
            at = @At("HEAD")
    )
    private<T> void post(final String path, final Map<String, String> headers, final String body, final HttpResponse.BodyHandler<T> handler,
                         final CallbackInfoReturnable<HttpResponse<T>> cir) throws IOException {
        throw new IOException("noop");
    }
}

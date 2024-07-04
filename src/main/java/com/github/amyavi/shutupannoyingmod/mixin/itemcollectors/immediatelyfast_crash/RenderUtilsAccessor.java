package com.github.amyavi.shutupannoyingmod.mixin.itemcollectors.immediatelyfast_crash;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.supermartijn642.core.render.RenderConfiguration;
import com.supermartijn642.core.render.RenderUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@RequiresMod("supermartijn642corelib")
@Mixin(RenderUtils.class)
public interface RenderUtilsAccessor {
    @Accessor(value = "LINES", remap = false)
    static RenderConfiguration getLines() {
        throw new AssertionError();
    }

    @Accessor(value = "LINES_NO_DEPTH", remap = false)
    static RenderConfiguration getLinesNoDepth() {
        throw new AssertionError();
    }

    @Accessor(value = "QUADS", remap = false)
    static RenderConfiguration getQuads() {
        throw new AssertionError();
    }

    @Accessor(value = "QUADS_NO_DEPTH", remap = false)
    static RenderConfiguration getQuadsNoDepth() {
        throw new AssertionError();
    }
}

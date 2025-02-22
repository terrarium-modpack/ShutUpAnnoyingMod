package com.github.amyavi.shutupannoyingmod.mixin.blahaj.broken_travelersbackpack_integration;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public final class BlahajMixinCanceller implements MixinCanceller {
    private static final String BROKEN_MIXIN_PACKAGE = "mc.recraftors.blahaj.mixin.compat.travelersbackpack.";

    @Override
    public boolean shouldCancel(final List<String> targetClassNames, final String mixinClassName) {
        return mixinClassName.startsWith(BROKEN_MIXIN_PACKAGE);
    }
}

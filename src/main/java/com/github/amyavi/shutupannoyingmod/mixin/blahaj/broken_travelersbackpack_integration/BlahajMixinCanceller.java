package com.github.amyavi.shutupannoyingmod.mixin.blahaj.broken_travelersbackpack_integration;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;
import java.util.Set;

public final class BlahajMixinCanceller implements MixinCanceller {
    private static final String BROKEN_MIXIN_PACKAGE = "mc.recraftors.blahaj.mixin.compat.travelersbackpack.";
    private static final Set<String> BROKEN_MIXINS = Set.of(
            "and.trinkets.TravelersBackpackFeatureMixin",
            "present.ModItemsMixin", // replaced by us
            "present.ResourceUtilsMixin"
    );

    @Override
    public boolean shouldCancel(final List<String> targetClassNames, final String mixinClassName) {
        if (!mixinClassName.startsWith(BROKEN_MIXIN_PACKAGE)) {
            return false;
        }

        final String mixinName = mixinClassName.substring(BROKEN_MIXIN_PACKAGE.length());
        return BROKEN_MIXINS.contains(mixinName);
    }
}

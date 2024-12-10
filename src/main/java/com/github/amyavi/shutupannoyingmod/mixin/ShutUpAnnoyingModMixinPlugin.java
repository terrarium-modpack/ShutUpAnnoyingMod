package com.github.amyavi.shutupannoyingmod.mixin;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

public final class ShutUpAnnoyingModMixinPlugin implements IMixinConfigPlugin {
    private static final String MIXIN_REQUIRES_MOD_DESC = Type.getDescriptor(RequiresMod.class);
    private static final Logger LOGGER = LoggerFactory.getLogger("shutupannoyingmod");
    private String mixinPackage;

    @Override
    public void onLoad(final String mixinPackage) {
        this.mixinPackage = mixinPackage + ".";
    }

    @Override
    public boolean shouldApplyMixin(final String targetClassName, final String mixinClassName) {
        if (!mixinClassName.startsWith(this.mixinPackage)) {
            LOGGER.warn("Expected mixin '{}' to start with package root '{}', treating as foreign and disabling!",
                    mixinClassName, this.mixinPackage);
            return false;
        }

        final String mixinPath = mixinClassName.replace('.', '/') + ".class";
        try (final InputStream resource = ShutUpAnnoyingModMixinPlugin.class
                .getClassLoader().getResourceAsStream(mixinPath)) {
            if (resource == null) throw new NullPointerException("resource was null");

            final ClassReader classReader = new ClassReader(resource);
            final ClassNode classNode = new ClassNode();
            classReader.accept(classNode,
                    ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
            for (final AnnotationNode annotation : classNode.invisibleAnnotations) {
                if (!annotation.desc.equals(MIXIN_REQUIRES_MOD_DESC)) continue;

                Object valueObject = null;
                for (int i = 0; i < annotation.values.size(); i += 2) {
                    if (!annotation.values.get(i).equals("value")) continue;
                    valueObject = annotation.values.get(i + 1);
                    break;
                }

                if (valueObject == null) break;

                //noinspection unchecked
                final List<String> modIds = (List<String>) valueObject;
                for (final String modId : modIds) {
                    if (!FabricLoader.getInstance().isModLoaded(modId)) {
                        return false;
                    }
                }
            }

        } catch (final IOException | NullPointerException e) {
            LOGGER.error("Failed to scan mixin '{}': ", mixinClassName, e);
        }

        return true;
    }

    @Override
    public void acceptTargets(final Set<String> myTargets, final Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public void preApply(final String targetClassName, final ClassNode targetClass, final String mixinClassName,
                         final IMixinInfo mixinInfo) {
    }


    @Override
    public void postApply(final String targetClassName, final ClassNode targetClass, final String mixinClassName,
                          final IMixinInfo mixinInfo) {
    }
}

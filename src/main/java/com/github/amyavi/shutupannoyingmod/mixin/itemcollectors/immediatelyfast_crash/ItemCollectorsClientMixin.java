package com.github.amyavi.shutupannoyingmod.mixin.itemcollectors.immediatelyfast_crash;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.supermartijn642.core.render.RenderConfiguration;
import com.supermartijn642.itemcollectors.ItemCollectorsClient;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("itemcollectors")
@Mixin(ItemCollectorsClient.class)
public abstract class ItemCollectorsClientMixin {
    @WrapOperation(
            method = "onBlockHighlight",
            at = @At(value = "INVOKE", target = "Lcom/supermartijn642/core/render/RenderUtils;renderBox(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/phys/AABB;FFFZ)V")
    )
    private static void onBlockHighlight$renderBox(final PoseStack poseStack, final AABB aabb, final float red, final float green, final float blue,
                                                  final boolean depthTest, final Operation<Void> original, final @Local(argsOnly = true) WorldRenderContext worldRenderContext) {
        final MultiBufferSource bufferSource = worldRenderContext.consumers();
        if (bufferSource == null) return;
        final RenderConfiguration renderConfiguration = depthTest ? RenderUtilsAccessor.getLines() : RenderUtilsAccessor.getLinesNoDepth();

        final VertexConsumer builder = renderConfiguration.begin(bufferSource);
        final Matrix4f matrix4f = poseStack.last().pose();
        final Matrix3f matrix3f = poseStack.last().normal();

        final VoxelShape shape = Shapes.create(aabb);
        shape.forAllEdges((x1, y1, z1, x2, y2, z2) -> {
            final Vec3 normal = new Vec3(x2 - x1, y2 - y1, z2 - z1);
            normal.normalize();
            builder.vertex(matrix4f, (float) x1, (float) y1, (float) z1).color(red, green, blue, 1).normal(matrix3f, (float) normal.x, (float) normal.y, (float) normal.z).endVertex();
            builder.vertex(matrix4f, (float) x2, (float) y2, (float) z2).color(red, green, blue, 1).normal(matrix3f, (float) normal.x, (float) normal.y, (float) normal.z).endVertex();
        });
    }

    @WrapOperation(
            method = "onBlockHighlight",
            at = @At(value = "INVOKE", target = "Lcom/supermartijn642/core/render/RenderUtils;renderBoxSides(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/phys/AABB;FFFFZ)V")
    )
    private static void onBlockHighlight$renderBoxSides(final PoseStack poseStack, final AABB aabb, final float red, final float green, final float blue, final float alpha,
                                                       final boolean depthTest, final Operation<Void> original, final @Local(argsOnly = true) WorldRenderContext worldRenderContext) {
        final MultiBufferSource bufferSource = worldRenderContext.consumers();
        if (bufferSource == null) return;
        final RenderConfiguration renderConfiguration = depthTest ? RenderUtilsAccessor.getQuads() : RenderUtilsAccessor.getQuadsNoDepth();

        final VertexConsumer builder = renderConfiguration.begin(bufferSource);
        final Matrix4f matrix = poseStack.last().pose();

        final VoxelShape shape = Shapes.create(aabb);
        shape.forAllBoxes((dMinX, dMinY, dMinZ, dMaxX, dMaxY, dMaxZ) -> {
            final float minX = (float) dMinX, maxX = (float) dMaxX;
            final float minY = (float) dMinY, maxY = (float) dMaxY;
            final float minZ = (float) dMinZ, maxZ = (float) dMaxZ;

            builder.vertex(matrix, minX, minY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, maxY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, maxY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, minY, minZ).color(red, green, blue, alpha).endVertex();

            builder.vertex(matrix, minX, minY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, minY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, maxY, maxZ).color(red, green, blue, alpha).endVertex();


            builder.vertex(matrix, minX, minY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, minY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, minY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, minY, maxZ).color(red, green, blue, alpha).endVertex();

            builder.vertex(matrix, minX, maxY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, maxY, minZ).color(red, green, blue, alpha).endVertex();


            builder.vertex(matrix, minX, minY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, minY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, minX, maxY, minZ).color(red, green, blue, alpha).endVertex();

            builder.vertex(matrix, maxX, minY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, maxY, minZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
            builder.vertex(matrix, maxX, minY, maxZ).color(red, green, blue, alpha).endVertex();
        });
    }
}

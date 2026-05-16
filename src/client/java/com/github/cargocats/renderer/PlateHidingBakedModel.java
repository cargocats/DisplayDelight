package com.github.cargocats.renderer;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.block.SmallPlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightProperties;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.fabricmc.fabric.api.client.model.loading.v1.wrapper.WrapperBlockStateModel;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadAtlas;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.SpriteFinder;
import net.minecraft.client.renderer.block.model.BlockStateModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Set;
import java.util.function.Predicate;

public class PlateHidingBakedModel extends WrapperBlockStateModel {
    private final SpriteFinder spriteFinder;
    private static final Set<Identifier> EXCLUDED_SPRITES = Set.of(
            Identifier.fromNamespaceAndPath(DisplayDelight.MOD_ID, "block/wood_support_oak")
    );

    public PlateHidingBakedModel(BlockStateModel wrapped, ModelModifier.AfterBakeBlock.Context context) {
        super(wrapped);
        this.spriteFinder = context.baker().sprites().spriteFinder(QuadAtlas.BLOCK);
    }

    @Override
    public void emitQuads(@NonNull QuadEmitter emitter, @NonNull BlockAndTintGetter blockView, @NonNull BlockPos pos, BlockState state, @NonNull RandomSource random, @NonNull Predicate<@Nullable Direction> cullTest) {
        float offsetY;

        Predicate<MutableQuadView> quadFilter;
        if (state.getBlock() instanceof SmallPlatedFoodBlock && state.getValue(DisplayDelightProperties.PLATE_HIDDEN)) {
            offsetY = -0.0625f;
            quadFilter = quad -> isFromElement(quad, 4, 4, 12, 1, 12);
        } else if (state.getBlock() instanceof PlatedFoodBlock && state.getValue(DisplayDelightProperties.PLATE_HIDDEN)) {
            offsetY = -0.125f;
            quadFilter = quad -> isFromElement(quad, 1, 1, 15, 2, 15);
        } else {
            super.emitQuads(emitter, blockView, pos, state, random, cullTest);
            return;
        }

        emitter.pushTransform(quad -> {
            if (quadFilter.test(quad)) {
                Identifier spriteName;
                try (TextureAtlasSprite sprite = spriteFinder.find(quad)) {
                    spriteName = sprite.contents().name();
                }

                if (EXCLUDED_SPRITES.contains(spriteName)) {
                    return true;
                }

                // Shift everything down after removing the plate
                for (int i = 0; i < 4; i++) {
                    quad.pos(i, quad.x(i), quad.y(i) + offsetY, quad.z(i));
                }
            } else {
                // Disable drawing the quad, targeting the plate
                return false;
            }
            return true;
        });

        super.emitQuads(emitter, blockView, pos, state, random, cullTest);
        emitter.popTransform();
    }

    private boolean isFromElement(MutableQuadView quad,
                                  float fromX, float fromZ,
                                  float toX, float toY, float toZ) {
        float minX = fromX / 16f, minY = (float) 0 / 16f, minZ = fromZ / 16f;
        float maxX = toX / 16f, maxY = toY / 16f, maxZ = toZ / 16f;

        for (int i = 0; i < 4; i++) {
            float x = quad.x(i);
            float y = quad.y(i);
            float z = quad.z(i);

            // Check if this vertex is outside the element's bounds
            if (x < minX - 0.001f || x > maxX + 0.001f ||
                    y < minY - 0.001f || y > maxY + 0.001f ||
                    z < minZ - 0.001f || z > maxZ + 0.001f) {
                return true;
            }
        }
        return false;
    }
}

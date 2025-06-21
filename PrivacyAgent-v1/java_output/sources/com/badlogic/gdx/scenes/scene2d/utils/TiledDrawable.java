package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public class TiledDrawable extends com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable {
    public final com.badlogic.gdx.graphics.Color i;

    public TiledDrawable() {
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public TiledDrawable(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        super(textureRegion);
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public TiledDrawable(com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable textureRegionDrawable) {
        super(textureRegionDrawable);
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable, com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable, com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
        int i;
        float f5;
        float packedColor = batch.getPackedColor();
        batch.setColor(batch.getColor().mul(this.i));
        com.badlogic.gdx.graphics.g2d.TextureRegion region = getRegion();
        float regionWidth = region.getRegionWidth();
        float regionHeight = region.getRegionHeight();
        int i2 = (int) (f3 / regionWidth);
        int i3 = (int) (f4 / regionHeight);
        float f6 = f3 - (i2 * regionWidth);
        float f7 = f4 - (i3 * regionHeight);
        float f8 = f;
        float f9 = f2;
        int i4 = 0;
        while (i4 < i2) {
            float f10 = f2;
            for (int i5 = 0; i5 < i3; i5++) {
                batch.draw(region, f8, f10, regionWidth, regionHeight);
                f10 += regionHeight;
            }
            f8 += regionWidth;
            i4++;
            f9 = f10;
        }
        com.badlogic.gdx.graphics.Texture texture = region.getTexture();
        float u = region.getU();
        float v2 = region.getV2();
        if (f6 > 0.0f) {
            float width = u + (f6 / texture.getWidth());
            float v = region.getV();
            f5 = f2;
            int i6 = 0;
            while (i6 < i3) {
                batch.draw(texture, f8, f5, f6, regionHeight, u, v2, width, v);
                f5 += regionHeight;
                i6++;
                i2 = i2;
                i3 = i3;
            }
            i = i2;
            if (f7 > 0.0f) {
                batch.draw(texture, f8, f5, f6, f7, u, v2, width, v2 - (f7 / texture.getHeight()));
            }
        } else {
            i = i2;
            f5 = f9;
        }
        if (f7 > 0.0f) {
            float u2 = region.getU2();
            float height = v2 - (f7 / texture.getHeight());
            float f11 = f;
            for (int i7 = 0; i7 < i; i7++) {
                batch.draw(texture, f11, f5, regionWidth, f7, u, v2, u2, height);
                f11 += regionWidth;
            }
        }
        batch.setColor(packedColor);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable, com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        throw new java.lang.UnsupportedOperationException();
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.i;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
    public com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable tint(com.badlogic.gdx.graphics.Color color) {
        com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable tiledDrawable = new com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable(this);
        tiledDrawable.i.set(color);
        tiledDrawable.setLeftWidth(getLeftWidth());
        tiledDrawable.setRightWidth(getRightWidth());
        tiledDrawable.setTopHeight(getTopHeight());
        tiledDrawable.setBottomHeight(getBottomHeight());
        return tiledDrawable;
    }
}

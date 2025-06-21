package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public class TextureRegionDrawable extends com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable implements com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable {
    public com.badlogic.gdx.graphics.g2d.TextureRegion h;

    public TextureRegionDrawable() {
    }

    public TextureRegionDrawable(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        setRegion(textureRegion);
    }

    public TextureRegionDrawable(com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable textureRegionDrawable) {
        super(textureRegionDrawable);
        setRegion(textureRegionDrawable.h);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable, com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
        batch.draw(this.h, f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        batch.draw(this.h, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion() {
        return this.h;
    }

    public void setRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        this.h = textureRegion;
        setMinWidth(textureRegion.getRegionWidth());
        setMinHeight(textureRegion.getRegionHeight());
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable tint(com.badlogic.gdx.graphics.Color color) {
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = this.h;
        com.badlogic.gdx.graphics.g2d.Sprite atlasSprite = textureRegion instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion ? new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite((com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) textureRegion) : new com.badlogic.gdx.graphics.g2d.Sprite(textureRegion);
        atlasSprite.setColor(color);
        atlasSprite.setSize(getMinWidth(), getMinHeight());
        com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable spriteDrawable = new com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable(atlasSprite);
        spriteDrawable.setLeftWidth(getLeftWidth());
        spriteDrawable.setRightWidth(getRightWidth());
        spriteDrawable.setTopHeight(getTopHeight());
        spriteDrawable.setBottomHeight(getBottomHeight());
        return spriteDrawable;
    }
}

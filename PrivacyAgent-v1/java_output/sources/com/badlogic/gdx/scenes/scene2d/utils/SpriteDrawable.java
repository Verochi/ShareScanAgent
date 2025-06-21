package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public class SpriteDrawable extends com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable implements com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable {
    public com.badlogic.gdx.graphics.g2d.Sprite h;

    public SpriteDrawable() {
    }

    public SpriteDrawable(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        setSprite(sprite);
    }

    public SpriteDrawable(com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable spriteDrawable) {
        super(spriteDrawable);
        setSprite(spriteDrawable.h);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable, com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.Color color = this.h.getColor();
        float packedColor = batch.getPackedColor();
        this.h.setColor(batch.getColor().mul(color));
        this.h.setRotation(0.0f);
        this.h.setScale(1.0f, 1.0f);
        this.h.setBounds(f, f2, f3, f4);
        this.h.draw(batch);
        this.h.setColor(color);
        batch.setColor(packedColor);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        com.badlogic.gdx.graphics.Color color = this.h.getColor();
        float packedColor = batch.getPackedColor();
        this.h.setColor(batch.getColor().mul(color));
        this.h.setOrigin(f3, f4);
        this.h.setRotation(f9);
        this.h.setScale(f7, f8);
        this.h.setBounds(f, f2, f5, f6);
        this.h.draw(batch);
        this.h.setColor(color);
        batch.setColor(packedColor);
    }

    public com.badlogic.gdx.graphics.g2d.Sprite getSprite() {
        return this.h;
    }

    public void setSprite(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        this.h = sprite;
        setMinWidth(sprite.getWidth());
        setMinHeight(sprite.getHeight());
    }

    public com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable tint(com.badlogic.gdx.graphics.Color color) {
        com.badlogic.gdx.graphics.g2d.Sprite sprite = this.h;
        com.badlogic.gdx.graphics.g2d.Sprite atlasSprite = sprite instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite ? new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite((com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite) sprite) : new com.badlogic.gdx.graphics.g2d.Sprite(sprite);
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

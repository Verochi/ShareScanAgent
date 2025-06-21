package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public class NinePatchDrawable extends com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable implements com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable {
    public com.badlogic.gdx.graphics.g2d.NinePatch h;

    public NinePatchDrawable() {
    }

    public NinePatchDrawable(com.badlogic.gdx.graphics.g2d.NinePatch ninePatch) {
        setPatch(ninePatch);
    }

    public NinePatchDrawable(com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
        setPatch(ninePatchDrawable.h);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable, com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
        this.h.draw(batch, f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.h.draw(batch, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public com.badlogic.gdx.graphics.g2d.NinePatch getPatch() {
        return this.h;
    }

    public void setPatch(com.badlogic.gdx.graphics.g2d.NinePatch ninePatch) {
        this.h = ninePatch;
        setMinWidth(ninePatch.getTotalWidth());
        setMinHeight(ninePatch.getTotalHeight());
        setTopHeight(ninePatch.getPadTop());
        setRightWidth(ninePatch.getPadRight());
        setBottomHeight(ninePatch.getPadBottom());
        setLeftWidth(ninePatch.getPadLeft());
    }

    public com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable tint(com.badlogic.gdx.graphics.Color color) {
        com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable ninePatchDrawable = new com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable(this);
        ninePatchDrawable.setPatch(new com.badlogic.gdx.graphics.g2d.NinePatch(ninePatchDrawable.getPatch(), color));
        return ninePatchDrawable;
    }
}

package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public class BaseDrawable implements com.badlogic.gdx.scenes.scene2d.utils.Drawable {
    public java.lang.String a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;

    public BaseDrawable() {
    }

    public BaseDrawable(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable) {
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) {
            this.a = ((com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) drawable).getName();
        }
        this.b = drawable.getLeftWidth();
        this.c = drawable.getRightWidth();
        this.d = drawable.getTopHeight();
        this.e = drawable.getBottomHeight();
        this.f = drawable.getMinWidth();
        this.g = drawable.getMinHeight();
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public float getBottomHeight() {
        return this.e;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public float getLeftWidth() {
        return this.b;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public float getMinHeight() {
        return this.g;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public float getMinWidth() {
        return this.f;
    }

    public java.lang.String getName() {
        return this.a;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public float getRightWidth() {
        return this.c;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public float getTopHeight() {
        return this.d;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void setBottomHeight(float f) {
        this.e = f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void setLeftWidth(float f) {
        this.b = f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void setMinHeight(float f) {
        this.g = f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void setMinWidth(float f) {
        this.f = f;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void setRightWidth(float f) {
        this.c = f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Drawable
    public void setTopHeight(float f) {
        this.d = f;
    }

    public java.lang.String toString() {
        java.lang.String str = this.a;
        return str == null ? com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(getClass()) : str;
    }
}

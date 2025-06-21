package com.badlogic.gdx.scenes.scene2d.ui;

/* loaded from: classes12.dex */
public class Widget extends com.badlogic.gdx.scenes.scene2d.Actor implements com.badlogic.gdx.scenes.scene2d.utils.Layout {
    public boolean u;
    public boolean t = true;
    public boolean v = true;

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        validate();
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public float getMaxHeight() {
        return 0.0f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public float getMaxWidth() {
        return 0.0f;
    }

    public float getMinHeight() {
        return getPrefHeight();
    }

    public float getMinWidth() {
        return getPrefWidth();
    }

    public float getPrefHeight() {
        return 0.0f;
    }

    public float getPrefWidth() {
        return 0.0f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void invalidate() {
        this.t = true;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void invalidateHierarchy() {
        if (this.v) {
            invalidate();
            java.lang.Object parent = getParent();
            if (parent instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                ((com.badlogic.gdx.scenes.scene2d.utils.Layout) parent).invalidateHierarchy();
            }
        }
    }

    public void layout() {
    }

    public boolean needsLayout() {
        return this.t;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void pack() {
        setSize(getPrefWidth(), getPrefHeight());
        validate();
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void setFillParent(boolean z) {
        this.u = z;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void setLayoutEnabled(boolean z) {
        this.v = z;
        if (z) {
            invalidateHierarchy();
        }
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void sizeChanged() {
        invalidate();
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void validate() {
        float height;
        float f;
        if (this.v) {
            com.badlogic.gdx.scenes.scene2d.Group parent = getParent();
            if (this.u && parent != null) {
                com.badlogic.gdx.scenes.scene2d.Stage stage = getStage();
                if (stage == null || parent != stage.getRoot()) {
                    float width = parent.getWidth();
                    height = parent.getHeight();
                    f = width;
                } else {
                    f = stage.getWidth();
                    height = stage.getHeight();
                }
                setSize(f, height);
            }
            if (this.t) {
                this.t = false;
                layout();
            }
        }
    }
}

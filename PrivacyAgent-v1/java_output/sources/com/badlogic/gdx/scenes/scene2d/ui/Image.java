package com.badlogic.gdx.scenes.scene2d.ui;

/* loaded from: classes12.dex */
public class Image extends com.badlogic.gdx.scenes.scene2d.ui.Widget {
    public float A;
    public float B;
    public com.badlogic.gdx.scenes.scene2d.utils.Drawable C;
    public com.badlogic.gdx.utils.Scaling w;
    public int x;
    public float y;
    public float z;

    public Image() {
        this((com.badlogic.gdx.scenes.scene2d.utils.Drawable) null);
    }

    public Image(com.badlogic.gdx.graphics.Texture texture) {
        this(new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable(new com.badlogic.gdx.graphics.g2d.TextureRegion(texture)));
    }

    public Image(com.badlogic.gdx.graphics.g2d.NinePatch ninePatch) {
        this(new com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable(ninePatch), com.badlogic.gdx.utils.Scaling.stretch, 1);
    }

    public Image(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        this(new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable(textureRegion), com.badlogic.gdx.utils.Scaling.stretch, 1);
    }

    public Image(com.badlogic.gdx.scenes.scene2d.ui.Skin skin, java.lang.String str) {
        this(skin.getDrawable(str), com.badlogic.gdx.utils.Scaling.stretch, 1);
    }

    public Image(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable) {
        this(drawable, com.badlogic.gdx.utils.Scaling.stretch, 1);
    }

    public Image(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable, com.badlogic.gdx.utils.Scaling scaling) {
        this(drawable, scaling, 1);
    }

    public Image(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable, com.badlogic.gdx.utils.Scaling scaling, int i) {
        this.x = 1;
        setDrawable(drawable);
        this.w = scaling;
        this.x = i;
        setSize(getPrefWidth(), getPrefHeight());
    }

    @Override // com.badlogic.gdx.scenes.scene2d.ui.Widget, com.badlogic.gdx.scenes.scene2d.Actor
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        validate();
        com.badlogic.gdx.graphics.Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * f);
        float x = getX();
        float y = getY();
        float scaleX = getScaleX();
        float scaleY = getScaleY();
        if (this.C instanceof com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable) {
            float rotation = getRotation();
            if (scaleX != 1.0f || scaleY != 1.0f || rotation != 0.0f) {
                ((com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable) this.C).draw(batch, x + this.y, y + this.z, getOriginX() - this.y, getOriginY() - this.z, this.A, this.B, scaleX, scaleY, rotation);
                return;
            }
        }
        com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable = this.C;
        if (drawable != null) {
            drawable.draw(batch, x + this.y, y + this.z, this.A * scaleX, this.B * scaleY);
        }
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable getDrawable() {
        return this.C;
    }

    public float getImageHeight() {
        return this.B;
    }

    public float getImageWidth() {
        return this.A;
    }

    public float getImageX() {
        return this.y;
    }

    public float getImageY() {
        return this.z;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.ui.Widget, com.badlogic.gdx.scenes.scene2d.utils.Layout
    public float getMinHeight() {
        return 0.0f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.ui.Widget, com.badlogic.gdx.scenes.scene2d.utils.Layout
    public float getMinWidth() {
        return 0.0f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.ui.Widget, com.badlogic.gdx.scenes.scene2d.utils.Layout
    public float getPrefHeight() {
        com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable = this.C;
        if (drawable != null) {
            return drawable.getMinHeight();
        }
        return 0.0f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.ui.Widget, com.badlogic.gdx.scenes.scene2d.utils.Layout
    public float getPrefWidth() {
        com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable = this.C;
        if (drawable != null) {
            return drawable.getMinWidth();
        }
        return 0.0f;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.ui.Widget, com.badlogic.gdx.scenes.scene2d.utils.Layout
    public void layout() {
        com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable = this.C;
        if (drawable == null) {
            return;
        }
        com.badlogic.gdx.math.Vector2 apply = this.w.apply(drawable.getMinWidth(), this.C.getMinHeight(), getWidth(), getHeight());
        this.A = apply.x;
        this.B = apply.y;
        int i = this.x;
        if ((i & 8) != 0) {
            this.y = 0.0f;
        } else if ((i & 16) != 0) {
            this.y = (int) (r2 - r1);
        } else {
            this.y = (int) ((r2 / 2.0f) - (r1 / 2.0f));
        }
        if ((i & 2) != 0) {
            this.z = (int) (r3 - r0);
        } else if ((i & 4) != 0) {
            this.z = 0.0f;
        } else {
            this.z = (int) ((r3 / 2.0f) - (r0 / 2.0f));
        }
    }

    public void setAlign(int i) {
        this.x = i;
        invalidate();
    }

    public void setDrawable(com.badlogic.gdx.scenes.scene2d.ui.Skin skin, java.lang.String str) {
        setDrawable(skin.getDrawable(str));
    }

    public void setDrawable(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable) {
        if (this.C == drawable) {
            return;
        }
        if (drawable == null) {
            invalidateHierarchy();
        } else if (getPrefWidth() != drawable.getMinWidth() || getPrefHeight() != drawable.getMinHeight()) {
            invalidateHierarchy();
        }
        this.C = drawable;
    }

    public void setScaling(com.badlogic.gdx.utils.Scaling scaling) {
        if (scaling == null) {
            throw new java.lang.IllegalArgumentException("scaling cannot be null.");
        }
        this.w = scaling;
        invalidate();
    }
}

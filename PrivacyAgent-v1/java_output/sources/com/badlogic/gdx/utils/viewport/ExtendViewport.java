package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public class ExtendViewport extends com.badlogic.gdx.utils.viewport.Viewport {
    public float i;
    public float j;
    public float k;
    public float l;

    public ExtendViewport(float f, float f2) {
        this(f, f2, 0.0f, 0.0f, new com.badlogic.gdx.graphics.OrthographicCamera());
    }

    public ExtendViewport(float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4, new com.badlogic.gdx.graphics.OrthographicCamera());
    }

    public ExtendViewport(float f, float f2, float f3, float f4, com.badlogic.gdx.graphics.Camera camera) {
        this.i = f;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        setCamera(camera);
    }

    public ExtendViewport(float f, float f2, com.badlogic.gdx.graphics.Camera camera) {
        this(f, f2, 0.0f, 0.0f, camera);
    }

    public float getMaxWorldHeight() {
        return this.l;
    }

    public float getMaxWorldWidth() {
        return this.k;
    }

    public float getMinWorldHeight() {
        return this.j;
    }

    public float getMinWorldWidth() {
        return this.i;
    }

    public void setMaxWorldHeight(float f) {
        this.l = f;
    }

    public void setMaxWorldWidth(float f) {
        this.k = f;
    }

    public void setMinWorldHeight(float f) {
        this.j = f;
    }

    public void setMinWorldWidth(float f) {
        this.i = f;
    }

    @Override // com.badlogic.gdx.utils.viewport.Viewport
    public void update(int i, int i2, boolean z) {
        float f = this.i;
        float f2 = this.j;
        com.badlogic.gdx.math.Vector2 apply = com.badlogic.gdx.utils.Scaling.fit.apply(f, f2, i, i2);
        int round = java.lang.Math.round(apply.x);
        int round2 = java.lang.Math.round(apply.y);
        if (round < i) {
            float f3 = round2;
            float f4 = f3 / f2;
            float f5 = (i - round) * (f2 / f3);
            float f6 = this.k;
            if (f6 > 0.0f) {
                f5 = java.lang.Math.min(f5, f6 - this.i);
            }
            f += f5;
            round += java.lang.Math.round(f5 * f4);
        } else if (round2 < i2) {
            float f7 = round;
            float f8 = f7 / f;
            float f9 = (i2 - round2) * (f / f7);
            float f10 = this.l;
            if (f10 > 0.0f) {
                f9 = java.lang.Math.min(f9, f10 - this.j);
            }
            f2 += f9;
            round2 += java.lang.Math.round(f9 * f8);
        }
        setWorldSize(f, f2);
        setScreenBounds((i - round) / 2, (i2 - round2) / 2, round, round2);
        apply(z);
    }
}

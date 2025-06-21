package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public class ScreenViewport extends com.badlogic.gdx.utils.viewport.Viewport {
    public float i;

    public ScreenViewport() {
        this(new com.badlogic.gdx.graphics.OrthographicCamera());
    }

    public ScreenViewport(com.badlogic.gdx.graphics.Camera camera) {
        this.i = 1.0f;
        setCamera(camera);
    }

    public float getUnitsPerPixel() {
        return this.i;
    }

    public void setUnitsPerPixel(float f) {
        this.i = f;
    }

    @Override // com.badlogic.gdx.utils.viewport.Viewport
    public void update(int i, int i2, boolean z) {
        setScreenBounds(0, 0, i, i2);
        float f = this.i;
        setWorldSize(i * f, i2 * f);
        apply(z);
    }
}

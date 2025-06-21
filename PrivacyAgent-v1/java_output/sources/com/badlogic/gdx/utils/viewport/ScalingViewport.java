package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public class ScalingViewport extends com.badlogic.gdx.utils.viewport.Viewport {
    public com.badlogic.gdx.utils.Scaling i;

    public ScalingViewport(com.badlogic.gdx.utils.Scaling scaling, float f, float f2) {
        this(scaling, f, f2, new com.badlogic.gdx.graphics.OrthographicCamera());
    }

    public ScalingViewport(com.badlogic.gdx.utils.Scaling scaling, float f, float f2, com.badlogic.gdx.graphics.Camera camera) {
        this.i = scaling;
        setWorldSize(f, f2);
        setCamera(camera);
    }

    public com.badlogic.gdx.utils.Scaling getScaling() {
        return this.i;
    }

    public void setScaling(com.badlogic.gdx.utils.Scaling scaling) {
        this.i = scaling;
    }

    @Override // com.badlogic.gdx.utils.viewport.Viewport
    public void update(int i, int i2, boolean z) {
        com.badlogic.gdx.math.Vector2 apply = this.i.apply(getWorldWidth(), getWorldHeight(), i, i2);
        int round = java.lang.Math.round(apply.x);
        int round2 = java.lang.Math.round(apply.y);
        setScreenBounds((i - round) / 2, (i2 - round2) / 2, round, round2);
        apply(z);
    }
}

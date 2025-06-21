package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public class StretchViewport extends com.badlogic.gdx.utils.viewport.ScalingViewport {
    public StretchViewport(float f, float f2) {
        super(com.badlogic.gdx.utils.Scaling.stretch, f, f2);
    }

    public StretchViewport(float f, float f2, com.badlogic.gdx.graphics.Camera camera) {
        super(com.badlogic.gdx.utils.Scaling.stretch, f, f2, camera);
    }
}

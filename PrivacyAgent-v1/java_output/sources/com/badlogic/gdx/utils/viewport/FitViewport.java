package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public class FitViewport extends com.badlogic.gdx.utils.viewport.ScalingViewport {
    public FitViewport(float f, float f2) {
        super(com.badlogic.gdx.utils.Scaling.fit, f, f2);
    }

    public FitViewport(float f, float f2, com.badlogic.gdx.graphics.Camera camera) {
        super(com.badlogic.gdx.utils.Scaling.fit, f, f2, camera);
    }
}

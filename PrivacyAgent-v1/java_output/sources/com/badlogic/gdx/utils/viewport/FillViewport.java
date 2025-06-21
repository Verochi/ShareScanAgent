package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public class FillViewport extends com.badlogic.gdx.utils.viewport.ScalingViewport {
    public FillViewport(float f, float f2) {
        super(com.badlogic.gdx.utils.Scaling.fill, f, f2);
    }

    public FillViewport(float f, float f2, com.badlogic.gdx.graphics.Camera camera) {
        super(com.badlogic.gdx.utils.Scaling.fill, f, f2, camera);
    }
}

package com.badlogic.gdx.backends.android.surfaceview;

/* loaded from: classes12.dex */
public class FillResolutionStrategy implements com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy {
    @Override // com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy
    public com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy.MeasuredDimension calcMeasures(int i, int i2) {
        return new com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy.MeasuredDimension(android.view.View.MeasureSpec.getSize(i), android.view.View.MeasureSpec.getSize(i2));
    }
}

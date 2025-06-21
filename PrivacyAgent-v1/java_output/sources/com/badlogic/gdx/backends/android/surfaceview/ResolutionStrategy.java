package com.badlogic.gdx.backends.android.surfaceview;

/* loaded from: classes12.dex */
public interface ResolutionStrategy {

    public static class MeasuredDimension {
        public final int height;
        public final int width;

        public MeasuredDimension(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy.MeasuredDimension calcMeasures(int i, int i2);
}

package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
class ExponentialGeometricAverage {
    private int mCount;
    private final int mCutover;
    private final double mDecayConstant;
    private double mValue = -1.0d;

    public ExponentialGeometricAverage(double d) {
        this.mDecayConstant = d;
        this.mCutover = d == 0.0d ? Integer.MAX_VALUE : (int) java.lang.Math.ceil(1.0d / d);
    }

    public void addMeasurement(double d) {
        double d2 = 1.0d - this.mDecayConstant;
        int i = this.mCount;
        if (i > this.mCutover) {
            this.mValue = java.lang.Math.exp((d2 * java.lang.Math.log(this.mValue)) + (this.mDecayConstant * java.lang.Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * i) / (i + 1.0d);
            this.mValue = java.lang.Math.exp((d3 * java.lang.Math.log(this.mValue)) + ((1.0d - d3) * java.lang.Math.log(d)));
        } else {
            this.mValue = d;
        }
        this.mCount++;
    }

    public double getAverage() {
        return this.mValue;
    }

    public void reset() {
        this.mValue = -1.0d;
        this.mCount = 0;
    }
}

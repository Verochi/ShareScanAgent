package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class FloatCounter {
    public float average;
    public int count;
    public float latest;
    public float max;
    public final com.badlogic.gdx.math.WindowedMean mean;
    public float min;
    public float total;
    public float value;

    public FloatCounter(int i) {
        this.mean = i > 1 ? new com.badlogic.gdx.math.WindowedMean(i) : null;
        reset();
    }

    public void put(float f) {
        this.latest = f;
        float f2 = this.total + f;
        this.total = f2;
        int i = this.count + 1;
        this.count = i;
        this.average = f2 / i;
        com.badlogic.gdx.math.WindowedMean windowedMean = this.mean;
        if (windowedMean != null) {
            windowedMean.addValue(f);
            this.value = this.mean.getMean();
        } else {
            this.value = f;
        }
        com.badlogic.gdx.math.WindowedMean windowedMean2 = this.mean;
        if (windowedMean2 == null || windowedMean2.hasEnoughData()) {
            float f3 = this.value;
            if (f3 < this.min) {
                this.min = f3;
            }
            if (f3 > this.max) {
                this.max = f3;
            }
        }
    }

    public void reset() {
        this.count = 0;
        this.total = 0.0f;
        this.min = Float.MAX_VALUE;
        this.max = Float.MIN_VALUE;
        this.average = 0.0f;
        this.latest = 0.0f;
        this.value = 0.0f;
        com.badlogic.gdx.math.WindowedMean windowedMean = this.mean;
        if (windowedMean != null) {
            windowedMean.clear();
        }
    }
}

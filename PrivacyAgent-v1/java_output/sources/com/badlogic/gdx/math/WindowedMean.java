package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public final class WindowedMean {
    public float[] a;
    public int c;
    public int b = 0;
    public float d = 0.0f;
    public boolean e = true;

    public WindowedMean(int i) {
        this.a = new float[i];
    }

    public void addValue(float f) {
        int i = this.b;
        float[] fArr = this.a;
        if (i < fArr.length) {
            this.b = i + 1;
        }
        int i2 = this.c;
        int i3 = i2 + 1;
        this.c = i3;
        fArr[i2] = f;
        if (i3 > fArr.length - 1) {
            this.c = 0;
        }
        this.e = true;
    }

    public void clear() {
        int i = 0;
        this.b = 0;
        this.c = 0;
        while (true) {
            float[] fArr = this.a;
            if (i >= fArr.length) {
                this.e = true;
                return;
            } else {
                fArr[i] = 0.0f;
                i++;
            }
        }
    }

    public float getLatest() {
        float[] fArr = this.a;
        int i = this.c;
        if (i - 1 == -1) {
            i = fArr.length;
        }
        return fArr[i - 1];
    }

    public float getMean() {
        float[] fArr;
        float f = 0.0f;
        if (!hasEnoughData()) {
            return 0.0f;
        }
        if (this.e) {
            int i = 0;
            while (true) {
                fArr = this.a;
                if (i >= fArr.length) {
                    break;
                }
                f += fArr[i];
                i++;
            }
            this.d = f / fArr.length;
            this.e = false;
        }
        return this.d;
    }

    public float getOldest() {
        int i = this.c;
        float[] fArr = this.a;
        return i == fArr.length + (-1) ? fArr[0] : fArr[i + 1];
    }

    public int getWindowSize() {
        return this.a.length;
    }

    public boolean hasEnoughData() {
        return this.b >= this.a.length;
    }

    public float standardDeviation() {
        float f = 0.0f;
        if (!hasEnoughData()) {
            return 0.0f;
        }
        float mean = getMean();
        int i = 0;
        while (true) {
            float[] fArr = this.a;
            if (i >= fArr.length) {
                return (float) java.lang.Math.sqrt(f / fArr.length);
            }
            float f2 = fArr[i];
            f += (f2 - mean) * (f2 - mean);
            i++;
        }
    }
}

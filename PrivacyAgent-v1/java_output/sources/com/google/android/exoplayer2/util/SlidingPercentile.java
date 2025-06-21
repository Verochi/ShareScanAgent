package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public class SlidingPercentile {
    public static final java.util.Comparator<com.google.android.exoplayer2.util.SlidingPercentile.Sample> h = new com.google.android.exoplayer2.util.a();
    public static final java.util.Comparator<com.google.android.exoplayer2.util.SlidingPercentile.Sample> i = new com.google.android.exoplayer2.util.b();
    public final int a;
    public int e;
    public int f;
    public int g;
    public final com.google.android.exoplayer2.util.SlidingPercentile.Sample[] c = new com.google.android.exoplayer2.util.SlidingPercentile.Sample[5];
    public final java.util.ArrayList<com.google.android.exoplayer2.util.SlidingPercentile.Sample> b = new java.util.ArrayList<>();
    public int d = -1;

    public static class Sample {
        public int a;
        public int b;
        public float c;

        public Sample() {
        }

        public /* synthetic */ Sample(com.google.android.exoplayer2.util.SlidingPercentile.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public SlidingPercentile(int i2) {
        this.a = i2;
    }

    public static /* synthetic */ int e(com.google.android.exoplayer2.util.SlidingPercentile.Sample sample, com.google.android.exoplayer2.util.SlidingPercentile.Sample sample2) {
        return sample.a - sample2.a;
    }

    public static /* synthetic */ int f(com.google.android.exoplayer2.util.SlidingPercentile.Sample sample, com.google.android.exoplayer2.util.SlidingPercentile.Sample sample2) {
        return java.lang.Float.compare(sample.c, sample2.c);
    }

    public void addSample(int i2, float f) {
        com.google.android.exoplayer2.util.SlidingPercentile.Sample sample;
        c();
        int i3 = this.g;
        if (i3 > 0) {
            com.google.android.exoplayer2.util.SlidingPercentile.Sample[] sampleArr = this.c;
            int i4 = i3 - 1;
            this.g = i4;
            sample = sampleArr[i4];
        } else {
            sample = new com.google.android.exoplayer2.util.SlidingPercentile.Sample(null);
        }
        int i5 = this.e;
        this.e = i5 + 1;
        sample.a = i5;
        sample.b = i2;
        sample.c = f;
        this.b.add(sample);
        this.f += i2;
        while (true) {
            int i6 = this.f;
            int i7 = this.a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            com.google.android.exoplayer2.util.SlidingPercentile.Sample sample2 = this.b.get(0);
            int i9 = sample2.b;
            if (i9 <= i8) {
                this.f -= i9;
                this.b.remove(0);
                int i10 = this.g;
                if (i10 < 5) {
                    com.google.android.exoplayer2.util.SlidingPercentile.Sample[] sampleArr2 = this.c;
                    this.g = i10 + 1;
                    sampleArr2[i10] = sample2;
                }
            } else {
                sample2.b = i9 - i8;
                this.f -= i8;
            }
        }
    }

    public final void c() {
        if (this.d != 1) {
            java.util.Collections.sort(this.b, h);
            this.d = 1;
        }
    }

    public final void d() {
        if (this.d != 0) {
            java.util.Collections.sort(this.b, i);
            this.d = 0;
        }
    }

    public float getPercentile(float f) {
        d();
        float f2 = f * this.f;
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            com.google.android.exoplayer2.util.SlidingPercentile.Sample sample = this.b.get(i3);
            i2 += sample.b;
            if (i2 >= f2) {
                return sample.c;
            }
        }
        if (this.b.isEmpty()) {
            return Float.NaN;
        }
        return this.b.get(r5.size() - 1).c;
    }

    public void reset() {
        this.b.clear();
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
}

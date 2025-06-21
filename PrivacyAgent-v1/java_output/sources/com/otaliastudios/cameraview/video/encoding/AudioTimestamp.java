package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
class AudioTimestamp {
    public int a;
    public long b;
    public long c;
    public long d;

    public AudioTimestamp(int i) {
        this.a = i;
    }

    public static long a(long j, int i) {
        return (j * 1000) / i;
    }

    public static long b(long j, int i) {
        return (j * 1000000) / i;
    }

    public int c(int i) {
        if (this.d == 0) {
            return 0;
        }
        return (int) (this.d / b(i, this.a));
    }

    public long d(long j) {
        return j - this.d;
    }

    public long e(int i) {
        long j = i;
        long b = b(j, this.a);
        long nanoTime = (java.lang.System.nanoTime() / 1000) - b;
        long j2 = this.c;
        if (j2 == 0) {
            this.b = nanoTime;
        }
        long b2 = this.b + b(j2, this.a);
        long j3 = nanoTime - b2;
        if (j3 < b * 2) {
            this.d = 0L;
            this.c += j;
            return b2;
        }
        this.b = nanoTime;
        this.c = j;
        this.d = j3;
        return nanoTime;
    }
}

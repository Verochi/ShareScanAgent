package com.aliyun.svideosdk.editor.pplayer;

/* loaded from: classes12.dex */
public class a {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f;
    private long g;

    public a(long j, long j2, long j3, long j4, int i) {
        this.a = j;
        this.b = j2;
        this.d = j3;
        this.e = j4;
        this.f = i;
        long j5 = j2 - j;
        this.c = j5;
        this.g = j5;
    }

    public long a() {
        return this.e;
    }

    public long a(long j) {
        long j2 = this.c;
        if (j2 == 0) {
            return 0L;
        }
        if (this.g >= j2) {
            long j3 = this.a + (j % j2);
            long j4 = this.b;
            return j3 > j4 ? j4 : j3;
        }
        if (this.f == 0) {
            long j5 = this.a + (j % j2);
            long j6 = this.b;
            return j5 > j6 ? j6 : j5;
        }
        long j7 = this.c;
        long j8 = this.a + (((long) ((j * (j7 * 1.0d)) / this.g)) % j7);
        long j9 = this.b;
        return j8 > j9 ? j9 : j8;
    }

    public long b() {
        return this.d;
    }

    public void b(long j) {
        long j2 = this.e;
        if (j2 == 0 || j <= j2) {
            this.g = j;
        } else {
            this.g = j2;
        }
    }

    public long c() {
        return this.g;
    }
}

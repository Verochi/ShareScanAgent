package com.aliyun.svideosdk.a.d;

/* loaded from: classes12.dex */
public class c implements com.aliyun.svideosdk.a.d.a {
    private volatile boolean a = false;
    private long b = 0;
    private long c = 0;
    private volatile int d = 0;
    private volatile long e = 0;
    private volatile long f = 0;
    private volatile int g = 0;
    private volatile float h = 0.0f;
    private long i = 0;

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void a() {
        if (this.a) {
            this.e = (long) ((this.b * 1.0f) / this.g);
            this.h = (this.g * 1000.0f) / (java.lang.System.currentTimeMillis() - this.i);
            this.a = false;
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void b() {
        if (this.a) {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.c;
            this.b += currentTimeMillis;
            this.g++;
            if (currentTimeMillis >= 80) {
                this.d++;
            }
            if (currentTimeMillis > this.f) {
                this.f = currentTimeMillis;
            }
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void c() {
        if (this.a) {
            this.c = java.lang.System.currentTimeMillis();
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public long d() {
        return this.e;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public int e() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void f() {
        if (!this.a) {
            this.h = 0.0f;
            this.i = java.lang.System.currentTimeMillis();
            this.b = 0L;
            this.f = 0L;
            this.e = 0L;
            this.g = 0;
            this.d = 0;
            this.a = true;
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public float g() {
        return this.h;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public long h() {
        return this.f;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public int i() {
        return this.g;
    }
}

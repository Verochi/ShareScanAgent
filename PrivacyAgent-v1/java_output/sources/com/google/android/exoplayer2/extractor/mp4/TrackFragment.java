package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
final class TrackFragment {
    public com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public boolean m;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox o;
    public boolean q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f353s;
    public long[] g = new long[0];
    public int[] h = new int[0];
    public int[] i = new int[0];
    public int[] j = new int[0];
    public long[] k = new long[0];
    public boolean[] l = new boolean[0];
    public boolean[] n = new boolean[0];
    public final com.google.android.exoplayer2.util.ParsableByteArray p = new com.google.android.exoplayer2.util.ParsableByteArray();

    public void a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.readFully(this.p.getData(), 0, this.p.limit());
        this.p.setPosition(0);
        this.q = false;
    }

    public void b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.p.getData(), 0, this.p.limit());
        this.p.setPosition(0);
        this.q = false;
    }

    public long c(int i) {
        return this.k[i] + this.j[i];
    }

    public void d(int i) {
        this.p.reset(i);
        this.m = true;
        this.q = true;
    }

    public void e(int i, int i2) {
        this.e = i;
        this.f = i2;
        if (this.h.length < i) {
            this.g = new long[i];
            this.h = new int[i];
        }
        if (this.i.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.i = new int[i3];
            this.j = new int[i3];
            this.k = new long[i3];
            this.l = new boolean[i3];
            this.n = new boolean[i3];
        }
    }

    public void f() {
        this.e = 0;
        this.r = 0L;
        this.f353s = false;
        this.m = false;
        this.q = false;
        this.o = null;
    }

    public boolean g(int i) {
        return this.m && this.n[i];
    }
}

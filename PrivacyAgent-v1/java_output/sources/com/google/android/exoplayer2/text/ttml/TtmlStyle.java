package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes22.dex */
final class TtmlStyle {

    @androidx.annotation.Nullable
    public java.lang.String a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public float k;

    @androidx.annotation.Nullable
    public java.lang.String l;

    @androidx.annotation.Nullable
    public android.text.Layout.Alignment o;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int m = -1;
    public int n = -1;
    public int p = -1;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle A(int i) {
        this.n = i;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle B(int i) {
        this.m = i;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle C(@androidx.annotation.Nullable android.text.Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle D(boolean z) {
        this.p = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle E(boolean z) {
        this.g = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle a(@androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        return o(ttmlStyle, true);
    }

    public int b() {
        if (this.e) {
            return this.d;
        }
        throw new java.lang.IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.c) {
            return this.b;
        }
        throw new java.lang.IllegalStateException("Font color has not been defined.");
    }

    @androidx.annotation.Nullable
    public java.lang.String d() {
        return this.a;
    }

    public float e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    @androidx.annotation.Nullable
    public java.lang.String g() {
        return this.l;
    }

    public int h() {
        return this.n;
    }

    public int i() {
        return this.m;
    }

    public int j() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    @androidx.annotation.Nullable
    public android.text.Layout.Alignment k() {
        return this.o;
    }

    public boolean l() {
        return this.p == 1;
    }

    public boolean m() {
        return this.e;
    }

    public boolean n() {
        return this.c;
    }

    public final com.google.android.exoplayer2.text.ttml.TtmlStyle o(@androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, boolean z) {
        int i;
        android.text.Layout.Alignment alignment;
        java.lang.String str;
        if (ttmlStyle != null) {
            if (!this.c && ttmlStyle.c) {
                t(ttmlStyle.b);
            }
            if (this.h == -1) {
                this.h = ttmlStyle.h;
            }
            if (this.i == -1) {
                this.i = ttmlStyle.i;
            }
            if (this.a == null && (str = ttmlStyle.a) != null) {
                this.a = str;
            }
            if (this.f == -1) {
                this.f = ttmlStyle.f;
            }
            if (this.g == -1) {
                this.g = ttmlStyle.g;
            }
            if (this.n == -1) {
                this.n = ttmlStyle.n;
            }
            if (this.o == null && (alignment = ttmlStyle.o) != null) {
                this.o = alignment;
            }
            if (this.p == -1) {
                this.p = ttmlStyle.p;
            }
            if (this.j == -1) {
                this.j = ttmlStyle.j;
                this.k = ttmlStyle.k;
            }
            if (z && !this.e && ttmlStyle.e) {
                r(ttmlStyle.d);
            }
            if (z && this.m == -1 && (i = ttmlStyle.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public boolean p() {
        return this.f == 1;
    }

    public boolean q() {
        return this.g == 1;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle r(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle s(boolean z) {
        this.h = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle t(int i) {
        this.b = i;
        this.c = true;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle u(@androidx.annotation.Nullable java.lang.String str) {
        this.a = str;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle v(float f) {
        this.k = f;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle w(int i) {
        this.j = i;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle x(@androidx.annotation.Nullable java.lang.String str) {
        this.l = str;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle y(boolean z) {
        this.i = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle z(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }
}

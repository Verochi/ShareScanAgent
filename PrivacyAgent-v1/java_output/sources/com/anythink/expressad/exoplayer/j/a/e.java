package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public class e implements java.lang.Comparable<com.anythink.expressad.exoplayer.j.a.e> {
    public final java.lang.String a;
    public final long b;
    public final long c;
    public final boolean d;

    @androidx.annotation.Nullable
    public final java.io.File e;
    public final long f;

    private e(java.lang.String str, long j, long j2) {
        this(str, j, j2, -9223372036854775807L, null);
    }

    public e(java.lang.String str, long j, long j2, long j3, @androidx.annotation.Nullable java.io.File file) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    private int a(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.j.a.e eVar) {
        if (!this.a.equals(eVar.a)) {
            return this.a.compareTo(eVar.a);
        }
        long j = this.b - eVar.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public final boolean a() {
        return this.c == -1;
    }

    public final boolean b() {
        return !this.d;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.j.a.e eVar) {
        com.anythink.expressad.exoplayer.j.a.e eVar2 = eVar;
        if (!this.a.equals(eVar2.a)) {
            return this.a.compareTo(eVar2.a);
        }
        long j = this.b - eVar2.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }
}

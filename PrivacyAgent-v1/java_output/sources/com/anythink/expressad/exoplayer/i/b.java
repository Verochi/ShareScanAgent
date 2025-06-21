package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public abstract class b implements com.anythink.expressad.exoplayer.i.f {
    private final com.anythink.expressad.exoplayer.m[] a;
    private final long[] b;
    private int c;
    protected final com.anythink.expressad.exoplayer.h.ae g;
    protected final int h;
    protected final int[] i;

    public static final class a implements java.util.Comparator<com.anythink.expressad.exoplayer.m> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static int a(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
            return mVar2.d - mVar.d;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
            return mVar2.d - mVar.d;
        }
    }

    public b(com.anythink.expressad.exoplayer.h.ae aeVar, int... iArr) {
        int i = 0;
        com.anythink.expressad.exoplayer.k.a.b(iArr.length > 0);
        this.g = (com.anythink.expressad.exoplayer.h.ae) com.anythink.expressad.exoplayer.k.a.a(aeVar);
        int length = iArr.length;
        this.h = length;
        this.a = new com.anythink.expressad.exoplayer.m[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.a[i2] = aeVar.a(iArr[i2]);
        }
        java.util.Arrays.sort(this.a, new com.anythink.expressad.exoplayer.i.b.a((byte) 0));
        this.i = new int[this.h];
        while (true) {
            int i3 = this.h;
            if (i >= i3) {
                this.b = new long[i3];
                return;
            } else {
                this.i[i] = aeVar.a(this.a[i]);
                i++;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public int a(long j, java.util.List<? extends com.anythink.expressad.exoplayer.h.b.i> list) {
        return list.size();
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        for (int i = 0; i < this.h; i++) {
            if (this.a[i] == mVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final com.anythink.expressad.exoplayer.m a(int i) {
        return this.a[i];
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public void a() {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public void a(float f) {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final boolean a(int i, long j) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean b = b(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.h && !b) {
            b = (i2 == i || b(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (!b) {
            return false;
        }
        long[] jArr = this.b;
        jArr[i] = java.lang.Math.max(jArr[i], elapsedRealtime + j);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b(int i) {
        return this.i[i];
    }

    public final boolean b(int i, long j) {
        return this.b[i] > j;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c(int i) {
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.i[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void e() {
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.anythink.expressad.exoplayer.i.b bVar = (com.anythink.expressad.exoplayer.i.b) obj;
            if (this.g == bVar.g && java.util.Arrays.equals(this.i, bVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final com.anythink.expressad.exoplayer.h.ae f() {
        return this.g;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int g() {
        return this.i.length;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final com.anythink.expressad.exoplayer.m h() {
        return this.a[b()];
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = (java.lang.System.identityHashCode(this.g) * 31) + java.util.Arrays.hashCode(this.i);
        }
        return this.c;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int i() {
        return this.i[b()];
    }
}

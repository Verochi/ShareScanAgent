package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public abstract class ae {
    public static final com.anythink.expressad.exoplayer.ae a = new com.anythink.expressad.exoplayer.ae.AnonymousClass1();

    /* renamed from: com.anythink.expressad.exoplayer.ae$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.exoplayer.ae {
        @Override // com.anythink.expressad.exoplayer.ae
        public final int a(java.lang.Object obj) {
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return 0;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return 0;
        }
    }

    public static final class a {
        public java.lang.Object a;
        public java.lang.Object b;
        public int c;
        public long d;
        private long e;
        private com.anythink.expressad.exoplayer.h.a.a f;

        private long e() {
            return com.anythink.expressad.exoplayer.b.a(this.d);
        }

        private long f() {
            return this.d;
        }

        public final int a(int i, int i2) {
            return this.f.i[i].a(i2);
        }

        public final int a(long j) {
            com.anythink.expressad.exoplayer.h.a.a aVar = this.f;
            int length = aVar.h.length - 1;
            while (length >= 0) {
                long j2 = aVar.h[length];
                if (j2 != Long.MIN_VALUE && j2 <= j) {
                    break;
                }
                length--;
            }
            if (length < 0 || !aVar.i[length].a()) {
                return -1;
            }
            return length;
        }

        public final long a() {
            return com.anythink.expressad.exoplayer.b.a(this.e);
        }

        public final long a(int i) {
            return this.f.h[i];
        }

        public final com.anythink.expressad.exoplayer.ae.a a(java.lang.Object obj, java.lang.Object obj2, int i, long j, long j2, com.anythink.expressad.exoplayer.h.a.a aVar) {
            this.a = obj;
            this.b = obj2;
            this.c = i;
            this.d = j;
            this.e = j2;
            this.f = aVar;
            return this;
        }

        public final com.anythink.expressad.exoplayer.ae.a a(java.lang.Object obj, java.lang.Object obj2, long j, long j2) {
            return a(obj, obj2, 0, j, j2, com.anythink.expressad.exoplayer.h.a.a.f);
        }

        public final int b(int i) {
            return this.f.i[i].a(-1);
        }

        public final int b(long j) {
            com.anythink.expressad.exoplayer.h.a.a aVar = this.f;
            int i = 0;
            while (true) {
                long[] jArr = aVar.h;
                if (i >= jArr.length) {
                    break;
                }
                long j2 = jArr[i];
                if (j2 == Long.MIN_VALUE || (j < j2 && aVar.i[i].a())) {
                    break;
                }
                i++;
            }
            if (i < aVar.h.length) {
                return i;
            }
            return -1;
        }

        public final long b() {
            return this.e;
        }

        public final boolean b(int i, int i2) {
            com.anythink.expressad.exoplayer.h.a.a.C0195a c0195a = this.f.i[i];
            return (c0195a.a == -1 || c0195a.c[i2] == 0) ? false : true;
        }

        public final int c() {
            return this.f.g;
        }

        public final long c(int i, int i2) {
            com.anythink.expressad.exoplayer.h.a.a.C0195a c0195a = this.f.i[i];
            if (c0195a.a != -1) {
                return c0195a.d[i2];
            }
            return -9223372036854775807L;
        }

        public final boolean c(int i) {
            return !this.f.i[i].a();
        }

        public final int d(int i) {
            return this.f.i[i].a;
        }

        public final long d() {
            return this.f.j;
        }
    }

    public static final class b {

        @androidx.annotation.Nullable
        public java.lang.Object a;
        public long b;
        public long c;
        public boolean d;
        public boolean e;
        public int f;
        public int g;
        public long h;
        public long i;
        public long j;

        private long a() {
            return com.anythink.expressad.exoplayer.b.a(this.h);
        }

        private long b() {
            return this.h;
        }

        private long c() {
            return com.anythink.expressad.exoplayer.b.a(this.i);
        }

        private long d() {
            return this.i;
        }

        private long e() {
            return com.anythink.expressad.exoplayer.b.a(this.j);
        }

        private long f() {
            return this.j;
        }

        public final com.anythink.expressad.exoplayer.ae.b a(@androidx.annotation.Nullable java.lang.Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, long j5) {
            this.a = obj;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.h = j3;
            this.i = j4;
            this.f = 0;
            this.g = 0;
            this.j = j5;
            return this;
        }
    }

    private com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar) {
        return a(i, aVar, false);
    }

    private com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar) {
        return a(i, bVar, false);
    }

    public int a(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == a(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == a(z) ? b(z) : i + 1;
        }
        throw new java.lang.IllegalStateException();
    }

    public final int a(int i, com.anythink.expressad.exoplayer.ae.a aVar, com.anythink.expressad.exoplayer.ae.b bVar, int i2, boolean z) {
        int i3 = a(i, aVar, false).c;
        if (a(i3, bVar, false).g != i) {
            return i + 1;
        }
        int a2 = a(i3, i2, z);
        if (a2 == -1) {
            return -1;
        }
        return a(a2, bVar, false).f;
    }

    public abstract int a(java.lang.Object obj);

    public int a(boolean z) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public final android.util.Pair<java.lang.Integer, java.lang.Long> a(com.anythink.expressad.exoplayer.ae.b bVar, com.anythink.expressad.exoplayer.ae.a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0L);
    }

    public final android.util.Pair<java.lang.Integer, java.lang.Long> a(com.anythink.expressad.exoplayer.ae.b bVar, com.anythink.expressad.exoplayer.ae.a aVar, int i, long j, long j2) {
        com.anythink.expressad.exoplayer.k.a.a(i, b());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.h;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.f;
        long j3 = bVar.j + j;
        long j4 = a(i2, aVar, false).d;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < bVar.g) {
            j3 -= j4;
            i2++;
            j4 = a(i2, aVar, false).d;
        }
        return android.util.Pair.create(java.lang.Integer.valueOf(i2), java.lang.Long.valueOf(j3));
    }

    public abstract com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z);

    public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z) {
        return a(i, bVar, z, 0L);
    }

    public abstract com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j);

    public final boolean a() {
        return b() == 0;
    }

    public abstract int b();

    public int b(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == b(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == b(z) ? a(z) : i - 1;
        }
        throw new java.lang.IllegalStateException();
    }

    public int b(boolean z) {
        return a() ? -1 : 0;
    }

    public final boolean b(int i, com.anythink.expressad.exoplayer.ae.a aVar, com.anythink.expressad.exoplayer.ae.b bVar, int i2, boolean z) {
        return a(i, aVar, bVar, i2, z) == -1;
    }

    public abstract int c();
}

package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public interface s {

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final long d;

        public a(int i) {
            this(i, -1L);
        }

        public a(int i, int i2, int i3, long j) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = j;
        }

        public a(int i, long j) {
            this(i, -1, -1, j);
        }

        public final com.anythink.expressad.exoplayer.h.s.a a(int i) {
            return this.a == i ? this : new com.anythink.expressad.exoplayer.h.s.a(i, this.b, this.c, this.d);
        }

        public final boolean a() {
            return this.b != -1;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.h.s.a.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.h.s.a aVar = (com.anythink.expressad.exoplayer.h.s.a) obj;
                if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((((((this.a + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d);
        }
    }

    public interface b {
        void a(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj);
    }

    com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar);

    void a(android.os.Handler handler, com.anythink.expressad.exoplayer.h.t tVar);

    void a(com.anythink.expressad.exoplayer.h.r rVar);

    void a(com.anythink.expressad.exoplayer.h.s.b bVar);

    void a(com.anythink.expressad.exoplayer.h.t tVar);

    void a(com.anythink.expressad.exoplayer.h hVar, boolean z, com.anythink.expressad.exoplayer.h.s.b bVar);

    void b();
}
